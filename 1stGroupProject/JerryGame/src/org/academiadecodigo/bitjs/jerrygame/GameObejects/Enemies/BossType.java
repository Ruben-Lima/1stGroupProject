package org.academiadecodigo.bitjs.jerrygame.GameObejects.Enemies;


public enum BossType {
    MARI("JerryGame/resources/Mari_2px.png"),
    JOJO("JerryGame/resources/Jojo_2px.png"),
    MR9TEEN("JerryGame/resources/Ricky_2px.png"),
    G("JerryGame/resources/G_2px.png");

    private String path;


    BossType(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

}
