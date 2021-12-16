<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
        <link rel="stylesheet" href="./css/manageuser.css">
        <script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${sessionScope.userInfo.getUsername()}</title>
</head>

<body>
	<div class='main-container'>
		<div class='container'>
			<div class='left-sidebar'>
				<h2>User</h2>
			</div>
			<div class='admin'>
				<div class='top-bar'>
					<br>
					<input placeholder="SEARCH" type='search'>
					<ion-icon class='search-icon' name="search-outline"></ion-icon>
				</div>

				<h2>List Books</h2>
				<br>
				
				<div class='box-container'>
					<c:forEach var="book" items="${books}">
						<div class='box'>
							<div class='box-row'>
								<a href="doc?q=${book.getId()}"><img src="${book.getImg() }" title="" /></a>
								<p>${book.getAuthor()}</p>
							</div>
							<br>
							<p>${book.getTitle()}</p>
							<br>
							<div class='line'></div>
							<div class='buttons-container'>
								<a href='book/delete?b=${book.getId()}' class='delete'>&#128465;</a>
								<a href='book/edit?b=${book.getId()}'>&#128295;</a>
							</div>
						</div>
					</c:forEach>
				</div> 
			</div>
		</div>
	</div>
</body>
</html>