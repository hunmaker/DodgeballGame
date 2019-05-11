package com.starry.game.Scene;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.starry.game.Ball.Ball;
import com.starry.game.Ball.BallManager;
import com.starry.game.Chracter.PlayerCharacter;
import com.starry.game.SpriteManager.InputManager;
import com.starry.game.UI.TouchPadButton;

public class MainStageScene extends ApplicationAdapter {
	private Stage stage;
	SpriteBatch batch;
	PlayerCharacter playerCharacter;
	Texture textureButtonLeft;
	TouchPadButton btnLeft;
	TouchPadButton btnRight;
	Sprite backGround;
	InputMultiplexer multiplexer = new InputMultiplexer();

	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		batch = new SpriteBatch();
		InitUI();
		InitPlayers();
		InitObjects();
		//TODO : 한번만 실행되어야 한다. 추후 보강.
		multiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(multiplexer);

		stage.addListener(InputManager.getInstance());
	}
	Ball testBall;

	private void InitObjects()
	{
		testBall = new Ball();
		testBall.Init(new Vector2(250,250),30);
	}

	private void InitPlayers()
	{
		playerCharacter = new PlayerCharacter();
		playerCharacter.Init(multiplexer);
	}

	private void InitUI()
	{
		backGround = new Sprite(new Texture("background.jpg"));
		backGround.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		textureButtonLeft =  new Texture("LeftButton.png");
		Drawable drawable = new TextureRegionDrawable(new TextureRegion(textureButtonLeft));
		btnLeft = new TouchPadButton(drawable);
		btnLeft.setTransform(true);
		btnLeft.setPosition(0,0);
		stage.addActor(btnLeft);

        btnRight = new TouchPadButton(drawable);
		btnRight.setTransform(true);
		btnRight.setOrigin(btnRight.getWidth()/2,btnRight.getHeight()/2);
        btnRight.setRotation(180);
        btnRight.setPosition(Gdx.graphics.getWidth()-btnRight.getWidth(),0);
		Gdx.app.log("gdx", "screen width :" + Gdx.graphics.getWidth());
		Gdx.app.log("gdx", "btn width :" + btnRight.getWidth());
		stage.addActor(btnRight);
	}

	private void UpdateInputs()
	{
		//Gdx.app.log("gdx","btnLeft.isTouching " + btnLeft.isTouching);
		if(btnLeft.isTouching)
		{
			InputManager.getInstance().isTouching[Input.Keys.LEFT] = true;
		}

		//Gdx.app.log("gdx","btnLeft.isTouching " + btnLeft.isTouching);
		//Gdx.app.log("gdx","btnRight.isTouching " + btnRight.isTouching);
		if(btnRight.isTouching)
		{
			InputManager.getInstance().isTouching[Input.Keys.RIGHT] = true;
		}
	}


	private void ClearInputs()
	{
		InputManager.getInstance().Clear();
	}
	private void UpdateLoop()
	{
		UpdateInputs();
		Update();
		ClearInputs();
	}
	private void Update()
	{
		playerCharacter.characterMovement.Update();
		testBall.Update();
		BallManager.getInstance().Update();
	}

	//LibGDX RenderZone based by openGL
	@Override
	public void render () {
		UpdateLoop();
		Gdx.gl.glClearColor(0.7f, 0.7f, 0.7f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//Start to draw

		backGround.draw(batch);
		//SpriteManager.getInstance().renderBatchs(): //보류
		playerCharacter.characterSprite.Render(batch);
		btnLeft.draw(batch,1.0f);
		btnRight.draw(batch,1.0f);
		testBall.Render(batch);
		BallManager.getInstance().Render(batch);
		//End to draw
		batch.end();
		stage.act();
		stage.draw();
	}

	//dispose : 메모리 해제
	@Override
	public void dispose () {
		batch.dispose();
		playerCharacter.Dispose();
	}
}
