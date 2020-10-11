package org.academiadecodigo.bitjs.jerrygame.Enemies;

public enum EnemyType {
    //this enum should have something more but i don't know exactly what right now
    BOSS(300, 80),
    NORMAL(100, 30);

    private int maxHealth;
    private int attackDamage;

    EnemyType(int maxHealth, int attackDamage){
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttackDamage() {
        return attackDamage;
    }
}
