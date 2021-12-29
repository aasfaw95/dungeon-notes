package abyssiniaasfaw.dungeonnotes.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Game {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500)
    private String description;

    private CharacterClass type;


    public Game(String name, String description, CharacterClass type) {
        this();
        this.name = name;
        this.description = description;
        this.type =type;
    }

    public Game() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public CharacterClass getType() {
        return type;
    }

    public void setType(CharacterClass type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
