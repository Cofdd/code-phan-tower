package com.mygdx.game.tower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class NormalTower extends Tower {
    public NormalTower(){
        super(10,10,10,"Normaltower");
        tower=new Sprite(new Texture(Gdx.files.internal("tower1.png")));
    }
}
