package org.academiadecodigo.bitjs.jerrygame.GameObejects.Enemies;


import java.util.LinkedList;

public class BossFactory {

    private static LinkedList<Integer> pos = new LinkedList<>();

    public static Boss spawn(int boss) {



        int i = randomNumber(pos.size() / 2);

        switch (boss){
            case 0:
                return new Boss(pos.remove(i + pos.size()/2),  pos.remove(i), BossType.MARI.getPath());
            case 1:
                i = randomNumber(pos.size() / 2);
                System.out.println(i);
                return new Boss(pos.remove( i + pos.size()/2), pos.remove(i), BossType.JOJO.getPath());
            case 2:
                i = randomNumber(pos.size()/2);
                System.out.println(i);
                return new Boss(pos.remove(i + pos.size()/2), pos.remove(i), BossType.G.getPath());
            case 3:
                i = randomNumber(pos.size() / 2);
                return new Boss(pos.remove(i + pos.size()/2), pos.remove(i), BossType.MR9TEEN.getPath());

            default:
                System.out.println("DEU MERDA");
        }
        return null;
    }

    private static int randomNumber(int max){
        return (int) (Math.random() * max);
    }

    public static void init(){
        pos.add(123);
        pos.add(194);
        pos.add(255);
        pos.add(312);



        pos.add(887);
        pos.add(891);
        pos.add(890);
        pos.add(863);

    }
}
