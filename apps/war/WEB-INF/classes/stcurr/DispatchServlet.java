package stcurr;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ContactRetriever retriever = new ContactRetriever();
	
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		
		int id = -1;
		
		try {
			id = Integer.parseInt(idString);
		} catch (NumberFormatException ex) {
			id = -1;
		}

		Contact contact = null;
		
        if (id != -1) {
            contact = retriever.getContact(id);
        }
        response.setContentType("text/html");

        // obtain the parameter "operation"
        String operation = request.getParameter("operation"); // retrieve the parameter indicating the type of operation

        // if null, set the operation to the empty String
        if (operation == null) {
            operation = "";
        }

        // for each possible operation, create a method that write out some HTML
        // try the different possibilities for the operation, calling the appropriate method... if none found, it is an error
        if (operation.equalsIgnoreCase("browse")) {
            this.doBrowse(request, response);
            return;
        }
        if (operation.equalsIgnoreCase("remove")) {
            this.doRemove(request, response, contact);
            return;
        }
        if (operation.equalsIgnoreCase("edit")) {
            this.doEdit(request, response, contact);
            return;
        }
        if (operation.equalsIgnoreCase("update")) {
            this.doUpdate(request, response);
            return;
        }
        if (operation.equalsIgnoreCase("cancel")) {
            this.doBrowse(request, response);
            return;
        }
        
        // if the operation is unknown, write HTML that displays an error
        this.doUnknown(request, response);
        return;
    }

    private void doBrowse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/browse.jsp");
        rd.forward(request, response);
    }
    
    private void doEdit(HttpServletRequest request, HttpServletResponse response, Contact contact) throws ServletException, IOException {
    	request.getSession().setAttribute("contact", contact);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/edit.jsp");
        rd.forward(request, response);
    }
  
    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contact contact = (Contact)request.getSession().getAttribute("contact");
        
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipCode = request.getParameter("zipcode");
        String homePhone = request.getParameter("homephone");
        String workPhone = request.getParameter("workphone");
        String mobilePhone = request.getParameter("mobilephone");
        
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setStreet(street);
        contact.setCity(city);
        contact.setState(state);
        contact.setZipCode(zipCode);
        contact.setHomePhone(homePhone);
        contact.setWorkPhone(workPhone);
        contact.setMobilePhone(mobilePhone);
        
    	retriever.update(contact);

        this.doBrowse(request, response);
    }
    
    private void doRemove(HttpServletRequest request, HttpServletResponse response, Contact contact) throws ServletException, IOException {
        retriever.remove(contact);
        this.doBrowse(request, response);
    }

    private void doUnknown(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Exception ex = new Exception("ERROR - The requested operation is unknown!");
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/error.jsp");

        request.setAttribute("javax.servlet.jsp.jspException", ex);
        rd.forward(request, response);
    }
  

}
