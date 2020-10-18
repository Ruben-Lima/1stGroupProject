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
    private LinkedList<Integer> pos = new LinkedList<>();

    public Boss(int boss) {
        //the values defined in this constructor are susceptible to change as we start testing
        pos.add(75);
        pos.add(150);
        pos.add(250);
        pos.add(350);

        int i = randomNumber(pos.size());

        switch (boss){
            case 0:
                //System.out.println(BossType.MARI.getPath());
                this.picture = new Picture(850, pos.remove(i), BossType.MARI.getPath());
                break;
            case 1:
                i = randomNumber(pos.size());
                this.picture = new Picture(850, pos.remove(i), BossType.JOJO.getPath());
                break;
            case 2:
                i = randomNumber(pos.size());
                this.picture = new Picture(850, pos.remove(i), BossType.G.getPath());
                break;
            case 3:
                i = randomNumber(pos.size());
                this.picture = new Picture(850, pos.remove(i), BossType.MR9TEEN.getPath());
                break;
            default:
                System.out.println("DEU MERDA");
        }
        this.picture.draw();
    }

    public int randomNumber(int max){
        return (int) Math.random() * max;
    }

    public void attack() {
        //implementation of the specific attack the boss should have

    }

    public static boolean isDead() {
        return dead;
    }
}
