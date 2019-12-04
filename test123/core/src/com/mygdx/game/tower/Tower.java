package com.mygdx.game.tower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entity;
import com.mygdx.game.minion.Enemy;
import com.mygdx.game.screens.GameMap;
import com.mygdx.game.screens.GameScreen;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower extends Entity {

    protected int shotSpeed;
    protected int damage;
    protected int cost;
    protected Sprite tower=null;
    public Bullet bullet;
    protected float attacktimer;
    protected float cooldown;
    protected String name;


    private ArrayList<Enemy> targets = null ;


    private final int range = 200;

    public Tower (int damage, int shotSpeed,int cost,String name){
        this.damage=damage;
        this.shotSpeed=shotSpeed;
        this.cost=cost;
        this.name=name;
        attacktimer = 0 ;
        tower=new Sprite(new Texture(Gdx.files.internal("tower1.png")));
        targets=new ArrayList<Enemy>();
        setCooldown(shotSpeed);

    }

    public int getCost() { return cost; }

    public void setCost(int cost) { this.cost = cost; }

    public int getDamage() { return damage; }

    public int getShotSpeed() { return shotSpeed; }

    public float getAttacktimer() { return attacktimer; }

    public String getName(){return name;}

    protected void setCooldown(float attackRate){
        cooldown = 1f / shotSpeed;
    }

//    public Bullet getBullet() {
//        return bullet;
//    }



    private void acquireTarget(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (!targets.contains(enemy)) {
                if (checkEnemy(enemy)) {
                    targets.add(enemy);
                }
            }
        }
    }

    private void updateTargets() {

        for (int i = targets.size() - 1; i >= 0; i--) {
            if (!checkEnemy(targets.get(i)) || !targets.get(i).isActive()) {
                targets.remove(i);
            }
        }
    }

    private void shoot(float delta) {
        attacktimer += delta;
        if(targets.size() > 0){
            if(attacktimer >= cooldown){
                attacktimer = 0;
                Bullet shootBullet = Bullet.createBullet (this, targets.get(0));
                Bullet.add(shootBullet);
            }
        }
    }

    public boolean checkEnemy(Enemy enemy){
        float distanceX = (float) Math.abs(Tower.super.getX() - enemy.getPosition().x);
        float distanceY = (float) Math.abs(Tower.super.getY() - enemy.getPosition().y);

        if(distanceX > GameMap.destination / 2 +range){
            return false;
        }
        if(distanceY > GameMap.destination / 2 +range){
            return false;
        }
        if(distanceX <= GameMap.destination / 2 +range){
            return false;
        }
        if(distanceY <= GameMap.destination / 2 +range){
            return false;
        }
        float cornerDistance = (distanceX-GameMap.destination/2)*(distanceX -GameMap.destination / 2 )+(distanceY-GameMap.destination/2)*(distanceY -GameMap.destination / 2 );
        return (cornerDistance <= range*range);
    }

    @Override
    public void draw(SpriteBatch batch, float delta) {
        tower.draw(batch);
        tower.setPosition((float)x,(float)y);


    }

    @Override
    public void SpawnPos() {

    }

    public void update(float delta) {
        List<Enemy> enemies =
        acquireTarget(enemies);
        updateTargets();
        shoot(delta);
    }


}
