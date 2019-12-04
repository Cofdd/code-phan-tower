package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;


public class MainMenuScreen implements Screen {
    TowerDefenseMain game;
    Texture MainMenu;
    private Texture playButtonInactive;
    private Texture exitButtonActive;
    private Texture exitButtonInactive;

    public MainMenuScreen (GameRenderer game){

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(MainMenu,0,0,1600,900);
        if (Gdx.input.getX()>=650&&Gdx.input.getX()<=960&&Gdx.input.getY()<=900&&Gdx.input.getY()>=500) {
//            if(Gdx.input.isTouched()) game.setScreen(new GameScreen(game));
        }
        game.batch.end();
        if (Gdx.input.getX()>=300&&Gdx.input.getX()<=470&&Gdx.input.getY()<=750&&Gdx.input.getY()>=640){
            if(Gdx.input.isTouched()) Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
