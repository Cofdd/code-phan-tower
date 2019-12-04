package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.level.level;
import com.mygdx.game.minion.Enemy;
import com.mygdx.game.tower.Bullet;

import java.util.ArrayList;
import java.util.logging.Level;




public class GameScreen  implements Screen {
    private GameMap map;
    final TowerDefenseMain theGame;
//    public ArrayList<Bullet> bullets;


    private level nguyenNgu;

//    public int pixelRatio =16;
    //   OrthographicCamera camera;
//    private Enemy enemies;


    @Override
    public void show() {
    }

    public GameScreen (TowerDefenseMain theGame){
        this.theGame = theGame;
        map=new GameMap(theGame.batch);
        nguyenNgu = new level();
//        bullets = new ArrayList<Bullet>();
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        theGame.batch.begin();
        map.draw();
        nguyenNgu.draw(theGame.batch,delta);


        theGame.batch.end();
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
        nguyenNgu.dispose();
        map.dispose();
    }
}
