package com.mygdx.game.tower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entity;
import com.mygdx.game.minion.Enemy;
import com.mygdx.game.screens.GameMap;

import java.util.ArrayList;

public class Tower extends Entity {

    protected int damage;
    protected int cost;
    protected Sprite tower=null;
//    public Bullet bullet;
    protected float attacktimer;
    protected float cooldown;
    protected String name,type;

    private ArrayList<Enemy> enemies;
    private ArrayList<Bullet> bullets;
    private ArrayList<Enemy> targets ;



    private final int range = 500;

    public Tower (ArrayList<Enemy> enemies ,int damage, int cooldown ,int cost ,String name){
        this.damage=damage;
        this.cooldown=cooldown;
        this.cost=cost;
        this.name=name;
        this.enemies = enemies ;
        attacktimer = 2 ;
        tower=new Sprite(new Texture(Gdx.files.internal("tower1.png")));
        targets=new ArrayList<>();
        bullets = new ArrayList<>();
        SpawnPos();


    }

    public double distance(Enemy target) {

        double a = Math.abs(target.getX() - x);
        double b = Math.abs(target.getY() - y);
        double c = Math.pow(a, 2) + Math.pow(b, 2);
        return Math.sqrt(c);
    }

    public void lockEnemy(ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {

            if (distance(enemy) <= range) {

                if (targets.isEmpty()) {
                    targets.add(enemy);
                }
                System.out.println(targets);
            }
        }
    }


    public void unlockEnemy(ArrayList<Enemy> targets){
        for(int i = 0; i < targets.size(); i++) {
            if(((distance(targets.get(i)) > range && (!targets.get(i).isActive() || targets.get(i).isActive()))
                    || (distance(targets.get(i)) <= range && !targets.get(i).isActive())) && !targets.isEmpty()) {

                targets.remove(i);
            }
        }
    }

    public void shoot(Enemy target, float delta) {

        for (int i = 0; i< bullets.size(); i++) {

            // Remove bullet from Bullets Array
            if(!bullets.get(i).isActive())
                bullets.remove(i);
        }

        // Always Add an Bullet to the Bullets Array if It's Empty
        attacktimer -= delta;
        if(attacktimer <= 0) {
            bullets.add(new Bullet(type,tower.getX() + tower.getWidth()/2, tower.getY() + tower.getHeight()/2, target));
            attacktimer = cooldown;
        }
    }





    public void drawBullet(SpriteBatch batch, float delta) {
        for (Bullet bullet : bullets) bullet.draw(batch, delta);
    }

    @Override
    public void draw(SpriteBatch batch, float delta) {

        for(Bullet bullet : bullets){bullet.draw(batch,delta);}

        tower.setX((float) x);
        tower.setY((float) y);

        drawBullet(batch, delta);

        tower.draw(batch);

    }

    @Override
    public void SpawnPos() {
        for(int Y = 0; Y< GameMap.Map.length; Y++){
            for(int X=0;X<GameMap.Map[Y].length;X++) {            //
                if (GameMap.Map[Y][X] == 5) {
                    y += Y * 60;
                    x += X * 60;

                    break;
                }
            }
        }
    }

    @Override
    public void update(float delta) {
        if(isActive()){
            lockEnemy(enemies);
            unlockEnemy(targets);
            for (Enemy target : targets){
                shoot(target,delta);
            }

        }
    }

}
