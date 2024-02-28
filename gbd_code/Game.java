package de.tbag.gbd.gbd_code;

import de.tbag.gbd.AdventureGame;
import de.tbag.gbd.combat.Weapon;

/**
 * @author Samuel Ratzel | Lukas Knappich | [UR NAME]
 * @version 1.0
 * @since 28.02.24
 */

public class Game {
    private AdventureGame game;
    private Combat combat;

    public Game(AdventureGame adventureGame) {
        this.game = adventureGame;
        this.combat = new Combat();
    }

    public void start(String playerName) {
        game.show("Welcome to the Adventure Game!");
        game.show("You are in a forest. You come to a crossroads.");
        String direction = game.ask("Do you want to go left or right?");

        if (direction.equals("left")) {
            game.show("You encounter a friendly elf. He gives you a magic sword.");

            // Create a player with initial health and inventory
            Player player = new Player(playerName, 100, 2, 3);

            // Create a weapon for the player
            Weapon playerWeapon = new Weapon("Excalibur", WeaponType.LONG_RANGE, 200, 400, 300, 0.3);

            // Add the weapon to the player's inventory
            player.addWeapon(playerWeapon);

            // Create an enemy with initial health and a weapon
            Enemy enemy = new Enemy("Goblin", 10, new Weapon("Rusty Sword", WeaponType.SHORT_RANGE , 10, 20, 15, 0.2));

            // Simulate combat between the player and the enemy
            combat.engageInCombat(player, enemy);

        } else if (direction.equals("right")) {
            game.show("You run into a troll. He takes all your gold!");
            // Handle right direction scenario
        } else {
            game.show("That's not a valid direction!");
            // Add more complex error handling here for the kids to implement.
        }
    }
}