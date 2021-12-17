<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/book.css">
        <title>${book.getTitle()}</title>
    </head>
    <body>
        <section class="wrapper-form">
  <h2 class="comment"></h2>
  <c:if test="${book != null}"> 
   	<form action="edit?b=${book.getId()}" method="post">
      	<div class="left-form">
	      <input type="text" name="title" id="title" placeholder="tiêu đề" required value="${book.getTitle()}">
	      <input class="email-input" type="text" name="img" id="imgage" placeholder="ảnh bài viết" value="${book.getImg()}" required>
	      <button>sửa</button>  
    	</div>
	    <div class="right-form">
	      <textarea name="detail" id="detail" placeholder="chi tiết bài viết" required>${book.getDetail()}</textarea>
	    </div> 
  	</form>
  </c:if>
  <c:if test="${book == null}"> 
   	<form action="addbook" method="post">
      	<div class="left-form">
	      <input type="text" name="title" id="title" placeholder="tiêu đề" required>
	      <input class="email-input" type="text" name="img" id="imgage" placeholder="ảnh bài viết" required>
	      <button>gửi</button>  
    	</div>
	    <div class="right-form">
	      <textarea name="detail" id="detail" placeholder="chi tiết bài viết" required></textarea>
	    </div> 
  	</form>
  </c:if>

</section>
    </body>
</html>
