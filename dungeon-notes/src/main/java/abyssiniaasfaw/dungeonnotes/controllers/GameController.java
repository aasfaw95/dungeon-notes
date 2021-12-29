package abyssiniaasfaw.dungeonnotes.controllers;

import abyssiniaasfaw.dungeonnotes.data.GameRepository;
import abyssiniaasfaw.dungeonnotes.models.CharacterClass;
import abyssiniaasfaw.dungeonnotes.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public String displayAllGames(Model model) {
       model.addAttribute("games", gameRepository.findAll());
       model.addAttribute("title", "All Games");
        return "games/index";
    }

    @GetMapping("create")
    public String displayCreateGameForm(Model model) {
        model.addAttribute("title", "Create Game");
        model.addAttribute(new Game());
        model.addAttribute("types",CharacterClass.values());
        return "games/create";
    }

    @PostMapping("create")
    public String processCreateGameForm(@ModelAttribute @Valid Game newGame,
                                        Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Game");
            return "games/create";
        }
        gameRepository.save(newGame);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteGameForm(Model model) {
        model.addAttribute("title", "Delete Games");
        model.addAttribute("games", gameRepository.findAll());
        return "games/delete";


    }

    @PostMapping("delete")
    public String processDeleteGamesForm(@RequestParam(required = false) int[] gameIds) {

        if (gameIds != null) {
            for (int id : gameIds) {
                gameRepository.deleteById(id);
            }
        }

        return "redirect:";

    }
}
