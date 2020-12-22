package Fontys.sem3.Service;

import Fontys.sem3.Models.Player;
import Fontys.sem3.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    public boolean SaveUser(Player user){
        if(controlUser(user)){
            iUserRepository.save(user);
            return true;
        }
        else{
            return false;
        }

    }

    private boolean controlUser(Player user){
        if(user.getName() != null && user.getPassword() != null ){
            return true;
        }
        else return false;
    }
}
