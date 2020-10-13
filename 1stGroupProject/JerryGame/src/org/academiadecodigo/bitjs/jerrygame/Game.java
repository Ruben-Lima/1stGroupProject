package org.academiadecodigo.bitjs.jerrygame;

import org.academiadecodigo.bitjs.jerrygame.room.BigBossRoom;
import org.academiadecodigo.bitjs.jerrygame.room.Menu;

public class Game {
    private Menu menu;
    private BigBossRoom bossRoom;
    private Hero jerry;

    public Game(){
        this.menu = new Menu(this);
        this.bossRoom = new BigBossRoom(this);
        this.jerry = new Hero(bossRoom, bossRoom);
    }

    public void init(){
        this.menu.init();
    }

    public void start(){
        this.bossRoom.init();
        this.menu = null;
        jerry.init();
    }
}
