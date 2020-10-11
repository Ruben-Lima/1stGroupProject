package org.academiadecodigo.bitjs.jerrygame.room;

import org.academiadecodigo.bitjs.jerrygame.grid.Grid;
import org.academiadecodigo.bitjs.jerrygame.grid.position.AbstractGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RoomPosition extends AbstractGridPosition {

    private Picture picture;
    private Grid grid;

    /**
     * Construct a new grid position at a specific column and row
     *
     * @param col  the column of the grid position
     * @param row  the row of the grid position
     * @param grid the grid in which the position will be displayed
     */
    public RoomPosition(int col, int row, Grid grid) {
        super(col, row, grid);

        this.grid = grid;

        //picture = new Picture();

        show();
    }

    @Override
    public void show() {
        picture.draw();
    }

    @Override
    public void hide() {
        picture.delete();
    }
}
