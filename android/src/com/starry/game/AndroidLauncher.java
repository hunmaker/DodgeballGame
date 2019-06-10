package com.starry.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.starry.game.Scene.MainStageScene;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MainStageScene(), config);
		MusicManager.getInstance().service = new GdxService();
	}

	 class GdxService implements  PlatformService
	 {
		 @Override
		 public void backToMenu()
		 {
			 finish();
		 }
	 }
}
