package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class  GameMap  {
    private int width=60;
    private int height=60;
    private SpriteBatch batch;
    private Texture dirt,grass,spawn,towerlocate;
    public static final int destination=60;

    public GameMap(SpriteBatch batch){
        this.batch=batch;
        dirt  =new Texture(Gdx.files.internal("dirt.png"));
        grass =new Texture(Gdx.files.internal("grass.png"));
        spawn =new Texture(Gdx.files.internal("spawn.png"));
        towerlocate=new Texture(Gdx.files.internal("towerDefense_tile111.png"));

        for(int y=0; y <Map.length/2;y++){
            for (int x=0;x<Map[y].length;x++){
                int a=Map[y][x];
                Map[y][x] = Map[Map.length-1-y][x];
                Map[Map.length-1-y][x]=a;
            }
        }
    }

    public static final int[][] Map={
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0},
            {2,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,5,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,3},
            {0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
//            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},

    };

    public void draw(){
        for (int y=0; y <Map.length;y++){
                for(int x=0;x<Map[y].length;x++){
                    if(Map[y][x]==0) batch.draw(grass,x*height,y*width,width,height);
                    if(Map[y][x]==1) batch.draw(dirt,x*height,y*width,width,height);
                    if(Map[y][x]==2) batch.draw(spawn,x*height,y*width,width,height);
                    if(Map[y][x]==5) batch.draw(towerlocate,x*height,y*width,width,height);
                }
            }

    }

    public void dispose(){
        grass.dispose();
        dirt.dispose();
        spawn.dispose();
    }

}
