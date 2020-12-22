package Fontys.sem3.Repository;

import Fontys.sem3.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Player,Integer> {


}
