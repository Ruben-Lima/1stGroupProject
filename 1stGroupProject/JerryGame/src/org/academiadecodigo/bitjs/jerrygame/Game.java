package org.academiadecodigo.bitjs.jerrygame;

import org.academiadecodigo.bitjs.jerrygame.GameObejects.Enemies.Boss;
import org.academiadecodigo.bitjs.jerrygame.GameObejects.Hero;
import org.academiadecodigo.bitjs.jerrygame.room.BigBossRoom;
import org.academiadecodigo.bitjs.jerrygame.room.InitialRoom;
import org.academiadecodigo.bitjs.jerrygame.room.Menu;

public class Game {
    private Menu menu;
    private BigBossRoom bossRoom;
    private InitialRoom initialRoom;
    private Boss[] boss;
    private Hero jerry;
    private Sound laserSound;

    public Game() {
        this.menu = new Menu(this);
        this.bossRoom = new BigBossRoom(this);
        this.jerry = new Hero(menu);
        this.laserSound = new Sound(" JerryGame/resources/laser.wav");
    }

    public void init() {
        this.menu.init();
    }

    public void start() {
        initialRoom = new InitialRoom();
        initialRoom.init();
        jerry.setRoom(initialRoom);
        jerry.init();
        while(!jerry.isToBossFight()){
            delay(10);
        }
        jerry.hide();
        finalBattle();

    }

    public void finalBattle(){
        bossRoom.init();
        jerry.show();
              /*while (!jerry.isDead()) {
            if (jerry.getHasBullet()) {
                //laserSound.play(true);
                while (!jerry.getBullet().getHit()) {
                    delay(5);
                    //System.out.println("shoot");
                    jerry.shoot();
                }
                //System.out.println("teste");
            }

            delay(20);
        }*/
    }

    public void delay(int miliseconds){

        try{
            Thread.sleep(miliseconds);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
