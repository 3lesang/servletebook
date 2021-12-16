<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
        <link rel="stylesheet" href="./css/admin.css">
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
            	<h2>Admin</h2>
            	<div>
            		<a href='dashboard/addbook'> <ion-icon name="add-circle"></ion-icon></a>
                	<a class='top-left-sidebar-link' href='dashboard/addbook'>Add</a>
            	</div>
            	<div>
                	<a href='home'><ion-icon name="home-outline"></ion-icon></a>
                	<a class='left-sidebar-links' href='home'>Home</a>
            	</div>
	            <div>
	                <a href='home'><ion-icon name="Apps-outline"></ion-icon></a>
	                <a class='left-sidebar-links' href='#'>Books</a>
	            </div>
	            <div>
	                <a href='home'><ion-icon name="person-outline"></ion-icon></a>
	                <a class='left-sidebar-links' href='admin/manageuser'>Users</a>
	            </div>
	            <div>
	                <ion-icon name="settings-outline"></ion-icon>
	                <a class='left-sidebar-links' href='#'>Settings</a>
	            </div>
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
								    
	            <h2>List Users</h2>
	            <br>
		        <div class="box-container">
					<table>
						<c:forEach var="user" items="${users}">
							<thead>
								<tr>
									<th>ID</th>
								    <th>FULLNAME</th>
								    <th>USERNAME</th>
								    <th>PASSWORD</th>
								    <th>AVATAR</th>
								    <th>ROLE</th>
								    <th class="action">ACTION</th>
								<tr>
							</thead>
							<tbody>
								<tr>
									<td>${user.getId()}</td>
		              				<td>${user.getFullname()}</td>
		              				<td>${user.getUsername()}</td>
		              				<td>${user.getPword()}</td>
		              				<td>${user.getAvatar()}</td>
		              				<td>${user.getRole()}</td>
		              				<td>
					              		<a href='user/delete?u=${user.getId()}' class='delete'>&#128465;</a>
					              	</td>
				            	</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>				
				
   			</div>
   		</div>
	</div>
<script src="js/admin.js"></script>
</body>
</html>