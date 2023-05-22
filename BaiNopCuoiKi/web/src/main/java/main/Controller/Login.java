package main.Controller;

import main.main.User;
import main.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/DangNhap.jsp").forward(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.getInstance().checkLogin(username, password);
        if(user==null){
            request.setAttribute("error", "Username or password is incorrect");
            request.getRequestDispatcher("/web_war/DangNhap.jsp").forward(request, response);
        }else{
            HttpSession session = request.getSession(true);
            session.setAttribute("auth", user);
            session.setAttribute("login","Xin chào ");
            response.sendRedirect("/web_war/index.jsp");

        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        }    }