package com.mygdx.game.tower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.level.SpawnEnemy;

public class sniperTower extends Tower {
    public sniperTower(){
        super(SpawnEnemy.enemyList,10,10,10,"SniperTower" );
        tower=new Sprite(new Texture(Gdx.files.internal("tower.png")));
    }
    @Override
    public void draw(SpriteBatch batch, float delta) {
        tower.draw(batch);
        tower.setPosition((float)300,(float)400);

    }
}