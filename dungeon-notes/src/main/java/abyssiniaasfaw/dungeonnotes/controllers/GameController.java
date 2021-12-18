package abyssiniaasfaw.dungeonnotes.controllers;

import abyssiniaasfaw.dungeonnotes.models.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("games")
public class GameController {

    private static List<Game> games = new ArrayList<>();

    @GetMapping
    public String displayAllGames(Model model) {
       model.addAttribute("games", games);
        return "games/index";
    }

    @GetMapping("create")
    public String renderCreateGameForm() {
        return "games/create";
    }

    @PostMapping("create")
    public String createGame(@RequestParam String gameName,
                             @RequestParam String gameDescription) {
        games.add(new Game(gameName, gameDescription));
        return "redirect:";
    }
}
