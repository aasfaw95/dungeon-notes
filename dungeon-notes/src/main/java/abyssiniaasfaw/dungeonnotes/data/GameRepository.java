package abyssiniaasfaw.dungeonnotes.data;

import abyssiniaasfaw.dungeonnotes.models.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
}
