package de.tbag.gbd.combat;
import de.tbag.gbd.combat.Weapon;

/**
 * @author Lukas Knappich | Samuel Ratzel
 * @version 1.0
 * @since 28.02.24
 */

public class Enemy {
    private String name;
    private double health;
    private double maxHealth;
    private Weapon weapon;
    private int amountHealingPotions;

    public Enemy(String name, double health, Weapon weapon, int amountHealingPotions) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.weapon = weapon;
        this.amountHealingPotions = amountHealingPotions;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double hp) {
        this.health = hp;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double hp) {
        this.maxHealth = hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getAmountHealingPotions(){
        return amountHealingPotions;
    }

    public void setAmountHealingPotions(int amountHealingPotions){
        this.amountHealingPotions = amountHealingPotions;
    }

}