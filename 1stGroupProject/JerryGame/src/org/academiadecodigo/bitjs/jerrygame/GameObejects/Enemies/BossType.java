package org.academiadecodigo.bitjs.jerrygame.GameObejects.Enemies;


import java.util.LinkedList;

public enum BossType {
    MARI("JerryGame/resources/Mari.png"),
    JOJO("JerryGame/resources/Jojo.png"),
    MR9TEEN("JerryGame/resources/Mr9teen.png"),
    G("JerryGame/resources/G.png");

    //private int picPos;
    private String path;
    //private int[] pos0;
    //private int[] pos = {0, 0, 0, 0};
    //private LinkedList<Integer> posList = new LinkedList<>();


    BossType(String path){
        this.path = path;
      //  init();

    }
    /*
    private int[] pos1 = {350, 75, 150, 250};
    private int[] pos2 = {250, 350, 75, 150};
    private int[] pos3 = {150, 250, 350, 75};

    private void init(){
        posList.add(75);
        posList.add(150);
        posList.add(250);
        posList.add(350);

        int n = RandomOrder(pos.length);
        for (int i = 0; i < pos.length; i++) {
            pos[n] = posList.get(i);
            posList.remove();

            n = RandomOrder(posList.size());
        }
    }

    private int RandomOrder(int max){
        return (int) Math.random() * max;
    }
/*
    public void setRandomPos(){
        int i = RandomOrder();

        switch (i){
            case 0:
                pos = pos0;
                break;
            case 1:
                pos = pos1;
                break;
            case 2:
                pos = pos2;
                break;
            case 3:
                pos = pos3;
                break;
        }
    }

    public int getPicPos(){
        return this.picPos;
    }
*/
    public String getPath(){
        return this.path;
    }

}
