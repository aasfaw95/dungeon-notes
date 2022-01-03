package abyssiniaasfaw.dungeonnotes.data;

import abyssiniaasfaw.dungeonnotes.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
