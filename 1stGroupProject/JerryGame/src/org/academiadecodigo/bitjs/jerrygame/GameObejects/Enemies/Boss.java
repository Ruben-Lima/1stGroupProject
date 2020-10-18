package org.academiadecodigo.bitjs.jerrygame.GameObejects.Enemies;

import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.bitjs.jerrygame.room.Room;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Boss {
    private static int attackDamage = 30;
    private static int health = 200;
    private static boolean dead = false;
    private Room room;
    private Picture picture;

    public Boss(int x, int y, String path) {
        //the values defined in this constructor are susceptible to change as we start testing
       this.picture = new Picture(x, y, path);
        this.picture.draw();
    }



    public void attack() {
        //implementation of the specific attack the boss should have

    }

    public static boolean isDead() {
        return dead;
    }
}
