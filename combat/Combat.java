package de.tbag.gbd.combat;

/**
 * @author Lukas Knappich
 * @version 1.0
 * @since 28.02.24
 */

public class Combat {
    public static void engageInCombat(String playerName, int playerHealth, Weapon playerWeapon, Enemy enemy) {
        // Player attacks the enemy
        int playerDamage = calculatePlayerDamage(playerWeapon);
        enemy.takeDamage(playerDamage);
        System.out.println(playerName + " hits the " + enemy.getName() + " for " + playerDamage + " damage!");

        // Check if the enemy is defeated
        if (enemy.getHp() <= 0) {
            System.out.println("The " + enemy.getName() + " has been defeated!");
            return;
        }

        // Enemy attacks the player
        int enemyDamage = enemy.attack();
        playerHealth -= enemyDamage;
        System.out.println("The " + enemy.getName() + " attacks " + playerName + " for " + enemyDamage + " damage!");
        // Additional combat logic can be added here
    }

    private static int calculatePlayerDamage(Weapon weapon) {
        int baseDamage = (int) (Math.random() * (weapon.getMaxDamage() - weapon.getMinDamage() + 1)) + weapon.getMinDamage();
        double critRoll = Math.random();
        if (critRoll <= weapon.getCritChance()) {
            return baseDamage + weapon.getCritDamage();
        } else {
            return baseDamage;
        }
    }
}
