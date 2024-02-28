package de.tbag.gbd;

import java.util.Scanner;

/**
 * @author Samuel Ratzel | Lukas Knappich
 * @version 1.0
 * @since 28.02.24
 */

public class AdventureGame {
    private Scanner scanner;

    public AdventureGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void show(String message) {
        System.out.println(message);
    }

    public String ask(String question) {
        System.out.print(question + " ");
        return scanner.nextLine();
    }

}
