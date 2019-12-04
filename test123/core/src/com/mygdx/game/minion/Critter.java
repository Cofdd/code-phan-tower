package com.mygdx.game.minion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Critter extends Enemy {

    public Critter() {

        enemy = new Sprite(new Texture(Gdx.files.internal("towerDefense_tile245.png")));
        // Default
        HP = 100;
        speed = 10;
        armor = 15;
    }
}
