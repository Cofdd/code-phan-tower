package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameRenderer extends Game {
    SpriteBatch batch;
    public BitmapFont font;
    @Override
    public void create() {
        batch=new SpriteBatch();
        font =new BitmapFont();
        this.setScreen(new MainMenuScreen(this));
    }
    public void render(){
        super.render();
    }

}
