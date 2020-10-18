package org.academiadecodigo.bitjs.jerrygame;

import org.academiadecodigo.bitjs.jerrygame.GameObejects.Enemies.Boss;
import org.academiadecodigo.bitjs.jerrygame.GameObejects.Hero;

public class CollisionDetector {
    private Hero hero;
    private Boss[] boss;

    public CollisionDetector(Hero hero, Boss[] boss) {
        this.hero = hero;
        this.boss = boss;
    }

    public void checkHit(Hero hero) {

    }

    public void checkHit(Boss boss) {

    }
}
