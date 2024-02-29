package de.tbag.gbd.potions;

import de.tbag.gbd.combat.Enemy;
import de.tbag.gbd.cosmetic.ConsoleColors;
import de.tbag.gbd.player.Player;

/**
 *
 * @author Samuel Ratzel
 * @since 29.02.24
 * @version 1.0
 *
 */

public class Potion {
    private String name;
    private PotionsType potionsType;
    private int heal;
    private static Player player;
    private static Enemy enemy;


    public Potion(String name, int heal ,PotionsType potionsType) {
        this.name = name;
        this.heal = heal;
        this.potionsType = potionsType;

    }


    public String getName() {
        return name;
    }
    public PotionsType getPotionsType() {
        return potionsType;
    }

    public int getHeal() {
        return heal;
    }

}
