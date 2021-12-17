<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">    
    <link rel="stylesheet" href="./css/doc.css">
    <title>${book.getTitle()}</title>
  </head>
  <body class="scrollbar" id="view">
        
    <artical>
        <h2>${book.getTitle()}</h2>
        <p class="user-name">&#129489; ${book.getUser().getUsername()}</p>
        <img class="card-img-top" alt="img" src="${book.getImg()}"/>
        
        <p>${book.getDetail()}</p>
        <a href="home">back to home</a>
    </artical>
  
    
      
  </body>
</html>

