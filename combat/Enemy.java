package de.tbag.gbd.combat;

/**
 * @author Lukas Knappich
 * @version 1.0
 * @since 28.02.24
 */

public class Enemy {
    private String name;
    private int hp;
    private int maxDamage;
    private int minDamage;

    public Enemy(String name, int hp, int minDamage, int maxDamage) {
        this.name = name;
        this.hp = hp;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int attack() {
        return (int) (Math.random() * (maxDamage - minDamage + 1)) + minDamage;
    }

    public void takeDamage(int damage) {
        hp = Math.max(0, hp - damage);
    }
}