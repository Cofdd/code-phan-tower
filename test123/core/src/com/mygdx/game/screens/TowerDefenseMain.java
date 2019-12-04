package com.mygdx.game.screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.MainMenuScreen;

public class TowerDefenseMain extends Game {
	public SpriteBatch batch;
	public static final int WIDTH=1600;
	public static final int HEIGHT=900;





	@Override
	public void create () {
		 batch = new SpriteBatch();
		 this.setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}


}
