<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
    <%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/home.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
    <title>home</title>
</head>

<body class="grid-layout">
    <div class="header">
        <a href="home" class="logo">BOOK</a>
        <form class="form-search" action="" method="GET">
          <input class="search-input" type="search" placeholder="tìm kiếm..." name="b" />
          <button class="btn" type="submit">Tìm kiếm</button>
        </form>
        <span class="header-right">
            <c:choose>
                <c:when test="${sessionScope.userInfo == null}"> 
                  <a href="login">&#128100;</a>
                </c:when>
                <c:otherwise>
                    <div class="dropdown">
					  <button onclick="myFunction()" class="dropbtn">${sessionScope.userInfo.getFullname()} &#128100;</button>
					  <div id="myDropdown" class="dropdown-content">
					    <a href="dashboard">Quản lý</a>
					    <a href="logout">Đăng xuất</a>
					    <a href="admin">Admin</a>
					  </div>
					</div>
                </c:otherwise>
            </c:choose>
          
        </span>
      </div>
      <div class="modal">
        
      </div>
      <div class="sidebar bg">
        <ul class="nav-sidebar">
          <li class="nav-sidebar-item"><a href="home">trang chủ</a></li>
          <li class="nav-sidebar-item"><a href="home?b=new">mới nhất </a></li>
          <li class="nav-sidebar-item"><a href="home?b=trending">thịnh hành </a></li>
          <li class="nav-sidebar-item"><a href="home?b=best">hay nhất</a></li>
          <li class="nav-sidebar-item"><a href="home?b=best">theo dõi</a></li>
        </ul>
        
      </div>
      <main class="content" >
      	<c:if test="${requestScope.books.size() == 0}"> 
                  <p>Not found book</p>
        </c:if>
          <c:forEach var="book" items="${requestScope.books}">
                <div class="card">
                    <a href="doc?q=${book.getId()}">
                        <img class="card-img-top" alt="img" src="${book.getImg()}"/>
                    </a>
                    <div class="card-body">
                        <a href="doc?q=${book.getId()}"><h3 class="card-title">${book.getTitle()}</h3></a>
                        <p class="card-des">${book.getDetail()}</p>
                        <span>${book.getViews()} &#128064; ${book.getCreated_at()}</span>
                    </div>
                    <div class="card-footer">
                        <div class="user">
                            <div class="avatar-cover"><img class="avatar-user" src="static/img/logo.png" alt="" /></div>
                            <p class="user-name">${book.getAuthor()}</p>
                        </div>
                        
                        <a href="" class="follow-btn" data-user="${sessionScope.userInfo.getUsername()}" data-book="${book.getId()}">&#x1F493;</a>                   
                    </div>
                </div>
          </c:forEach>
      </main>
     <script src="js/home.js"></script>
</body>
</html>