package org.example.Controller;

import org.example.main.User;
import org.example.service.userService;

public class UserController {
    public User viewIF(String IdUser){
        User user= userService.getInstance().getIF(IdUser);
        return user;
    }
    public String updateIF(String IdUser, String userName, String email, int height, int weight,int Age){
        String rs="";
      rs=  userService.getInstance().updateIF( IdUser,  userName,  email,  height,  weight, Age);
      return rs;
    }
}
