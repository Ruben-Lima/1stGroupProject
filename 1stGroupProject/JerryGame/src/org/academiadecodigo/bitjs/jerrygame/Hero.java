package org.academiadecodigo.bitjs.jerrygame;

import org.academiadecodigo.bitjs.jerrygame.grid.Grid;
import org.academiadecodigo.bitjs.jerrygame.grid.GridDirection;
import org.academiadecodigo.bitjs.jerrygame.grid.position.AbstractGridPosition;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.bitjs.jerrygame.room.Room;
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

    private GridDirection dir;
    private Picture picture0;
    private Picture picture1;
    private Picture picture2;
    private Picture currentPic;

    private Keyboard keyboard;
    private KeyboardEvent right;
    private KeyboardEvent left;
    private KeyboardEvent up;
    private KeyboardEvent down;
    private KeyboardEvent j;


    public Hero(GridPosition gridPosition, Room room) {
        super(room.getCols()/10, room.getRows() / 2, room);
        this.room = room;
        this.picture0 = new Picture(room.collToX(this.col), room.rowToY(this.row),"resources/Jerry0.png");
        this.picture0 = new Picture(room.collToX(this.col), room.rowToY(this.row), "resources/Jerry1.png");
        this.picture0 = new Picture(room.collToX(this.col), room.rowToY(this.row), "resources/Jerry2.png");
        this.pos = gridPosition;
        this.health = 200; //this value is not final so it can and should be changed as we start testing the game
        this.dead = false;
    }

    public void init(){
        this.keyboard = new Keyboard(this);
        this.currentPic = picture0;
        this.currentPic.draw();
        this.setKeys();
    }

    private void attack(int damage){

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

    private void setPictureDirection(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            picture2.draw();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            picture1.draw();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            picture0.draw();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            picture0.draw();
        }
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

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void moveInDirection(GridDirection direction, int distance){
        int initialX = room.collToX(getCol());
        System.out.println(initialX);
        int initialY = room.rowToY(getRow());
        super.moveInDirection(direction, distance);
        int finalX = room.collToX(super.getCol());
        System.out.println(finalX);
        int finalY = room.rowToY(super.getRow());

        currentPic.translate(finalX - initialX, finalY - initialY);

    }

    private void setGraphicDir(GridDirection dir){
        this.dir = dir;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            moveInDirection(GridDirection.UP, 1) ;
            setGraphicDir(GridDirection.UP);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            moveInDirection(GridDirection.DOWN, 1) ;
            setGraphicDir(GridDirection.DOWN);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            moveInDirection(GridDirection.RIGHT, 1) ;
            setGraphicDir(GridDirection.RIGHT);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            moveInDirection(GridDirection.LEFT, 1) ;
            setGraphicDir(GridDirection.LEFT);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_J){
            attack(ATTACK_DAMAGE);
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
        this.picture0.delete();
        this.picture1.delete();
        this.picture2.delete();
    }
}
