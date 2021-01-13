package Fontys.sem3.Controller;

import Fontys.sem3.Models.Player;

import Fontys.sem3.Service.UserService;
import Fontys.sem3.dto.RegisterUserObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public
    Player booleanAddUser( @RequestBody RegisterUserObject user){
        Player player = new Player(user.getName(),user.getPassword());
        if(userService.SaveUser(player) == true){
            return player;
        }
        else return new Player();
    }
}
