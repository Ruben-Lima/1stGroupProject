package org.academiadecodigo.bitjs.jerrygame.room;

import org.academiadecodigo.bitjs.jerrygame.grid.GridDirection;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class InitialRoom extends Room{

    public InitialRoom(){
        super(1000, 500);
        picture = new Picture(PADDING, PADDING, "JerryGame/resources/relvaNormal.png");
    }

    @Override
    public void init(){
        picture.draw();
    }

}
