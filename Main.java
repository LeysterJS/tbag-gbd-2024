package de.tbag.gbd;

import de.tbag.gbd.player.Player;
import de.tbag.gbd.gbd_code.Game;

import java.util.Scanner;

/**
 * @author Samuel Ratzel | Lukas Knappich
 * @version 1.0
 * @since 28.02.24
 */

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String playerName = inputScanner.nextLine();

        Player player = new Player(playerName);
        AdventureGame game = new AdventureGame(inputScanner);
        Game game1 = new Game(game);


        game1.start(playerName);

        inputScanner.close(); // Now the scanner is closed after all input has been processed
    }


}