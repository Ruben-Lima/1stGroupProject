package org.academiadecodigo.bitjs.jerrygame.GameObejects;

import org.academiadecodigo.bitjs.jerrygame.grid.GridDirection;
import org.academiadecodigo.bitjs.jerrygame.grid.position.AbstractGridPosition;
import org.academiadecodigo.bitjs.jerrygame.grid.position.GridPosition;
import org.academiadecodigo.bitjs.jerrygame.room.Room;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Projectile extends AbstractGridPosition {
    private boolean hit;
    private Picture currentProjectile;
    private String[] projectiles;
    private Room room;
    //private GridPosition pos;
    private GridDirection dir;

    public Projectile(Room room, GridDirection dir) {
        super(Room.PADDING, Room.PADDING, room);
        this.room = room;
        this.dir = dir;
        //this.pos = pos;
        this.projectiles = new String[3];
        this.hit = false;
        addPictures();
        initialisePicture(this.dir);
    }

    private void initialisePicture(GridDirection dir) {
        if (dir == GridDirection.LEFT) {
            currentProjectile = new Picture(Room.PADDING, Room.PADDING, projectiles[2]);
            return;
        }
        currentProjectile = new Picture(Room.PADDING, Room.PADDING, projectiles[0]);
    }

    private void addPictures() {
        projectiles[0] = "JerryGame/resources/blue_laser_side.png";
        projectiles[1] = "JerryGame/resources/green_laser_side.png";
        projectiles[2] = "JerryGame/resources/enemy_laser_side.png";
    }

    public void travel() {
        hit = false;
        show();
        currentProjectile.translate(10, 0);
        if (currentProjectile.getX() + currentProjectile.getWidth() >= room.getCols()) {
            hide();
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

    public boolean getHit() {
        return hit;
    }
}
