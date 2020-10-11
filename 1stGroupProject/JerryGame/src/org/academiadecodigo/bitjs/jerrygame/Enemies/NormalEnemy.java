package org.academiadecodigo.bitjs.jerrygame.Enemies;

import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;

public class NormalEnemy extends Enemy {

    public NormalEnemy(GridPosition pos) {
        //the values defined in this constructor are susceptible to change as we start testing
        super(100, 30, EnemyType.NORMAL, pos);
    }
}
