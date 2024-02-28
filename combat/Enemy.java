package de.tbag.gbd.combat;
import de.tbag.gbd.combat.Weapon;

/**
 * @author Lukas Knappich
 * @version 1.0
 * @since 28.02.24
 */

public class Enemy {
    private String name;
    private int hp;
    private Weapon weapon;

    public Enemy(String name, int hp, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.weapon = weapon;
    }


    public int attack() {
        if (weapon != null) {
            int baseDamage = (int) (Math.random() * (weapon.getMaxDamage() - weapon.getMinDamage() + 1)) + weapon.getMinDamage();
            double critRoll = Math.random();
            if (critRoll <= weapon.getCritChance()) {
                return baseDamage + weapon.getCritDamage();
            } else {
                return baseDamage;
            }
        } else {
            return (int) (Math.random() * 10) + 1; // Simple random damage example if the enemy has no weapon
        }
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    // Getters and setters for name, hp, weapon


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}