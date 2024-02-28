package de.tbag.gbd.combat;

public class Weapon {
    private String name;
    private WeaponType type;
    private int minDamage;
    private int maxDamage;
    private int critDamage;
    private double critChance;

    public Weapon(String name, WeaponType type, int minDamage, int maxDamage, int critDamage, double critChance) {
        this.name = name;
        this.weaponType = weaponType;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.critDamage = critDamage;
        this.critChance = critChance;
    }

    public String getName() {
        return name;
    }

    public WeaponType getType() {
        return type;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getCritDamage() {
        return critDamage;
    }

    public double getCritChance() {
        return critChance;
    }
}