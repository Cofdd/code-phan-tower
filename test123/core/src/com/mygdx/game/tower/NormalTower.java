package com.mygdx.game.tower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.level.SpawnEnemy;
import com.mygdx.game.minion.Enemy;

import java.util.ArrayList;
import java.util.logging.Level;

public class NormalTower extends Tower {

    public NormalTower(){
        super(SpawnEnemy.enemyList,10,3,10,"normalTower");
        tower=new Sprite(new Texture(Gdx.files.internal("tower1.png")));
    }
}
