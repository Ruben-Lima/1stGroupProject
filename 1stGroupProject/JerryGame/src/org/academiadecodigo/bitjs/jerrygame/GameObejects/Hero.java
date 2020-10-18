package org.academiadecodigo.bitjs.jerrygame.GameObejects;

import org.academiadecodigo.bitjs.jerrygame.Sound;
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
    private boolean hasBullet;
    private Room room;
    public Projectile bullet;
    //maybe create a new property that will count how many time you shoot and after x times it shoots another laser with more damage

    private GridDirection dir;
    private Picture currentPic;
    private Sound laserSound;

    private Keyboard keyboard;
    private KeyboardEvent right;
    private KeyboardEvent left;
    private KeyboardEvent up;
    private KeyboardEvent down;
    private KeyboardEvent j;

    // GridPosition gridPosition, Room room
    public Hero(Room room) {
        super(0, 215, room);
        laserSound = new Sound(" JerryGame/resources/laser.wav");
        this.room = room;
        currentPic = new Picture(room.collToX(getCol()), room.rowToY(getRow()), "JerryGame/resources/JerryRight.png");
        this.health = 200; //this value is not final so it can and should be changed as we start testing the game
        this.dead = false;
        dir = GridDirection.RIGHT;
        hasBullet = false;
    }

    public void init(){
        this.keyboard = new Keyboard(this);
        show();
        this.setKeys();
        bullet = new Projectile(this.room, dir);
    }

    public void shoot() {
        bullet.travel();
        hasBullet = false;
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

    public boolean getHasBullet() {
        return hasBullet;
    }

    /*public GridPosition getPos() {
        return this.pos;
    }

    public void setPos(GridPosition pos) {
        this.pos = pos;
    }*/

    public Projectile getBullet() {
        return bullet;
    }

    public void setRoom(Room room) {
        this.room = room;
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
            show();
            moveUp();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S){
            show();
            moveDown();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D){
            show();
            moveRight();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A){
            show();
            moveLeft();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_J){
            hasBullet = true;
            laserSound.play(true);
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
