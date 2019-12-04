package com.mygdx.game.levelTest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class LevelHolder {
    private static Array<Level> Levels;

    public static Level GetLevel(int index){
        CreateLevels();
        return Levels.get(index);
    }

    private static void CreateLevels() {
        Levels=new Array<Level>();
        Array<Vector2> waypoints = new Array<Vector2>();
        Texture levelTexture = new Texture((Gdx.files.internal("towerDefense_tile111.png")));
        waypoints.add(new Vector2(1,4));
        waypoints.add(new Vector2(25,4));
        waypoints.add(new Vector2(25,1));
        waypoints.add(new Vector2(1,1));

        Level levelToAdd = new Level(levelTexture,waypoints,null);
        Levels.add(levelToAdd);
    }
}
