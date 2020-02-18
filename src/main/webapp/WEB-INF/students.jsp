<%-- 
    Document   : students
    Created on : Feb 17, 2020, 11:43:09 AM
    Author     : Minal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <h2>Student Entry Form</h2>
      
    <c:if test="${not empty requestScope.mistakes}">
            <p>There are one or more validation issues with your submission. Please correct them.</p>
            <ol>
            <c:forEach var="mistake" items="${requestScope.mistakes}" >
                <li>There is an issue with ${mistake.propertyPath}.  The message is ${mistake.message}</li>
            </c:forEach>
            </ol>
    </c:if>
    
    <form action="/mvaity-fp/st" method="post" >  

            <div class="container"> 
                <label><b>First Name</b></label> 
                <input value="${requestScope.st.fname}" type="text" placeholder="Enter First Name" name="firstName" required> 
                <br>
                <label><b>Last Name</b></label> 
                <input value="${requestScope.st.lname}" type="text" placeholder="Enter Last Name" name="lastName" required> 

                <br>
                <label><b>Email</b></label> 
                <input value="${requestScope.st.email}" type="text" placeholder="Enter Email" name="emailId" required> 

                <br>
                <div>
                <label for="gender">Gender:</label>
                <select name="gender">
                    <c:forEach var="gender" items="${requestScope.st.gender}">
                        <option ${requestScope.st.gender eq gender ? 'selected=selected' : ''} value="${gender}">${gender.label}</option>
                    </c:forEach>
                </select>
                </div>
                 

                <button type="submit">Create</button>  
                <button type="reset">Reset</button>


    </body>
</html>
