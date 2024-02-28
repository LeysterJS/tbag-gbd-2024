package de.tbag.gbd.combat;

/**
 * @author Lukas Knappich
 * @version 1.0
 * @since 28.02.24
 */

public class Combat {
    public static void engageInCombat(Player player, Enemy enemy) {
        System.out.println("A wild " + enemy.getName() + " appears!");

        while (player.getHealth() > 0 && enemy.getHp() > 0) {
            int playerDamage = playerAttack(player.getEquippedWeapon());
            System.out.println(player.getEquippedWeapon());
            enemy.takeDamage(playerDamage);
            System.out.println(player.getName() + " hits the " + enemy.getName() + " for " + playerDamage + " damage!");

            if (enemy.getHp() <= 0) {
                System.out.println("The " + enemy.getName() + " has been defeated!");
                break;
            }

            double enemyDamage = enemy.attack();
            double playerHealth = player.getHealth();
            player.setHealth(playerHealth - enemyDamage);
            System.out.println("The " + enemy.getName() + " attacks " + player.getName() + " for " + enemyDamage + " damage!");

            if (player.getHealth() <= 0) {
                System.out.println(player.getName() + " has been defeated!");
                break;
            }
        }
    }

    private static int playerAttack(Weapon weapon) {
        if (weapon != null) {
            int baseDamage = (int) (Math.random() * (weapon.getMaxDamage() - 100)) + 100; // Set minimum base damage to 100

            System.out.println(baseDamage);
            System.out.println((weapon.getMaxDamage() - 100) + 100);

                return baseDamage;

        } else {
            return (int) (Math.random() * 10) + 1; // Simple random damage example if the player has no weapon
        }
    }
}
