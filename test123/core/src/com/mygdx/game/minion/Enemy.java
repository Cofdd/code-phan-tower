package com.mygdx.game.minion;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entity;
import com.mygdx.game.screens.GameMap;

public  class Enemy extends Entity {

   protected double speed;
   protected float armor;
   protected Sprite enemy = null;
   protected float HP;

   private int road,m,n=0;
   private int count =GameMap.Map.length*GameMap.Map[m].length;// tạo ra số lượng phần tử trong mảng lịch sư
   private int [][] Check;

    public Enemy(){

        enemy = new Sprite(new Texture(Gdx.files.internal("Critter.png")));
        Check = new int[GameMap.Map.length][count];
        Check[m][0]=-1;
        SpawnPos();
    }



    private void findRoad() {
//        //right,
        if (GameMap.Map[m][n+1]==1 && Check[m][n+1]!=-1) {
            if (x != GameMap.destination * (n + 1)) x += speed;
            if (x == GameMap.destination * (n + 1)) {
                Check[m][n+ 1] = -1;
                n++;
            }
        }
        //left
//        if (GameMap.Map[m][n-1]==1 && Check[m][n-1] != -1) {
//            if (x != GameMap.destination * (n - 1)) x -= speed;
//            if (x == GameMap.destination * (n - 1)) {
//                Check[m][n - 1] = -1;
//                n--;
//            }
//        }

//        //up
        if (GameMap.Map[m+1][n]==1&&Check[m+1][n]!= -1) {
            if (y!= GameMap.destination * (m + 1)) y += speed;
            if (y == GameMap.destination * (m + 1)) {
                Check[m + 1][n] = -1;
                m++;
            }
        }
        //down
        if (GameMap.Map[m-1][n]==1&&Check[m-1][n]!=-1){
            if (y != GameMap.destination * (m - 1)) y -= speed;
            if (y == GameMap.destination * (m - 1)) {
                Check[m -1][n] = -1;
                m--;
            }
        }
    }

    @Override
    public void draw(SpriteBatch batch , float delta) {
        enemy.draw(batch);
        enemy.setPosition((float) x,(float) y);
        findRoad();
    }



    @Override
    public void SpawnPos() {
        for(int Y = 0; Y< GameMap.Map.length; Y++){
            for(int X=0;X<GameMap.Map[Y].length;X++) {            //
                if (GameMap.Map[Y][X] == 2) {
                    y += Y * (enemy.getHeight());
                    x += 0 * enemy.getWidth();
                    m=Y;
                    break;
                }
            }
        }
    }




    public void dispose(){
        enemy.getTexture().dispose();
    }

    public float getHP() {
        return HP;
    }

    public void setHP(float HP) {
        this.HP = HP;
    }
}
