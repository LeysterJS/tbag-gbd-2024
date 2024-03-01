package de.tbag.gbd.misc;

import de.tbag.gbd.player.Player;
import de.tbag.gbd.BigTexts;
import de.tbag.gbd.combat.Weapon;
import de.tbag.gbd.combat.WeaponType;
import de.tbag.gbd.cosmetic.ConsoleColors;
import de.tbag.gbd.potions.Potion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Samuel Ratzel | Lukas Knappich
 * @version 1.0
 * @since 29.02.24
 */

public class Shop {

    private List<ShopItem> shopItems = new ArrayList<>();
    private int maxItems;
    private String auswahl;
    private Player player;


    public void newShop(String shopName) {
        shopItems.clear();
        BigTexts bigTexts = new BigTexts();

        Scanner shop = new Scanner(System.in);
        String[] textInputs = {
                "Greetings, brave adventurer! Come explore my treasures at my shop.",
                "Welcome, traveler! Your journey isn't complete without a visit to my shop.",
                "Step into my emporium and discover the wonders that await you, dear customer.",
                "Looking for magical artifacts? Peruse my collection at your leisure.",
                "Seeking rare items and mysterious relics? Your search ends at my shop.",
                "Enter, enter, one and all! Discover the magic within these walls!",
                "For the discerning adventurer like yourself, a visit to my shop is a must.",
                "Curious about what lies beyond? Find out by stepping into my shop.",
                "Fortunes and curiosities abound in my humble establishment. Shall we explore?",
                "Enter as strangers, leave as friends! Welcome to the realm of treasures."
        };
        Random random = new Random();
        int randomIndex = random.nextInt(textInputs.length);
        String randomText = textInputs[randomIndex];
        System.out.println(ConsoleColors.RED + "A Merchant appears: \n" + ConsoleColors.YELLOW + randomText + ConsoleColors.RESET);


        System.out.println("Sure | " + ConsoleColors.GREEN + "Yes" + ConsoleColors.RESET);
        System.out.println("No thanks i am good  | " + ConsoleColors.RED + "No" + ConsoleColors.RESET);
        auswahl = shop.nextLine().toLowerCase();

        switch (auswahl) {

            case "yes":
                bigTexts.shop();

                System.out.println("Welcome to the " + shopName + "!");
                System.out.println("i can offer you stuff");
                displayItems();
                break;

            case "no":
                System.out.println("Okey Bye!");
                break;
            default:
                System.out.println("This is not a vailed option");
                break;

        }


    }
    public Shop(Player player, int maxItems) {
        this.player = player;
        this.maxItems = maxItems;
    }

    public void addItem(ShopItem item) {
        if (shopItems.size() < maxItems) {
            shopItems.add(item);
        } else {
            System.out.println("Cannot carry more items.");
        }
    }

    public void buyItem(ShopItem item) {
        if (player.getMoney() >= item.getCost() && player.getWeapons().size() < player.getMaxWeapons()) {
            player.addWeapon(item.getWeapon());
            player.removeMoney(item.getCost());
        } else {
            if(player.getMoney() < item.getCost()) {
                System.out.println("You do not have enough money to buy this item.");
            }
            if(player.getWeapons().size() >= player.getMaxWeapons()) {
                System.out.println("You cannot carry any more weapons.");
            }
        }
    }
    public void displayItems() {
        for (ShopItem item : shopItems) {
            System.out.println(item.getName() + ": " + item.getCost());
        }
    }
}




