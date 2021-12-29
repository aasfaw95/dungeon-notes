package abyssiniaasfaw.dungeonnotes.models;

public enum CharacterClass {
    BARBARIAN("Barbarian"),
    BARD("Bard"),
    CLERIC("Cleric"),
    DRUID("Druid"),
    FIGHTER("Fighter"),
    MONK("Monk"),
    PALADIN("Paladin"),
    RANGER("Ranger"),
    ROGUE("Rogue"),
    SORCERER("Sorcerer"),
    WARLOCK("Warlock"),
    WIZARD("Wizard");

    private final String displayName;

    CharacterClass(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
