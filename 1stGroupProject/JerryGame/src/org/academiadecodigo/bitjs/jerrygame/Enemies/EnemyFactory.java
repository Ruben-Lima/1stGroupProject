package org.academiadecodigo.bitjs.jerrygame.Enemies;

import org.academiadecodigo.bitjs.jerrygame.grid.Grid;

public class EnemyFactory {

    public static Enemy makeNewEnemy(Grid grid) {
        return new NormalEnemy(grid.makeGridPosition());
    }

    public static Boss makeBoss(Grid grid) {
        //this grid.makeGridPosition will most likely receive the exact coordinates to spawn to boss and not make it random
        return new Boss(grid.makeGridPosition());
    }
}
