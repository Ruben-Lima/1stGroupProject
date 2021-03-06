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
    private boolean deleteMenu;
    private Text startText;
    private Text quitText;
    private Keyboard keyboard;
    private KeyboardEvent space;
    private KeyboardEvent q;
    private Picture[] pictures;
    private Picture picture2;
    private Picture picture3;

    public Menu(Game game) {
        super(1000, 500);
        this.game = game;
        start = false;
        deleteMenu = false;
        pictures = new Picture[3];
        pictures[0] = new Picture(PADDING, PADDING, "JerryGame/resources/Menu1.jpg");
        pictures[1] = new Picture(PADDING, PADDING, "JerryGame/resources/Menu2.jpg");
        pictures[2] = new Picture(PADDING, PADDING, "JerryGame/resources/Menu3.jpg");
    }

    @Override
    public void init() {
        pictures[0].draw();
        this.keyboard = new Keyboard(this);
        setKeys();
        while (!start){
            for (int i = 0; i < pictures.length; i++) {
                game.delay(80);
                if (i == 0) {
                    pictures[1].delete();
                    pictures[2].delete();
                    pictures[0].draw();
                    continue;
                }

                if (i == 1) {
                    pictures[0].delete();
                    pictures[2].delete();
                    pictures[1].draw();
                    continue;
                }

                if (i == 2) {
                    pictures[0].delete();
                    pictures[1].delete();
                    pictures[2].draw();
                    continue;
                }
            }
            game.delay(80);
            if (deleteMenu) {
                deleteMenu();
            }
        }
        this.game.start();
    }

    public void deleteMenu() {
        for (int i = 0; i < pictures.length; i++) {
            pictures[i].delete();
        }
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
                deleteMenu = true;
                start = true;
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
