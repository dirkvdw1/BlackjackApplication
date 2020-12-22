package Fontys.sem3.Controller;

import Fontys.sem3.Models.Player;

import Fontys.sem3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public @ResponseBody
    Player booleanAddUser( Player user){

        if(userService.SaveUser(user) == true){
            return user;
        }
        else return new Player();
    }
}
