package com.mygdx.game.tower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entity;
import com.mygdx.game.minion.Enemy;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

public class Bullet extends Entity  {

    private Sprite bullet;
    private int damage;
    protected float speed, angle;
    private float distance;
//    private double distance;

    protected Enemy target;


    public Bullet(String type , int damage , Vector2 position ,float speed,Enemy target, double x , double y){
        this.damage=damage;
        this.position=position;
        this.speed=speed;
        this.target=target;
        this.angle=getAngle();
        this.x=x;
        this.y=y;

        setBulletType(type);

        setActive(true);
    }

    public void setBulletType(String type) {

        if(type == "normal") {
            bullet = new Sprite(new Texture(Gdx.files.internal("bullet1.png")));

            damage = 3;

        }
        if(type == "smg") {
            bullet = new Sprite(new Texture(Gdx.files.internal("bullet2.png")));

            damage = 3;

        }
        if(type == "rifle") {
            bullet = new Sprite(new Texture(Gdx.files.internal("bullet3.png")));

            damage = 10;

        }
        if(type == "mortar") {
            bullet = new Sprite(new Texture(Gdx.files.internal("bullet4.png")));

            damage = 50;

        }
    }

    public void move() {
        Vector2 enemyPos = target.getPosition();
        if(enemyPos.x > x){
            position.x+=speed;
        }else if (enemyPos.x < x){
            position.x-=speed;
        }
        if(enemyPos.y > y){
            position.y+=speed;
        }else if (enemyPos.y < y){
            position.y-=speed;
        }
        distance = (float) Math.sqrt(Math.pow(enemyPos.x,x)) + (float) Math.sqrt(Math.pow(enemyPos.y,y));


    }

    public float getAngle() {
        Vector2 targetPosition= target.getPosition();
        float deltaX=(float)(this.position.x - targetPosition.x);
        float deltaY=(float)(this.position.y - targetPosition.y);
        float angleInDegrees = (float) (Math.atan2(deltaY, deltaX) * 180 / Math.PI);
        return angleInDegrees;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void draw(SpriteBatch batch, float delta) {
        if(isActive()){
            bullet.draw(batch);
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
