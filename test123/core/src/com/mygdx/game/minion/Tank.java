package com.mygdx.game.minion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Tank extends Enemy{
    public Tank() {

        enemy = new Sprite(new Texture(Gdx.files.internal("Critter.png")));
        // Default
        HP = 100;
        speed = 4;
        armor = 20;
    }

}
