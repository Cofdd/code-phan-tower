package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.level.SpawnEnemy;
import com.mygdx.game.minion.Enemy;
import com.mygdx.game.tower.Bullet;
import com.mygdx.game.tower.Tower;


public class GameScreen  implements Screen {
    private GameMap map;
    final TowerDefenseMain theGame;
//    public ArrayList<Bullet> bullets;


    private SpawnEnemy levels;

    private Tower Tower;
//    public int pixelRatio =16;
    //   OrthographicCamera camera;



    @Override
    public void show() {
    }

    public GameScreen (TowerDefenseMain theGame){
        this.theGame = theGame;
        map=new GameMap(theGame.batch);
        levels = new SpawnEnemy();
        Tower = new Tower(SpawnEnemy.enemyList,10,3,10,"normalTower");


//        bullets = new ArrayList<Bullet>();
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        theGame.batch.begin();
        map.draw();
        levels.draw(theGame.batch,delta);
        Tower.draw(theGame.batch,delta);



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
        levels.dispose();
        map.dispose();
    }
}
