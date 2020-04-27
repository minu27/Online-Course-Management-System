
<!DOCTYPE html>
<html>
    <head>
        <title>User Page</title>
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

       <form action="./index.html" method="post" class="modal-content animate">  
           <div class="imgcontainer"> 
              welcome to Learning System
          </div>
           <div class="container">              
            <button type="submit">Login</button>  
          </div> 
          

       </form>  
    </body>
</html>
