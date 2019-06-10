package com.starry.game.Chracter.Movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Timer;
import com.starry.game.SpriteManager.InputManager;

import java.util.Random;

public class EnemyMovement extends CharacterMovement
{
    private  float fTimer = 0;
    private  float fTime = 1.0f;
    private  Random rand = new Random();
    @Override
    public void Update()
    {
        Move();

        if(position.x > Gdx.graphics.getWidth()-characterSprite.spriteCharacter.getWidth()-wallWidth ||
                position.x <= wallWidth)
        {
            isDirectionRight = !isDirectionRight;
            Move();
        }

        if(fTimer >= fTime)
        {
            fTimer -= fTime;
            RerollTime();
            isDirectionRight = !isDirectionRight;
            Move();
        }
        fTimer += Gdx.graphics.getDeltaTime();
    }

    private  void RerollTime()
    {
        fTime = rand.nextInt(1000) * 0.001f;
        fTime += 1.0f;
    }
}
