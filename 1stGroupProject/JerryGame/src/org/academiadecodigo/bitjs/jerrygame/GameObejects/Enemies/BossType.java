package org.academiadecodigo.bitjs.jerrygame.GameObejects.Enemies;


public enum BossType {
    MARI("JerryGame/resources/Mari.png"),
    JOJO("JerryGame/resources/Jojo.png"),
    MR9TEEN("JerryGame/resources/Mr9teen.png"),
    G("JerryGame/resources/G.png");

    private String path;


    BossType(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

}
