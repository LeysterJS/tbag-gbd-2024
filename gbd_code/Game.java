package de.tbag.gbd.gbd_code;

import de.tbag.gbd.AdventureGame;
import de.tbag.gbd.combat.Weapon;

/**
 * @author Samuel Ratzel | Lukas Knappich | [UR NAME]
 * @version 1.0
 * @since 28.02.24
 */

public class Game {

    private AdventureGame game; // Add a reference to AdventureGame
    Weapon weapon = new Weapon();

    public Game(AdventureGame adventureGame) {
        this.game = adventureGame;
    }




    public void start(String playerName) {

        game.show("Welcome to the Adventure Game!");
        game.show("You are in a forest. You come to a crossroads.");
        String direction = game.ask("Do you want to go left or right?");

        if (direction.equals("left")) {
            game.show("You encounter a friendly elf. He gives you a magic sword.");
        } else if (direction.equals("right")) {
            game.show("You run into a troll. He takes all your gold!");
        } else {
            game.show("That's not a valid direction!");

            // You could add more complex error handling here for the kids to implement.
        }
    }
}


