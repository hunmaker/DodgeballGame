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
    float moveSpeed = 500.0f;

    public boolean inputLeft = false;
    public boolean inputRight = false;
    protected CharacterSprite characterSprite;
    protected CharacterBase.CharacterState characterState;
    protected boolean isDirectionRight = true;
    int skipCount = 0;


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

    protected static final float wallWidth = 80.0f;
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

        Move();

        if(position.x > Gdx.graphics.getWidth()-characterSprite.spriteCharacter.getWidth()-wallWidth ||
                position.x <= wallWidth)
        {
            isDirectionRight = !isDirectionRight;
            Move();
        }
       // Gdx.app.log("gdx","LEFT is " +InputManager.getInstance().isKeyPressed[Input.Keys.LEFT]);

    }
    protected void Move()
    {
        if(isDirectionRight)
        {
            MoveRight();
        }
        else
        {
            MoveLeft();
        }
    }

    public Vector2 GetPosition()
    {
        return new Vector2(position.x + characterSprite.spriteCharacter.getWidth()/2,position.y + characterSprite.spriteCharacter.getHeight()/2);
    }
}
