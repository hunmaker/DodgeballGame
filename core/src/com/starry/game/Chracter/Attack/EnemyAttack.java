package com.starry.game.Chracter.Attack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.starry.game.Ball.BallManager;
import com.starry.game.Chracter.Movement.CharacterMovement;

import java.util.Random;

public class EnemyAttack extends CharacterAttack
{
    private  float fAttackTimer;
    private  float fAttackTime;
    private   int nAttackTimeRand = 1000; //1000 = 1초

    private  Random rand = new Random();

    @Override
    protected void InitMember()
    {
        fAttackTimer = 0;
        RerollAttackTime();
        fBallTime = 1.0f;
        nAttackTimeRand = 1500;
    }

    private void RerollAttackTime()
    {
        fAttackTime = rand.nextInt(1000) * 0.001f;
    }
    @Override
    protected void ProcessUpdate()
    {
        if(CanAutoAttack())
        {
            fAttackTimer -= fAttackTime;
            RerollAttackTime();
            BallManager.getInstance().Shoot(characterMovement.GetPosition(), new Vector2(rand.nextInt((int)Gdx.graphics.getWidth()),100), characterMovement.GetPosition(), characterState.faction, GetNextAttack());
        }
        if(fAttackTimer < fAttackTime)
            fAttackTimer += Gdx.graphics.getDeltaTime();
    }

    @Override
    protected void SetupAttackProcessor(InputMultiplexer multiplexer)
    {

    }

    private  boolean CanAutoAttack()
    {
        return fAttackTimer >= fAttackTime && CanAttack();
    }
}
