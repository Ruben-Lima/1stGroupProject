package org.academiadecodigo.bitjs.jerrygame.Enemies;

import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;

public class Boss extends Enemy {

    public Boss(GridPosition pos) {
        //the values defined in this constructor are susceptible to change as we start testing
        super(300, 80, EnemyType.BOSS, pos);
    }

    @Override
    public void attack() {
        //implementation of the specific attack the boss should have
    }
}
