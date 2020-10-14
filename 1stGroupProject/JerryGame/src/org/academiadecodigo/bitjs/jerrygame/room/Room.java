package org.academiadecodigo.bitjs.jerrygame.room;

import org.academiadecodigo.bitjs.jerrygame.Game;
import org.academiadecodigo.bitjs.jerrygame.grid.Grid;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Room implements Grid {

    public static final int PADDING = 10;
    private int cols;
    private int rows;
    private int cellSize;
    private int col;
    private int row;

    protected Game game;
    protected Picture picture;

    public Room(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.cellSize = 10;
    }

    @Override
    public void init() {

    }


    public int rowToY(int row){
        return row + PADDING;
    }

    public int collToX(int col){
        return col + PADDING;
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

    public Picture getPicture(){
        return this.picture;
    }

    public int getCellSize(){
        return this.cellSize;
    }

    public void setPicture(Picture picture){
        this.picture = picture;
    }

    public void setCol(int col){
        this.col = col;
    }

    public void setRow(int row){
        this.row = row;
    }

    public  void setPos(int col, int row){
        this.setCol(col);
        this.setRow(row);
    }

}
