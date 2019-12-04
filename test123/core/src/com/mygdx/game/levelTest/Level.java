package com.mygdx.game.levelTest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Level {
    public Texture LevelTexture;
    public Array<Vector2> Waypoints1,Waypoints2;

    public Level (Texture levelTexture,Array<Vector2> waypoints1, Array<Vector2>waypoints2){
        Waypoints1= waypoints1;

        if (waypoints2!=null){
            Waypoints2=waypoints2;
            LevelTexture=levelTexture;
        }
    }
}
