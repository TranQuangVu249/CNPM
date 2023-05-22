package main.Controller;

import main.main.User;
import main.service.userService;

import java.util.List;

public class UserController {
    public static UserController instance;

    public UserController() {

    }

    private List<User> alluser;

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

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
