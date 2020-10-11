package org.academiadecodigo.bitjs.jerrygame.room;

import org.academiadecodigo.bitjs.jerrygame.grid.Grid;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Room implements Grid {

    public static final int PADDING = 10;
    private int cols;
    private int rows;

    private Picture picture;

    public Room(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    @Override
    public void init() {
        //to initialize new picture here
        //picture = new Picture();
        //picture.draw();
    }

    @Override
    public int getCols() {
        return this.cols;
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public GridPosition makeGridPosition() {
        return null;
    }

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return null;
    }
}
