package com.starry.game.Chracter.Movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.starry.game.Chracter.Base.CharacterBase;
import com.starry.game.Chracter.CharacterSprite;
import com.starry.game.SpriteManager.InputManager;

public class CharacterMovement
{
    public Vector2 position = new Vector2(0,300);
    float moveSpeed = 250.0f;

    public boolean inputLeft = false;
    public boolean inputRight = false;
    private CharacterSprite characterSprite;
    private CharacterBase.CharacterState characterState;
    private boolean isDirectionRight = true;


    public void Init(CharacterSprite characterSprite, CharacterBase.CharacterState characterState)
    {
        this.characterSprite = characterSprite;
        this.characterState = characterState;
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
        if(InputManager.getInstance().isKeyPressed[Input.Keys.LEFT] || InputManager.getInstance().isTouching[Input.Keys.LEFT])
        {
            isDirectionRight = false;
        }
        else if(InputManager.getInstance().isKeyPressed[Input.Keys.RIGHT]|| InputManager.getInstance().isTouching[Input.Keys.RIGHT])
        {
            isDirectionRight = true;
        }

        if(isDirectionRight)
        {
            MoveRight();
        }
        else
        {
            MoveLeft();
        }

        if(position.x > Gdx.graphics.getWidth()-characterSprite.spriteCharacter.getWidth() ||
                position.x <= 0)
        {
            isDirectionRight = !isDirectionRight;
        }
       // Gdx.app.log("gdx","LEFT is " +InputManager.getInstance().isKeyPressed[Input.Keys.LEFT]);

    }

    public Vector2 GetPosition()
    {
        return new Vector2(position.x + characterSprite.spriteCharacter.getWidth()/2,position.y + characterSprite.spriteCharacter.getHeight()/2);
    }
}
