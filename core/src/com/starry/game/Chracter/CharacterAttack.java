package com.starry.game.Chracter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class CharacterAttack
{
    AttackDetector attackDetector = new AttackDetector();
    Vector2 panStartAt = new Vector2();
    Vector2 panEndAt = new Vector2();
    public void Init(InputMultiplexer multiplexer)
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

            Gdx.app.log("gdx",String.format("tap Detected %f %f %d %d",x,y,count,button));
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
            return false;
        }

        @Override
        public boolean panStop(float x, float y, int pointer, int button) {

            Gdx.app.log("gdx",String.format("PanStop Detected %f %f %d %d",x,y,pointer,button));
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
