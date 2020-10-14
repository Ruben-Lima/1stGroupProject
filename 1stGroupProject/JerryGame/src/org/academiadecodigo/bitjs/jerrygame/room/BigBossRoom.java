package org.academiadecodigo.bitjs.jerrygame.room;

import org.academiadecodigo.bitjs.jerrygame.Game;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BigBossRoom extends Room{
    private Game game;
    private int col;
    private int row;

    public BigBossRoom(Game game){
        super(50, 100);
        this.game = game;

    }

    @Override
    public void init() {
        this.setPicture(new Picture(PADDING, PADDING, "resources/Outside_10px_2.png"));
        getPicture().draw();
    }

}
