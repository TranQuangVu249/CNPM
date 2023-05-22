<%@ page import="main.main.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<meta charset="utf-8">
<html>
  <head>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
      }

      .container {
        width: 800px;
        margin: 50px auto;
        background-color: #fff;
        border: 1px solid #ccc;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
      }

      h1 {
        text-align: center;
        margin-bottom: 20px;
      }

      .user-info {
        margin-bottom: 20px;
      }

      .user-info label {
        font-weight: bold;
      }

      .avatar {
        display: flex;
        margin-top: 20px;
        text-align: center;
        margin-bottom: 20px;
      }

      .avatar img {
        width: 300px;
        height: 300px;
        border-radius: 50%;
      }
      .button {
        display: inline-block;
        padding: 10px 20px;
        font-size: 16px;
        font-weight: bold;
        text-align: center;
        text-decoration: none;
        background-color: #4CAF50;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
      }

      .button:hover {
        background-color: #45a049;
      }
    </style>
    <title>Phần mềm theo dõi dinh dưỡng</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
    <header>
      <h1>Phần mềm theo dõi dinh dưỡng</h1>
      <nav>
        <ul>
          <li><a href="#">Trang chủ</a></li>
          <li><a href="#">Thống kê</a></li>
          <li><a href="#">Quản lý thông tin</a></li>
          <li><a href="#">Đăng xuất</a></li>
        </ul>
      </nav>
    </header>
    <%
    String a = (String) session.getAttribute("login");
    User user = (User) session.getAttribute("auth");

    %>
    <div class="container">
      <h1>Thông tin người dùng</h1>
      <div class="avatar">
        <div> <img src="img\pngtree-user-vector-avatar-png-image_4830521.jpg"alt="Avatar">
         </div>
        <div style="margin-left: 60px;margin-top: 20px;
    text-align: left;">
        <div class="user-info">
          <label for="name">Tên người dùng:</label>
          <span id="name"><%=user.getUserName()%></span>
        </div>

        <div class="user-info">
          <label for="height">Chiều cao:</label>
          <span id="height"><%=user.getHeight()%></span>
        </div>

        <div class="user-info">
          <label for="weight">Cân nặng:</label>
          <span id="weight"><%=user.getWeight()%></span>
        </div>

        <div class="user-info">
          <label for="age">Tuổi:</label>
          <span id="age"><%=user.getAge()%></span>
        </div>

        <div class="user-info">
          <label for="email">Email:</label>
          <span id="email"><%=user.getEmail()%></span>
        </div>
          <%int c=user.getGioiTinh();
          String rs="";
          if(c==1){
            rs="Nam";
          }else {
            rs="Nữ";
          }
          %>
        <div class="user-info">
          <label for="gender">Giới tính:</label>
          <span id="gender"><%=rs %></span>
        </div>

        <div class="user-info">
          <label for="register-date">Ngày đăng kí:</label>
          <span id="register-date">05/05/2023</span>
        </div>
          <a href="/web_war/quanlithongtin.jsp" class="button">Chỉnh sửa</a>
      </div>

      </div>
    </div>
    <footer>
    </footer>
  </body>
</html>
