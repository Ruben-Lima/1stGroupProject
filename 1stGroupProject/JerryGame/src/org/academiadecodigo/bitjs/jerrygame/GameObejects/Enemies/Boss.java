package org.academiadecodigo.bitjs.jerrygame.GameObejects.Enemies;

import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.bitjs.jerrygame.room.Room;

public class Boss {
    private static int attackDamage = 30;
    private static int health = 200;
    private static boolean dead = false;
    private GridPosition pos;
    private Room room;

    public Boss() {
        //the values defined in this constructor are susceptible to change as we start testing

    }

    public void attack() {
        //implementation of the specific attack the boss should have

    }

    public static boolean isDead() {
        return dead;
    }
}
