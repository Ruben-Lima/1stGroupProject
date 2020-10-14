package org.academiadecodigo.bitjs.jerrygame;

import org.academiadecodigo.bitjs.jerrygame.grid.Grid;
import org.academiadecodigo.bitjs.jerrygame.grid.GridDirection;
import org.academiadecodigo.bitjs.jerrygame.grid.position.AbstractGridPosition;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.bitjs.jerrygame.room.Room;
import org.academiadecodigo.bitjs.jerrygame.room.RoomPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Hero extends AbstractGridPosition implements KeyboardHandler {
    private final int ATTACK_DAMAGE = 60; //this value is susceptible to change as we start testing, but should remain final

    private GridPosition pos;
    private int col;
    private int row;
    private Grid grid;
    private int health;
    private boolean dead;
    private Room room;
    //maybe create a new property that will count how many time you shoot and after x times it shoots another laser

    private GridDirection dir;
    private Picture currentPic;
    private String[] pictures = new String[3];

    private Keyboard keyboard;
    private KeyboardEvent right;
    private KeyboardEvent left;
    private KeyboardEvent up;
    private KeyboardEvent down;
    private KeyboardEvent j;

    // GridPosition gridPosition, Room room
    public Hero(Room room) {
        super(0, 215, room);

        this.room = room;
        pictures[0] = "JerryGame/resources/JerryRight.png";
        pictures[1] = "JerryGame/resources/JerryUp.png";
        pictures[2] = "JerryGame/resources/JerryDown.png";
        currentPic = new Picture(room.collToX(getCol()), room.rowToY(getRow()), pictures[0]);
        this.health = 200; //this value is not final so it can and should be changed as we start testing the game
        this.dead = false;
        dir = GridDirection.RIGHT;
    }

    public void init(){
        this.keyboard = new Keyboard(this);
        this.currentPic.draw();
        this.setKeys();
    }

    private void shoot(){

    }

    public int getATTACK_DAMAGE() {
        return ATTACK_DAMAGE;
    }

    public void setHealth(int health) {
        this.health -= health;
    }

    public void setKeys(){
        right = new KeyboardEvent();
        left= new KeyboardEvent();
        up = new KeyboardEvent();
        down = new KeyboardEvent();
        j = new KeyboardEvent();

        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        j.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        right.setKey(KeyboardEvent.KEY_RIGHT);
        left.setKey(KeyboardEvent.KEY_LEFT);
        up.setKey(KeyboardEvent.KEY_UP);
        down.setKey(KeyboardEvent.KEY_DOWN);
        j.setKey(KeyboardEvent.KEY_J);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(j);
    }

    public int getHealth() {
        return health;
    }

    public void dead() {
        this.dead = true;
    }

    public boolean isDead() {
        return dead;
    }

    public GridPosition getPos() {
        return this.pos;
    }

    public void setPos(GridPosition pos) {
        this.pos = pos;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }


    public void move(){
        int initialX = currentPic.getX();
        int initialY = currentPic.getY();

        super.moveInDirection(dir, 10, currentPic.getWidth(), currentPic.getHeight());

        int differenceX = room.collToX(super.getCol()) - initialX;
        int differenceY = room.rowToY(super.getRow()) - initialY;

        currentPic.translate(differenceX, differenceY);
    }

    private void setGraphicDir(GridDirection dir){
        this.dir = dir;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            dir = GridDirection.UP;
            currentPic.delete();
            currentPic = new Picture(currentPic.getX(), currentPic.getY(), pictures[1]);
            currentPic.draw();
            move();
            /*moveInDirection(GridDirection.UP, 1) ;
            setGraphicDir(GridDirection.UP);*/
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            dir = GridDirection.DOWN;
            currentPic.delete();
            currentPic = new Picture(currentPic.getX(), currentPic.getY(), pictures[2]);
            currentPic.draw();
            move();
            /*moveInDirection(GridDirection.DOWN, 1) ;
            setGraphicDir(GridDirection.DOWN);*/
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            dir = GridDirection.RIGHT;
            currentPic.delete();
            currentPic = new Picture(currentPic.getX(), currentPic.getY(), pictures[0]);
            currentPic.draw();
            move();
            /*moveInDirection(GridDirection.RIGHT, 1) ;
            setGraphicDir(GridDirection.RIGHT);*/
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            dir = GridDirection.LEFT;
            currentPic.delete();
            currentPic = new Picture(currentPic.getX(), currentPic.getY(), pictures[0]);
            currentPic.draw();
            move();
            /*moveInDirection(GridDirection.LEFT, 1) ;
            setGraphicDir(GridDirection.LEFT);*/
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_J){
            //attack();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }
}
