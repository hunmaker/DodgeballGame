package com.starry.game.Chracter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.starry.game.SpriteManager.InputManager;

public class CharacterMovement
{
    Vector2 position = new Vector2(0,0);
    float moveSpeed = 250.0f;

    public boolean inputLeft = false;
    public boolean inputRight = false;


    protected void Init()
    {

    }

    public void MoveLeft()
    {
        this.position.x -= moveSpeed * Gdx.graphics.getDeltaTime();
    }

    public void MoveRight()
    {
        this.position.x += moveSpeed * Gdx.graphics.getDeltaTime();
    }

    public void Update()
    {
        Gdx.app.log("gdx","LEFT is " +InputManager.getInstance().isKeyPressed[Input.Keys.LEFT]);
        if(InputManager.getInstance().isKeyPressed[Input.Keys.LEFT] || InputManager.getInstance().isTouching[Input.Keys.LEFT])
        {
            MoveLeft();
        }
        else if(InputManager.getInstance().isKeyPressed[Input.Keys.RIGHT]|| InputManager.getInstance().isTouching[Input.Keys.RIGHT])
        {
            MoveRight();
        }
    }
}
