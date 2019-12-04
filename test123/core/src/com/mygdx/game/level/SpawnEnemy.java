package com.mygdx.game.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.minion.Critter;
import com.mygdx.game.minion.Enemy;
import com.mygdx.game.Entity;
import com.mygdx.game.minion.Tank;
import com.mygdx.game.screens.GameScreen;

import java.util.ArrayList;
import java.util.Stack;


public class SpawnEnemy extends Entity implements Disposable {
    float cooldown=1;
    public  ArrayList<Enemy> enemyList = new ArrayList<>();

    Stack<Enemy> enemies =new Stack();

    public SpawnEnemy() {

        try{

            for (int i=0;i<=4;i++) enemies.push(new Critter());
            for (int i=0;i<=4;i++) enemies.push(new Tank());



        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void draw(SpriteBatch spriteBatch, float delta) {
        // sinh way linh
        cooldown-=delta;
        if(cooldown<=0) {
            if (!enemies.isEmpty()) {
                enemyList.add(enemies.pop());
            }
            cooldown =  0.5f;

       }
        for (Enemy enemy : enemyList) enemy.draw(spriteBatch, delta);


    }
    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }


    @Override
    public void SpawnPos() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void dispose() {
        for(Enemy enemy : enemyList) enemy.dispose();
    }
}
