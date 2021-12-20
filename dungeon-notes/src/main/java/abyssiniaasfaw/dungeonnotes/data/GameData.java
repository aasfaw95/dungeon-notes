package abyssiniaasfaw.dungeonnotes.data;

import abyssiniaasfaw.dungeonnotes.models.Game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameData {

    //place to put games
    private static Map<Integer , Game> games = new HashMap<>();

    // get all games
    public static Collection<Game> getAll() {
        return games.values();
    }

    //get single game
    public static Game getById(int id) {
        return games.get(id);
    }

    //add game
    public static void add(Game game) {
        games.put(game.getId(), game);
    }

    //remove game
    public static void remove(int id) {
        games.remove(id);
    }

}
