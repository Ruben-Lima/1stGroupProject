package org.academiadecodigo.bitjs.jerrygame.GameObejects;

import org.academiadecodigo.bitjs.jerrygame.grid.GridDirection;
import org.academiadecodigo.bitjs.jerrygame.grid.position.AbstractGridPosition;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.bitjs.jerrygame.room.Room;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Projectile extends AbstractGridPosition {
    private boolean hit;
    private boolean shot;
    private Picture currentProjectile;
    private String[] projectiles;
    private Room room;
    //private GridPosition pos;
    private GridDirection dir;

    public Projectile(GridPosition pos, Room room, GridDirection dir) {
        super(Room.PADDING, Room.PADDING, room);
        this.room = room;
        this.dir = dir;
        //this.pos = pos;
        this.projectiles = new String[5];
        this.hit = true;
        addPictures();
        initialisePicture(this.dir);
        //travel();
    }

    private void initialisePicture(GridDirection dir) {
        if (dir == GridDirection.LEFT) {
            currentProjectile = new Picture(Room.PADDING, Room.PADDING, projectiles[4]);
            return;
        }
        currentProjectile = new Picture(Room.PADDING, Room.PADDING, projectiles[0]);
    }

    private void addPictures() {
        projectiles[0] = "JerryGame/resources/blue_laser_side.png";
        projectiles[1] = "JerryGame/resources/blue_laser.png";
        projectiles[2] = "JerryGame/resources/green_laser_side.png";
        projectiles[3] = "JerryGame/resources/green_laser.png";
        projectiles[4] = "JerryGame/resources/enemy_laser_side.png";
    }

    public void travel() {
        hit = false;
        show();
        currentProjectile.translate(20, 0);
        System.out.println(Thread.currentThread());
        show();
        if (currentProjectile.getX() + currentProjectile.getWidth() >= room.getCols()) {
            hit = true;
        }
    }

    @Override
    public void show() {
        currentProjectile.draw();
    }

    @Override
    public void hide() {
        currentProjectile.delete();
    }

    public boolean isShot() {
        return this.shot;
    }

    public void setShot(boolean shot) {
        this.shot = shot;
    }

    public boolean getHit() {
        return hit;
    }
}
