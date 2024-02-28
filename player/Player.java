package de.tbag.gbd.player;

import de.tbag.gbd.combat.Enemy;
import de.tbag.gbd.combat.Weapon;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas Knappich | Samuel Ratzel
 * @version 1.0
 * @since 28.02.24
 */

public class Player {
    private String name;
    private double health;
    private int maxWeapons;
    private int maxHealingPotions;
    private List<Weapon> weapons;
    private List<String> healingPotions;
    private Weapon equippedWeapon;


    public Player(String name, double health, int maxWeapons, int maxHealingPotions) {
        this.name = name;
        this.health = health;
        this.maxWeapons = maxWeapons;
        this.maxHealingPotions = maxHealingPotions;
        this.weapons = new ArrayList<>();
        this.healingPotions = new ArrayList<>();
    }

    public void addWeapon(Weapon weapon) {
        if (weapons.size() < maxWeapons) {
            weapons.add(weapon);
        } else {
            System.out.println("Cannot carry more weapons.");
        }
    }

    public void addHealingPotion(String potion) {
        if (healingPotions.size() < maxHealingPotions) {
            healingPotions.add(potion);
        } else {
            System.out.println("Cannot carry more healing potions.");
        }
    }

    public void displayWeapons() {
        System.out.println("Weapons in inventory:");
        for (Weapon weapon : weapons) {
            System.out.println(weapon.getName() + " | Type: " + weapon.getType() + " | Damage: " + weapon.getMinDamage() + " - " + weapon.getMaxDamage() +
                    " | Critical Damage: " + weapon.getCritDamage() + " | Critical Chance: " + weapon.getCritChance());
        }
    }

    public void takeDamage() {

    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxWeapons() {
        return maxWeapons;
    }

    public void setMaxWeapons(int maxWeapons) {
        this.maxWeapons = maxWeapons;
    }

    public int getMaxHealingPotions() {
        return maxHealingPotions;
    }

    public void setMaxHealingPotions(int maxHealingPotions) {
        this.maxHealingPotions = maxHealingPotions;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<String> getHealingPotions() {
        return healingPotions;
    }

    public void setHealingPotions(List<String> healingPotions) {
        this.healingPotions = healingPotions;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }
}


