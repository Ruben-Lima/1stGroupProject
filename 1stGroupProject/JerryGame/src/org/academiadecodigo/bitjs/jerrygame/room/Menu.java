package org.academiadecodigo.bitjs.jerrygame.room;

import org.academiadecodigo.bitjs.jerrygame.Game;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu extends Room implements KeyboardHandler {
    private boolean start;
    private Text startText;
    private Text quitText;
    private Keyboard keyboard;
    private KeyboardEvent space;
    private KeyboardEvent q;

    public Menu(Game game) {
        super(1000, 500);
        this.game = game;
        start = false;
        picture = new Picture(PADDING, PADDING, "JerryGame/resources/Menu_00.png");
    }

    @Override
    public void init() {
        picture.draw();
        this.startText = new Text(collToX(picture.getWidth() * 2 / 3), rowToY(picture.getHeight() / 3), "PRESS SPACE TO START");
        this.quitText = new Text(collToX(picture.getWidth() * 2 / 3), rowToY(picture.getHeight() / 2), "PRESS Q TO QUIT");
        this.keyboard = new Keyboard(this);
        setKeys();
        this.startText.draw();
        this.quitText.draw();
    }

    private void setKeys() {
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
        if (!start) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
                picture.delete();
                startText.delete();
                quitText.delete();
                start = true;
                this.game.start();
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_Q) {
                System.exit(0);
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
