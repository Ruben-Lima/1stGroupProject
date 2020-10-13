package org.academiadecodigo.bitjs.jerrygame.room;

import org.academiadecodigo.bitjs.jerrygame.Game;
import org.academiadecodigo.bitjs.jerrygame.grid.GridDirection;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu extends Room implements KeyboardHandler {

    private boolean started;
    private Game game;
    private Text startText;
    private Text quitText;
    private Keyboard keyboard;
    private KeyboardEvent space;
    private KeyboardEvent q;


    public Menu (Game game){
        super(100, 50);
        this.game = game;
        started = false;
    }

    @Override
    public void init(){
        this.setPicture(new Picture(PADDING, PADDING, "resources/Menu_00.png"));
        this.startText = new Text(collToX(getCols()/2), rowToY(getRows() /4), "PRESS SPACE TO START");
        this.quitText = new Text(collToX(getCols() /2), rowToY(getRows()  / 3), "PRESS Q TO QUIT");
        getPicture().draw();
        this.keyboard = new Keyboard(this);
        setKeys();
        this.startText.draw();
        this.quitText.draw();
    }

    private void setKeys(){
        this.space = new KeyboardEvent();
        this.q = new KeyboardEvent();

        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        q.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        space.setKey(KeyboardEvent.KEY_SPACE);
        q.setKey(KeyboardEvent.KEY_Q);

        keyboard.addEventListener(space);
        keyboard.addEventListener(q);
    }




    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (!started) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
                this.game.start();
                started = true;
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_Q) {
                System.out.println("THIS IS SUPOSED TO QUIT THE GAME");
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
