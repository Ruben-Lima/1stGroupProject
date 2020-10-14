package org.academiadecodigo.bitjs.jerrygame;

import org.academiadecodigo.bitjs.jerrygame.room.BigBossRoom;
import org.academiadecodigo.bitjs.jerrygame.room.InitialRoom;
import org.academiadecodigo.bitjs.jerrygame.room.Menu;

public class Game {
    private Menu menu;
    private BigBossRoom bossRoom;
    private InitialRoom initialRoom;
    private Hero jerry;

    public Game(){
        this.menu = new Menu(this);
        this.bossRoom = new BigBossRoom(this);
        this.jerry = new Hero(menu);
    }

    public void init(){
        this.menu.init();
    }

    public void start(){
        initialRoom = new InitialRoom();
        initialRoom.init();
        jerry.setGrid(initialRoom);
        jerry.init();
    }
}
