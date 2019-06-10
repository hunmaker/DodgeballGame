package com.starry.game.Chracter.Attack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.starry.game.Ball.BallManager;
import com.starry.game.Chracter.Base.CharacterBase;
import com.starry.game.Chracter.Movement.CharacterMovement;

import java.util.ArrayList;
import java.util.Random;

public class CharacterAttack
{
    AttackDetector attackDetector = new AttackDetector();
    CharacterMovement characterMovement;
    private CharacterBase.CharacterState characterState;
    Vector2 panStartAt = new Vector2();
    Vector2 panEndAt = new Vector2();
    public boolean isPanning = false;
    public ArrayList<NextAttack> nextAttackList = new ArrayList();
    public Random r = new Random();
    float fBallTime = 1.0f;
    float fBallTimer = 0.0f;
    public int maxAttack = 5;
    public void Init(InputMultiplexer multiplexer, CharacterMovement characterMovement, CharacterBase.CharacterState characterState)
    {
        this.characterMovement = characterMovement;
        this.characterState = characterState;
        SetupAttackProcessor(multiplexer);
    }

    public void Update()
    {
        if(CanCreateNextAttack())
        {
            fBallTimer -= fBallTime;
            CreateNextAttack();
        }

        //아직 꽊차지 않았다면 타이머 갱신
        if(nextAttackList.size() < maxAttack)
        {
            fBallTimer += Gdx.graphics.getDeltaTime();
        }
    }

    protected  boolean CanCreateNextAttack()
    {
        return  fBallTimer >= fBallTime && nextAttackList.size() < maxAttack;
    }

    public void CreateNextAttack()
    {
        nextAttackList.add(new NextAttack(r.nextInt(3)));
        Gdx.app.log("gdx",String.format("CreateNextAttack : Count : %d", nextAttackList.size()));
    }

    public NextAttack GetNextAttack()
    {
       return nextAttackList.remove(0);
    }

    public boolean CanAttack()
    {
        return !nextAttackList.isEmpty();
    }

    protected void SetupAttackProcessor(InputMultiplexer multiplexer)
    {
        multiplexer.addProcessor(new GestureDetector(attackDetector));
    }

    public class AttackDetector implements GestureDetector.GestureListener
    {
        @Override
        public boolean touchDown(float x, float y, int pointer, int button) {

            return false;
        }

        @Override
        public boolean tap(float x, float y, int count, int button) {

            //Gdx.app.log("gdx",String.format("tap Detected %f %f %d %d",x,Gdx.graphics.getHeight()-y,count,button));
            //Gdx.app.log("gdx",String.format("characterMovement Detected %f %f",characterMovement.position.x,characterMovement.position.y));
            //Gdx.app.log("gdx",String.format("Gdx.graphics.getHeight() %d",Gdx.graphics.getHeight()));
            //BallManager.getInstance().Shoot(characterMovement.GetPosition(),new Vector2(x,Gdx.graphics.getHeight()-y),characterMovement.GetPosition());
            return false;
        }

        @Override
        public boolean longPress(float x, float y) {

            return false;
        }

        @Override
        public boolean fling(float velocityX, float velocityY, int button) {

            return false;
        }

        @Override
        public boolean pan(float x, float y, float deltaX, float deltaY) {
            Gdx.app.log("gdx",String.format("Pan Detected %f %f %f %f",x,y,deltaX,deltaY));
            if(y > 1500)
                return false;
            if(!isPanning)
            {
                isPanning = true;
                panStartAt = new Vector2(x,Gdx.graphics.getHeight()-y);
            }
            return false;
        }

        @Override
        public boolean panStop(float x, float y, int pointer, int button) {
            Gdx.app.log("gdx",String.format("PanStop Detected %f %f %d %d",x,y,pointer,button));
            if(y > 1500)
                return false;
            if(isPanning)
            {
                isPanning = false;
                panEndAt = new Vector2(x,Gdx.graphics.getHeight()-y);
                if(CanAttack())
                {
                    BallManager.getInstance().Shoot(panStartAt, panEndAt, characterMovement.GetPosition(), characterState.faction, GetNextAttack());
                }
            }
            return false;
        }

        @Override
        public boolean zoom (float originalDistance, float currentDistance){

            return false;
        }

        @Override
        public boolean pinch (Vector2 initialFirstPointer, Vector2 initialSecondPointer, Vector2 firstPointer, Vector2 secondPointer){

            return false;
        }
        @Override
        public void pinchStop () {
        }
    }
}
