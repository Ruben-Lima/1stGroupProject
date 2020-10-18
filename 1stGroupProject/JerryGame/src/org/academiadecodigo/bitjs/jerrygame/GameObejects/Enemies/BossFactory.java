package org.academiadecodigo.bitjs.jerrygame.GameObejects.Enemies;


import java.util.LinkedList;

public class BossFactory {

    private static LinkedList<Integer> pos = new LinkedList<>();

    public static Boss spawn(int boss) {


        System.out.println("list size" + pos.size());
        int i = randomNumber(pos.size());
        System.out.println(i);

        switch (boss){
            case 0:
                return new Boss(pos.remove(i), BossType.MARI.getPath());
            case 1:
                i = randomNumber(pos.size());
                System.out.println(i);
                return new Boss(pos.remove(i), BossType.JOJO.getPath());
            case 2:
                i = randomNumber(pos.size());
                System.out.println(i);
                return new Boss(pos.remove(i), BossType.G.getPath());
            case 3:
                i = randomNumber(pos.size());
                return new Boss(pos.remove(i), BossType.MR9TEEN.getPath());

            default:
                System.out.println("DEU MERDA");
        }
        return null;
    }

    private static int randomNumber(int max){
        return (int) (Math.random() * max);
    }

    public static void init(){
        pos.add(75);
        pos.add(150);
        pos.add(250);
        pos.add(350);
    }
}
