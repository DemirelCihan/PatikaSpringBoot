package javaspringpatika.dataAccess.abstracts;

import javaspringpatika.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

}
