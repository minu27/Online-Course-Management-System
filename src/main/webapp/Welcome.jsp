<%-- 
    Document   : welcome
    Created on : Feb 17, 2020, 11:43:09 AM
    Author     : Minal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Sign up and welcome</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <style> 

            input[type=text], input[type=password] { 
                width: 100%; 
                padding: 12px 20px; 
                margin: 8px 0; 
                display: inline-block; 
                border: 1px solid #ccc; 
                box-sizing: border-box; 
            } 


            button { 
                background-color: #4CAF50; 
                color: white; 
                padding: 14px 20px; 
                margin: 8px 0; 
                border: none; 
                cursor: pointer; 
                width: 100%; 
            } 

            button:hover { 
                opacity: 0.8; 
            } 


            .cancelbtn { 
                width: auto; 
                padding: 10px 18px; 
                background-color: #f44336; 
            } 


            .imgcontainer { 
                text-align: center; 
                margin: 24px 0 12px 0; 
                position: relative; 
            } 

            img.avatar { 
                width: 10%; 
                border-radius: 50%; 
            } 

            .container { 
                padding: 16px; 
            } 

            span.psw { 
                float: right; 
                padding-top: 16px; 
            } 


            .modal { 
                display: none;  
                position: fixed; 
                z-index: 1;  
                left: 0; 
                top: 0; 
                width: 100%; 
                height: 100%; 
                overflow: auto;  
                background-color: rgb(0,0,0); 
                background-color: rgba(0,0,0,0.4); 
                padding-top: 60px; 
            } 


            .modal-content { 
                background-color: #fefefe; 
                margin: 5% auto 15% auto;  
                border: 1px solid #888; 
                width: 80%;  
                border-radius: 5px;
            } 

            .close { 
                position: absolute; 
                right: 25px; 
                top: 0; 
                color: #000; 
                font-size: 35px; 
                font-weight: bold; 
            } 

            .close:hover, 
            .close:focus { 
                color: red; 
                cursor: pointer; 
            } 

            .animate { 
                -webkit-animation: animatezoom 0.6s; 
                animation: animatezoom 0.6s 
            } 

            @-webkit-keyframes animatezoom { 
                from {-webkit-transform: scale(0)}  
                to {-webkit-transform: scale(1)} 
            } 
            @keyframes animatezoom { 
                from {transform: scale(0)}  
                to {transform: scale(1)} 
            } 
            @media screen and (max-width: 300px) { 
                span.psw { 
                    display: block; 
                    float: none; 
                } 
                .cancelbtn { 
                    width: 100%; 
                } 
            } 
        </style> 

        <div class="imgcontainer"> <h2>Student Entry Form</h2>  </div>

        <c:if test="${not empty requestScope.mistakes}">
            <p>There are one or more validation issues with your submission. Please correct them.</p>
            
            <c:forEach var="mistake" items="${requestScope.mistakes}" >
               There is an issue with ${mistake.propertyPath}.  The message is ${mistake.message}
            </c:forEach>
           
        </c:if>
    
        <form action="./StudentReg" method="post" class="modal-content animate">  

            <div class="container"> 
                <label><b>First Name</b></label> 
                <input value="${requestScope.st.fname}" type="text" placeholder="Enter First Name" name="firstName" > 

                <label><b>Last Name</b></label> 
                <input value="${requestScope.st.lname}" type="text" placeholder="Enter Last Name" name="lastName" > 

               
                <label><b>Email</b></label> 
                <input value="${requestScope.st.email}" type="text" placeholder="Enter Email" name="emailId" > 

                <label><b>Student ID</b></label> 
                <input value="${requestScope.st.studentId}" type="text" placeholder="Enter Student ID" name="studentId" > 

                <button type="submit">Create</button>  
                <button type="reset">Reset</button>



                <script>
                    function myFunction() {
                        document.getElementById("myForm").reset();
                    }
                </script>
            </div> 


        </form>  
    </body>
</html>

