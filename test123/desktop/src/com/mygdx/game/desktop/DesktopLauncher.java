package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.screens.TowerDefenseMain;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new TowerDefenseMain(), config);
		config.foregroundFPS=60;
		config.height= TowerDefenseMain.HEIGHT;//900
		config.width = TowerDefenseMain.WIDTH;//1600
		config.resizable=false;
	}
}
