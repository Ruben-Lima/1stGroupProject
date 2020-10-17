package org.academiadecodigo.bitjs.jerrygame.GameObejects;

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
    //private int col;
    //private int row;
    private Grid grid;
    private int health;
    private boolean dead;
    private Room room;
    public Projectile bullet;
    //maybe create a new property that will count how many time you shoot and after x times it shoots another laser with more damage

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
        bullet = new Projectile(getPos(), this.room, dir);
    }

    public void init(){
        this.keyboard = new Keyboard(this);
        show();
        this.setKeys();
    }

    public void shoot() {
        bullet.travel();
    }

    public void hit(int damage) {
        if (damage > health) {
            dead();
            return;
        }

        this.health -= damage;
    }

    public int getATTACK_DAMAGE() {
        return ATTACK_DAMAGE;
    }

    public void setHealth(int health) {
        this.health = health;
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

        right.setKey(KeyboardEvent.KEY_D);
        left.setKey(KeyboardEvent.KEY_A);
        up.setKey(KeyboardEvent.KEY_W);
        down.setKey(KeyboardEvent.KEY_S);
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

    public void moveUp() {
        if (currentPic.getY() - 30 >= 10){
            currentPic.translate(0, -30);
        }
    }

    public void moveDown() {
        if (currentPic.getY() - 30 <= 450 - currentPic.getHeight()){
            currentPic.translate(0, 30);
        }
    }

    public void moveRight() {
        if (currentPic.getX() - 30 <= 950 - currentPic.getWidth()){
            currentPic.translate(30, 0);
        }
    }

    public void moveLeft() {
        if (currentPic.getX() - 30 >= 10){
            currentPic.translate(-30, 0);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W){
            dir = GridDirection.UP;
            hide();
            currentPic = new Picture(currentPic.getX(), currentPic.getY(), pictures[1]);
            show();
            moveUp();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S){
            dir = GridDirection.DOWN;
            hide();
            currentPic = new Picture(currentPic.getX(), currentPic.getY(), pictures[2]);
            show();
            moveDown();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D){
            dir = GridDirection.RIGHT;
            hide();
            currentPic = new Picture(currentPic.getX(), currentPic.getY(), pictures[0]);
            show();
            moveRight();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A){
            dir = GridDirection.LEFT;
            hide();
            currentPic = new Picture(currentPic.getX(), currentPic.getY(), pictures[0]);
            show();
            moveLeft();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_J){
            shoot();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void show() {
        currentPic.draw();
    }

    @Override
    public void hide() {
        currentPic.delete();
    }
}
