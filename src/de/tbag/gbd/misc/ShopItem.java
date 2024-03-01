package de.tbag.gbd.misc;

import de.tbag.gbd.combat.Weapon;

public class ShopItem {
    private Weapon weapon;
    private int cost;

    public ShopItem(Weapon weapon, int cost) {
        this.weapon = weapon;
        this.cost = cost;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public int getCost() {
        return this.cost;
    }
    public String getName() {
        return this.weapon.getName();
    }
}
