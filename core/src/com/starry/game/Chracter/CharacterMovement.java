package com.starry.game.Chracter;

import com.badlogic.gdx.math.Vector2;

public class CharacterMovement
{
    Vector2 position = new Vector2(0,0);
    float moveSpeed = 1.0f;


    protected void Init()
    {

    }

    public void MoveLeft()
    {
        this.position.x -= moveSpeed;
    }

    public void MoveRight()
    {
        this.position.x += moveSpeed;
    }
}
