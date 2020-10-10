package org.academiadecodigo.bitjs.jerrygame.room;

import org.academiadecodigo.bitjs.jerrygame.grid.Grid;
import org.academiadecodigo.bitjs.jerrygame.grid.position.AbstractGridPosition;

public class RoomPosition extends AbstractGridPosition {
    /**
     * Construct a new grid position at a specific column and row
     *
     * @param col  the column of the grid position
     * @param row  the row of the grid position
     * @param grid the grid in which the position will be displayed
     */
    public RoomPosition(int col, int row, Grid grid) {
        super(col, row, grid);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }
}
