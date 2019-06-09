package com.starry.game.Chracter.Movement;

import com.badlogic.gdx.Gdx;

import java.util.Random;

public class EnemyMovement extends CharacterMovement
{
    int rand = -1;
    int seed = 41;
    @Override
    public void Update()
    {
        /*
        //Do Nothing
        Random random = new Random();
        if(rand < 0)
            rand = random.nextInt(seed);
        if(rand <=20)
        {
            MoveLeft();
        }
        else
        {
            MoveRight();
        }
        rand--;
        if(position.x < 300)
            seed = 81;
        else if(position.x > Gdx.graphics.getWidth()-300)
            seed = 41;
            */
    }
}
