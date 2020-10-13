package org.academiadecodigo.bitjs.jerrygame.room;

import org.academiadecodigo.bitjs.jerrygame.grid.GridDirection;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class InitialRoom extends Room{


    public InitialRoom(){
        super(50, 100);
    }

    @Override
    public void init(){
        this.setPicture(new Picture(PADDING, PADDING, "resources/relva_rot_90.png"));
        this.getPicture().draw();
    }

    @Override
    public void show() {
        this.getPicture().draw();
    }

    @Override
    public void hide() {
        this.getPicture().delete();
    }

    @Override
    public void moveInDirection(GridDirection direction, int distance) {

    }

    @Override
    public boolean equals(GridPosition position) {
        return false;
    }

    @Override
    public int getCol() {
        return this.getCol();
    }

    @Override
    public int getRow() {
        return this.getRow();
    }

}
