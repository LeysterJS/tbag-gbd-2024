package tbag.gbd.gbd_code;

import tbag.gbd.combat.Combat;
import tbag.gbd.combat.Enemy;
import tbag.gbd.combat.Weapon;
import tbag.gbd.misc.Shop;
import tbag.gbd.misc.ShopItem;
import tbag.gbd.player.Player;
import tbag.gbd.potions.Potion;
import tbag.gbd.potions.PotionsType;
import tbag.gbd.AdventureGame;
import tbag.gbd.combat.WeaponType;

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

    ShopItem item1 = new ShopItem(deutschesLangschwert, 2,1);


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
            shop.addItem(item1);



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