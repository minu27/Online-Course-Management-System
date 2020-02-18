<%-- 
    Document   : confirmation
    Created on : Feb 17, 2020, 11:47:41 AM
    Author     : Minal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation Page</title>
    </head>
    <body>
        <h1>Your User Input Passed Validation!  Good job.</h1>
        
        <ul>
            <li>${requestScope.st.firstName}</li>
            <li>${requestScope.st.lastName}</li>
            <li>${requestScope.st.emailId}</li>
            <li>${requestScope.st.gender}</li>
            
        </ul>
    </body>
</html>
