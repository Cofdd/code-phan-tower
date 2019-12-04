package com.mygdx.game;




import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
    public Entity(){
    }
    protected double x,y;
    public abstract void draw(SpriteBatch spriteBatch,float delta);
    public abstract void SpawnPos();
    public abstract void update(float delta);

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }



    protected Vector2 position;

    protected boolean active=true;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }




    public Vector2 getPosition() {
        return position;
    }
}
