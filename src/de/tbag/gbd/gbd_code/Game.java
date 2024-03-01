package de.tbag.gbd.gbd_code;

import de.tbag.gbd.combat.Combat;
import de.tbag.gbd.combat.Enemy;
import de.tbag.gbd.combat.Weapon;
import de.tbag.gbd.misc.Shop;
import de.tbag.gbd.misc.ShopItem;
import de.tbag.gbd.player.Player;
import de.tbag.gbd.potions.Potion;
import de.tbag.gbd.potions.PotionsType;
import de.tbag.gbd.AdventureGame;
import de.tbag.gbd.combat.WeaponType;

/**
 * @author Samuel Ratzel | Lukas Knappich | [UR NAME]
 * @version 1.0
 * @since 28.02.24
 */

public class Game {
    private AdventureGame game;
    private Combat combat;
    public String playerName = "";
    private static Enemy enemy;
    private static Potion potions;
    private static PotionsType healSize;
    Player player;
    Shop shop;

    public Game(AdventureGame adventureGame) {
        this.game = adventureGame;
        this.combat = new Combat(adventureGame);
    }

    Weapon deutschesLangschwert = new Weapon("Deutsches Langschwert", WeaponType.LONG_RANGE, 200, 400, 300, 0.3);
    Weapon dolch = new Weapon("Dolch", WeaponType.SHORT_RANGE, 10, 15, 20, 0.1);
    Weapon rustySword = new Weapon("Rusty Sword", WeaponType.SHORT_RANGE , 10, 20, 15, 0.2);

    Potion smallHeal = new Potion("small potion", 25, PotionsType.SMALL_POT);

    ShopItem item1 = new ShopItem(deutschesLangschwert, 2);
    ShopItem item2 = new ShopItem(dolch, 1);


    public void start(String playerName) throws InterruptedException {
        this.playerName = playerName;
        Player player = new Player(playerName, 100, 10, 3);
        Shop shop = new Shop(player,3);
        player.setName(playerName);
        player.showStats();
        game.show("Welcome to the Adventure Game!");
        player.addWeapon(dolch);
        game.wait(2);
        game.show("You are in a forest. You come to a crossroads.");
        String direction = game.ask("Do you want to go left or right?");

        if (direction.equals("left")) {
            game.show("You encounter a friendly elf. He gives you a Deutsches Langschwert.");
            player.equipWeapon(deutschesLangschwert);
            player.addWeapon(deutschesLangschwert);
            player.addPotion(smallHeal);
            player.displayWeapons();
            game.wait(2);
            Enemy enemy = new Enemy("Goblin", 100, rustySword,1);

            // Simulate combat between the player and the enemy
            combat.engageInCombat(player, enemy);

            shop.newShop("sasmuels");
            shop.displayItems();
            shop.addItem(item1);
            shop.addItem(item2);
            shop.buyItem(item1);
            shop.buyItem(item2);

            boolean shopping = true;
            while (shopping) {
                shop.displayItems();
                String choice = game.ask("Enter the number of the item you want to buy, or 'exit' to leave the shop:");
                if (choice.equalsIgnoreCase("exit")) {
                    shopping = false;
                } else {
                    try {
                        shop.displayItems();
                        int itemNumber = Integer.parseInt(choice);
                        ShopItem chosenItem = shop.getItem(itemNumber - 1); // Subtract 1 because list is 0-indexed
                        shop.buyItem(chosenItem);
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        game.show("That's not a valid choice. Please enter a number corresponding to an item, or 'exit' to leave the shop.");
                    }
                }
            }


        } else if (direction.equals("right")) {
            game.show("You run into a troll. He takes all your gold!");
            Enemy enemy = new Enemy("Goblin", 100, rustySword,1);
            enemy.takeGold(5, player);
            int playerGold = player.getMoney();
            System.out.println("Gold: " + playerGold);
            // Handle right direction scenario
        } else {
            game.show("That's not a valid direction!");
            // Add more complex error handling here for the kids to implement.
        }
    }
}