package org.academiadecodigo.bitjs.jerrygame;

import org.academiadecodigo.bitjs.jerrygame.grid.Grid;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;

public class Hero {
    private final int ATTACK_DAMAGE = 60; //this value is susceptible to change as we start testing, but should remain final

    private GridPosition pos;
    private Grid grid;
    private int health;
    private boolean dead;

    public Hero(GridPosition gridPosition) {
        this.pos = gridPosition;
        this.health = 200; //this value is not final so it can and should be changed as we start testing the game
        this.dead = false;
    }

    public int getATTACK_DAMAGE() {
        return ATTACK_DAMAGE;
    }

    public void setHealth(int health) {
        this.health -= health;
    }

    public int getHealth() {
        return health;
    }

    public void dead() {
        this.dead = true;
    }

    public boolean isDead() {
        return dead;
    }

    public GridPosition getPos() {
        return this.pos;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
