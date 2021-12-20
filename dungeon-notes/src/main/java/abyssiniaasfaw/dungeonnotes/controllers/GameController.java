package abyssiniaasfaw.dungeonnotes.controllers;

import abyssiniaasfaw.dungeonnotes.data.GameData;
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


    @GetMapping
    public String displayAllGames(Model model) {
       model.addAttribute("games", GameData.getAll());
        return "games/index";
    }

    @GetMapping("create")
    public String renderCreateGameForm() {
        return "games/create";
    }

    @PostMapping("create")
    public String createGame(@RequestParam String gameName,
                             @RequestParam String gameDescription) {
        GameData.add(new Game(gameName, gameDescription));
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteGameForm(Model model) {
        model.addAttribute("title", "Delete Games");
        model.addAttribute("games", GameData.getAll());
        return "games/delete";


    }

    @PostMapping("delete")
    public String processDeleteGamesForm(@RequestParam(required = false) int[] gameIds) {

        if (gameIds != null) {
            for (int id : gameIds) {
                GameData.remove(id);
            }
        }

        return "redirect:";

    }
}
