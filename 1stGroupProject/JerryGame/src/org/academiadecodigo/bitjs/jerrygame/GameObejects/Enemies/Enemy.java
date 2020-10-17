package org.academiadecodigo.bitjs.jerrygame.GameObejects.Enemies;

import org.academiadecodigo.bitjs.jerrygame.CollisionDetector;
import org.academiadecodigo.bitjs.jerrygame.Message;
import org.academiadecodigo.bitjs.jerrygame.grid.Grid;
import org.academiadecodigo.bitjs.jerrygame.grid.GridDirection;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;

public class Enemy {
    private GridPosition pos;
    private Grid grid;
    private EnemyType enemyType;

    private int health;
    private int attackDamage;
    private boolean dead;

    //allows direct access from subclasses
    protected CollisionDetector collisionDetector;
    protected GridDirection currentDirection;

    public Enemy(EnemyType enemyType, GridPosition gridPosition) {
        //the values received in this constructor are susceptible to change
        //this.health = health;
        //this.attackDamage = attackDamage;
        this.enemyType = enemyType;
        this.pos = gridPosition;
        this.dead = false;
        this.health = this.enemyType.getMaxHealth();
        this.attackDamage = this.enemyType.getAttackDamage();
    }

    public boolean isHittingWall() {

        switch (currentDirection) {
            case LEFT:
                if (getPos().getCol() == 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (getPos().getCol() == grid.getCols() - 1) {
                    return true;
                }
                break;
            case UP:
                if (getPos().getRow() == 0) {
                    return true;
                }
                break;
            case DOWN:
                if (getPos().getRow() == grid.getRows() - 1) {
                    return true;
                }
        }

        return false;

    }

    /*public void move(GridDirection direction, int speed) {

        // Crashed cars can not accelerate
        if (isDead()) {
            return;
        }

        GridDirection newDirection = direction;

        // Perform a U turn if we have bumped against the wall
        if (isHittingWall()) {
            newDirection = direction.oppositeDirection();
        }

        // Accelerate in the choosen direction
        this.currentDirection = newDirection;
        for (int i = 0; i < speed; i++) {
            getPos().moveInDirection(newDirection, 1);
            if (collisionDetector.isUnSafe(getPos())) {
                setDead();
                break;
            }
        }

    }*/

    public void attack(int attackDamage) {
        //implementation of the attack the enemies should have
        this.health = attackDamage > this.health ? 0 : this.health - attackDamage;

        if(health <= 0){
            System.out.println(Message.ENEMY_DEATH);
            dead = true;
            return;
        }
        System.out.println(Message.REMAINING_HEALTH + health);
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public GridPosition getPos() {
        return this.pos;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health -= health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setDead(){
        this.dead = true;
    }

    public boolean isDead() {
        return dead;
    }
}
