<%@page import="stcurr.*,java.util.*"%>

<HTML>

<HEAD>
   <TITLE>Browse Contacts</TITLE>
   <link type="text/css" rel="stylesheet" href="css/styles.css"/>
</HEAD>

<BODY>

<h3>
Contacts
</h3>

  <table border=1>
    <tr> 
      <th>Contact ID</th>
      <th>First Name</th>
      <th>Last Name</th>
	  <th>Street</th>
      <th>City</th>
      <th>State</th>
      <th>Zip</th>
      <th>Home Phone</th>
      <th>Work Phone</th>
      <th>Mobile Phone</th>
      <th>&nbsp;</th>
      <th>&nbsp;</th>
    </tr>
<%
  ContactRetriever retriever = new ContactRetriever();
  
  Iterator<Contact> iter = retriever.getAllContacts().iterator();
  while(iter.hasNext()) {
    Contact contact = iter.next(); 
%>
    <tr>
      <td align='center'><%=contact.getContactID()%></td>
      <td><%=contact.getFirstName()%></td>
      <td><%=contact.getLastName()%></td>
      <td><%= contact.getStreet() %></td>
	  <td><%= contact.getCity() %></td>
	  <td><%= contact.getState() %></td>
	  <td><%= contact.getZipCode() %></td>
	  <td><%= contact.getHomePhone() %></td>
	  <td><%= contact.getWorkPhone() %></td>
	  <td><%= contact.getMobilePhone() %></td>
      <td><A HREF="dispatch?operation=edit&id=<%= contact.getContactID() %>">[edit]</A></td>
      <td><A HREF="dispatch?operation=remove&id=<%= contact.getContactID() %>" onClick="return confirm('Are you sure you want to remove this contact?');">[remove]</A></td>
    </tr>
  <% } %>
</table>
</BODY>
</HTML>