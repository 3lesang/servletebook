<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet"> 
    <link rel="stylesheet" href="./css/form.css">
    <title>đăng kí</title>
</head>
<body>
	<c:if test="${mess != null}"> 
            <p style="color: red; padding: 8px">${mess}</p>
    </c:if>
	
    <form action="register" method="post" class="form">
        <a href="home"><h2>book</h2></a>
        <div class="form-group">
            <label for="name" class="label-input">họ và tên</label>
            <input type="text" name="name" placeholder="họ và tên" id="name" class="form-input">
        </div>
        <div class="form-group">
            <label for="username" class="label-input">@</label>
            <input type="text" name="username" placeholder="tên tài khoản" id="username" class="form-input" required>
        </div>
        <div class="form-group">
            <label for="password" class="label-input">mật khẩu</label>
            <input type="password" name="password" id="password" class="form-input" placeholder="mật khẩu" required>
        </div>
        <div class="form-group">
            <label for="repassword" class="label-input">xác nhận</label>
            <input type="password" name="repw" id="repassword" class="form-input" placeholder="xác nhận" required>
        </div>
        <button type="submit" class="btn-submit">đăng kí</button>
        <p>đã có tài khoản? <a href="login">đăng nhập</a></p>
    </form>
</body>
</html>