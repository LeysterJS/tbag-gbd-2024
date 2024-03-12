package tbag.gbd.misc;

import tbag.gbd.debug.Debug;
import tbag.gbd.gbd_code.Game;
import tbag.gbd.player.Player;
import tbag.gbd.BigTexts;

import tbag.gbd.cosmetic.ConsoleColors;

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

    private List<ShopItem> shopItems;
    private int maxItems;
    private String auswahl;
    private Player player;
    private int shopSize;
    private Game game;
    private Debug debug = new Debug();
    private Scanner shop;

    public Shop(Player player, int shopSize, Scanner scanner) {
        this.player = player;
        this.shopSize = shopSize;
        this.shopItems = new ArrayList<>();
        this.shop = scanner;
    }

    public void newShop(String shopName) {
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
                displayItems();
                exitShop();
                break;

            case "no":
                System.out.println("Okey Bye!");
                break;
            default:
                System.out.println("This is not a vailed option");
                break;

        }


    }

    public void addItem(ShopItem item) {
        debug.message("Adding item to shop.");

        if (shopItems.size() < shopSize) {
            shopItems.add(item);
        } else {
            System.out.println("Cannot carry more items.");
        }
    }

    public void buyItem(ShopItem item) {
        if (item.getStock() > 0) {
            if (player.getMoney() >= item.getCost() && player.getWeapons().size() < player.getMaxWeapons()) {
                player.addWeapon(item.getWeapon());
                player.removeMoney(item.getCost());
                item.decreaseStock();
                displayItems();
            } else {
                if(player.getMoney() < item.getCost()) {
                    System.out.println("You do not have enough money to buy this item.");
                }
                if(player.getWeapons().size() >= player.getMaxWeapons()) {
                    System.out.println("You cannot carry any more weapons.");
                }
            }
        } else {
            System.out.println("This item is no longer available.");
        }
    }

    public void exitShop() {
        boolean shopping = true;
        Scanner scanner = new Scanner(System.in);
        while (shopping) {
            System.out.println("Enter the number of the item you want to buy, or 'exit' to leave the shop:");
            String choice = scanner.nextLine();
            try {
                int itemNumber = Integer.parseInt(choice);
                ShopItem chosenItem = getItem(itemNumber - 1); // Subtract 1 because list is 0-indexed
                buyItem(chosenItem);
            } catch (NumberFormatException e) {
                if (choice.equals("exit")) {
                    shopping = false;
                } else {
                    System.out.println("That's not a valid choice. Please enter a number corresponding to an item, or 'exit' to leave the shop.");
                }
            }
        }
    }

    public void displayItems() {
        if (shopItems.isEmpty()) {
            System.out.println("The shop is currently empty.");
        } else {
            System.out.println("Here are the items available in the shop:");
            for (ShopItem item : shopItems) {
                //System.out.println(item.getName() + " (Cost: " + item.getCost() + ")");
                if (player.getMoney() >= item.getCost()) {
                    System.out.println(ConsoleColors.GREEN + item.getName() + " (Cost: " + item.getCost() + ")" + ConsoleColors.RESET);
                } else {
                    System.out.println(ConsoleColors.RED + item.getName() + " (Cost: " + item.getCost() + ")" + ConsoleColors.RESET);
                }
            }
        }
    }
    public ShopItem getItem(int index) {
        if (index >= 0 && index < shopItems.size()) {
            return shopItems.get(index);
        } else {
            System.out.println("Invalid item number.");
            return null;
        }
    }
}




