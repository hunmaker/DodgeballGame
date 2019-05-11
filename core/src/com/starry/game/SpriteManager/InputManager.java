package com.starry.game.SpriteManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class InputManager extends InputListener
{
    private static InputManager instance;
    public static synchronized InputManager getInstance(){
        if(instance == null){
            instance = new InputManager();
        }
        return instance;
    }
    public boolean[] isKeyPressed = new boolean[256];
    public boolean[] isTouching = new boolean[256];

    public void Clear()
    {
        /*
        for (int i=0; i<isKeyPressed.length; i++)
        {
            isKeyPressed[i] = false;
        }
        */
        for (int i=0; i<isTouching.length; i++)
        {
            isTouching[i] = false;
        }
    }

    @Override
    public boolean keyDown (InputEvent event, int keycode) {
        //Gdx.app.log("keyDown", "keyDown Code :" + keycode);
        isKeyPressed[keycode] = true;
        return false;
    }

    @Override
    public boolean keyUp (InputEvent event, int keycode) {
        //Gdx.app.log("keyUp", "keyUp Code :" + keycode);
        isKeyPressed[keycode] = false;
        return false;
    }
}