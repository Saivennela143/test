<%@page import="stcurr.*"%>
<HTML>

<HEAD>
   <TITLE>Edit Contact</TITLE>
   <link type="text/css" rel="stylesheet" href="css/styles.css"/>   
</HEAD>

<BODY>
<%
  ContactRetriever retriever = new ContactRetriever();
  Contact contact = (Contact)session.getAttribute("contact");
%>
<h3>
Edit Contact
</h3>
  <form action="dispatch">
  <table border=1>
    <tr> 
      <td>Contact ID</td><td><%=contact.getContactID()%></td>
    </tr>
    <tr>
      <td>First Name</td><td><input type="text" name="firstname" value="<%=contact.getFirstName()%>"></td>
    </tr>
    <tr>  
      <td>Last Name</td><td><input type="text" name="lastname" value="<%=contact.getLastName()%>"></td>
    </tr>
    <tr>
	  <td>Street</td><td><input type="text" name="street" value="<%=contact.getStreet()%>"></td>
	</tr>
    <tr>
      <td>City</td><td><input type="text" name="city" value="<%=contact.getCity()%>"></td>
    </tr>
    <tr>
      <td>State</td><td><input type="text" name="state" value="<%=contact.getState()%>"></td>
    </tr>
    <tr>
      <td>Zip</td><td><input type="text" name="zipcode" value="<%=contact.getZipCode()%>"></td>
    </tr>
    <tr>
      <td>Home Phone</td><td><input type="text" name="homephone" value="<%=contact.getHomePhone()%>"></td>
    </tr>
    <tr>
      <td>Work Phone</td><td><input type="text" name="workphone" value="<%=contact.getWorkPhone()%>"></td>
    </tr>
    <tr>
      <td>Mobile Phone</td><td><input type="text" name="mobilephone" value="<%=contact.getMobilePhone()%>"></td>
    </tr>
    <tr>
      <td align="center"><input type="submit" name="operation" value="Cancel"></td>
      <td align="center"><input type="submit" name="operation" value="Update"></td>
    </tr>
  </table>
  </form>
</BODY>
</HTML>