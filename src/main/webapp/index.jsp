<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<div>
    <h1 class="display-1">Welcome to SportsBet!</h1>
    <h2 class="display-3">Sports betting is the activity of predicting sports results and placing a wager on the outcome</h2>
</div>

<div>
    <h6> Login or <a href="register.jsp">Register</a> to start!</h6>
</div>

<div>
    <form action="login" method="post" >
        <input type="text" name="email" id="email">
        <input type="password" name="password" id="password">
        <button>Login</button>
    </form>
</div>


</body>
</html>
