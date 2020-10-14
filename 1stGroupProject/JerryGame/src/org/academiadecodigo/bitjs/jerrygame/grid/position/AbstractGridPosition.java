package org.academiadecodigo.bitjs.jerrygame.grid.position;

import org.academiadecodigo.bitjs.jerrygame.grid.Grid;
import org.academiadecodigo.bitjs.jerrygame.grid.GridDirection;

public abstract class AbstractGridPosition implements GridPosition {

        private int col;
        private int row;
        private Grid grid;

        /**
         * Construct a new grid position at a specific column and row
         *
         * @param col   the column of the grid position
         * @param row   the row of the grid position
         * @param grid  the grid in which the position will be displayed
         */
        public AbstractGridPosition(int col, int row, Grid grid) {
            this.col = col;
            this.row = row;
            this.grid = grid;
        }

        public Grid getGrid() {
            return grid;
        }

        /**
         * @see GridPosition#setPos(int, int)
         */
        @Override
        public void setPos(int col, int row) {
            this.col = col;
            this.row = row;
            show();
        }

        /**
         * @see GridPosition#getCol()
         */
        @Override
        public int getCol() {
            return col;
        }

        /**
         * @see GridPosition#getRow()
         */
        @Override
        public int getRow() {
            return row;
        }

        @Override
        public void moveInDirection(GridDirection direction, int distance, int width, int height) {

            switch (direction) {

                case UP:
                    moveUp(distance);
                    break;
                case DOWN:
                    moveDown(distance, height);
                    break;
                case LEFT:
                    moveLeft(distance);
                    break;
                case RIGHT:
                    moveRight(distance, width);
                    break;
            }

        }

        /**
         * @see GridPosition#equals(GridPosition)
         */
        @Override
        public boolean equals(GridPosition pos) {
            return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
        }

        /**
         * Moves the position up
         *
         * @param dist the number of positions to move
         */
        public void moveUp(int dist) {

            int maxRowsUp = dist < getRow() ? dist : getRow();
            setPos(getCol(), getRow() - maxRowsUp);

        }

        /**
         * Moves the position down
         *
         * @param dist the number of positions to move
         */
        public void moveDown(int dist, int height) {

            int maxRowsDown = dist > getGrid().getRows() - (getRow() + height) ? getGrid().getRows() - (getRow() + height) : dist;
            setPos(getCol(), getRow() + maxRowsDown);

        }

        /**
         * Moves the position left
         *
         * @param dist the number of positions to move
         */
        public void moveLeft(int dist) {

            int maxRowsLeft = dist < getCol() ? dist : getCol();
            setPos(getCol() - maxRowsLeft, getRow());

        }

        /**
         * Moves the position right
         *
         * @param dist the number of positions to move
         */
        public void moveRight(int dist, int width) {
            int maxRowsRight = dist > getGrid().getCols() - (getCol() + width) ? getGrid().getCols() - (getCol() + width) : dist;
            setPos(getCol() + maxRowsRight, getRow());
        }

        @Override
        public String toString() {
            return "GridPosition{" +
                    "col=" + col +
                    ", row=" + row +
                    '}';
        }

    }

