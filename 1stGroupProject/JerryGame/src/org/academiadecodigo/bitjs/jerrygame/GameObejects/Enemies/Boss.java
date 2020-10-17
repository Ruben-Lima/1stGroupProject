package org.academiadecodigo.bitjs.jerrygame.GameObejects.Enemies;

import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;

public class Boss extends Enemy {

    public Boss(GridPosition pos) {
        //the values defined in this constructor are susceptible to change as we start testing
        super(EnemyType.BOSS, pos);
    }

    @Override
    public void attack(int attackDamage) {
        //implementation of the specific attack the boss should have
        super.attack(EnemyType.BOSS.getAttackDamage());
    }
}
