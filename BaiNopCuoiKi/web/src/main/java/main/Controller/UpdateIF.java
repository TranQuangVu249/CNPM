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

@WebServlet(name = "UpdateIF", value = "/UpdateIF")
public class UpdateIF extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user = (User) session.getAttribute("auth");
        String id= user.getId();
        String username = request.getParameter("username");
        int height = Integer.parseInt(request.getParameter("height"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        UserController.getInstance().updateIF(id,username,email,height,weight,age);
        user.setUserName(username);
        user.setHeight(height);
        user.setWeight(weight);
        user.setAge(age);
        user.setEmail(email);
        session.setAttribute("auth", user);
        request.getRequestDispatcher("/UpdateIFsucces.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        }
}