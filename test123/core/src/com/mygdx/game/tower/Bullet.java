package com.mygdx.game.tower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entity;
import com.mygdx.game.minion.Enemy;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.util.ArrayList;

public class Bullet extends Entity  {

    private Sprite bullet;
    private int damage;
    protected float speed; //,angle;
    private double distance;
//    private ArrayList<Bullet> bullets;

//    private double distance;

    private Enemy target;


    public Bullet(String type,double x, double y,Enemy target ){
        this.x=x;
        this.y=y;
        this.target=target;
        bullet=new Sprite(new Texture(Gdx.files.internal("Bullet1.png")));
        speed = 10;
        damage = 10;

//        setBullettype(type);

        setActive(true);
    }



    public void move() {
//        Vector2 enemyPos = target.getPosition();
////        if(enemyPos.x > x){
////            position.x+=speed;
////        }else if (enemyPos.x < x){
////            position.x-=speed;
////        }
////        if(enemyPos.y > y){
////            position.y+=speed;
////        }else if (enemyPos.y < y){
////            position.y-=speed;
////        }//        distance = (float) Math.sqrt(Math.pow(enemyPos.x,x)) + (float) Math.sqrt(Math.pow(enemyPos.y,y));
        double xPos = target.getX() + 30 - x ;
        double yPos = target.getY() + 30 - x ;
        distance = Math.sqrt(Math.pow(xPos,2) + Math.pow(yPos,2));

        double speedX = xPos/distance*speed;
        double speedY = yPos/distance*speed;

        if(Math.abs(xPos) >= Math.abs(speedX) && Math.abs(yPos) >= Math.abs(speedY)){
            x+=speedX;
            y+=speedY;
        }

        else {
            x = target.getX()+30;
            y = target.getY()+30;
        }
    }

//    public void setBullettype(String type){
//        if(type == "normalTower"){
//
//        }
//    }

//    public float getAngle() {
//        Vector2 targetPosition= target.getPosition();
//        float deltaX=(float)(this.position.x - targetPosition.x);
//        float deltaY=(float)(this.position.y - targetPosition.y);
//        float angleInDegrees = (float) (Math.atan2(deltaY, deltaX) * 180 / Math.PI);
//        return angleInDegrees;
//    }


    @Override
    public void draw(SpriteBatch batch, float delta) {
        if(isActive()){
            bullet.draw(batch);
            update(delta);
        }

    }

    @Override
    public void SpawnPos() {

    }


    @Override
    public void update(float delta) {
        bullet.setX((float) x);
        bullet.setY((float) y);

        move();

        if(distance==0){
            setActive(false);
            target.setHP(target.getHP()-damage);
        }

    }

}
