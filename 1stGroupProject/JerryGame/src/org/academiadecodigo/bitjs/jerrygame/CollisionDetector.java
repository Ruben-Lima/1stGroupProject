package org.academiadecodigo.bitjs.jerrygame;

import org.academiadecodigo.bitjs.jerrygame.GameObejects.Hero;

public class CollisionDetector {
    private Enemy[] enemies;
    //private Hero hero;

    public CollisionDetector(Enemy[] enemies) {
        this.enemies = enemies;
    }

    public void checkEnemies(Enemy enemy) {

        for (Enemy ic : enemies) {

            // No point in checking collisions with self
            if (ic == enemy) {
                continue;
            }

            if (ic.getPos().equals(enemy.getPos())) {
                //if 2 enemies happen to be on the same space, or about to be, they should move to another direction
            }
        }

    }

    public void checkHero(Hero hero) {
        for (Enemy enemy : enemies) {
            if (enemy.getPos() == hero.getPos()) {
                //this if should be changed depending on the dimensions of each object
                //this if will have the implementation to see if an enemy is touching the hero if so should deal damage
            }
        }
    }
}
