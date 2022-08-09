<%@page isErrorPage= "true" %>
<%@page import="java.io.*"%>
<HTML>

<HEAD>
   <TITLE>ERROR</TITLE>
   <link type="text/css" rel="stylesheet" href="css/styles.css"/>   
</HEAD>

<BODY>


<h1>We are Experiencing Technical Difficulties</h1>
<br><p><b>An error has occurred that prevented the system from working properly.</b>
<br><b>1-</b> Click the "Back" button in your web browser, and try again.
<br><b>2-</b> If that doesn't work, click <a href="welcome.html">here</a> to go back to the first page.
<br><b>3-</b> If the problem persists, send an e-mail to the <a href="mailto:bill.bell@oracle.com">webmaster</a>. Be sure to copy the following in your message:
<p>
<b>Error description:</b><BR>
<% if (exception == null) { %>
  Unknown<BR>
<% } else { %>
  <%= exception.getMessage() %><BR><BR>
  Stack Trace:<BR>
  <%
  exception.printStackTrace(new PrintWriter(out));
  %>
<% } %>

</body>
</html>