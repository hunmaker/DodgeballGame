package com.starry.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class TouchPadButton extends ImageButton
{
    public boolean isTouching = false;
    public TouchPadButton(Drawable imageUp)
    {
        super(imageUp);
        SetupListener();
    }

    public TouchPadButton(Drawable imageUp, Drawable imageDown) {
        super(imageUp,imageDown);
        SetupListener();
    }

    private void SetupListener()
    {
        this.addListener(new InputListener() {
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                Gdx.app.log("gdx", "enter :" + "("+x+","+y+")" );
                isTouching = true;
            }
            @Override
            public void exit (InputEvent event, float x, float y, int pointer, Actor toActor) {
                Gdx.app.log("gdx", "exit :" + "("+x+","+y+")" );
                isTouching = false;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button)
            {
                Gdx.app.log("gdx", "touchUp :" + "("+x+","+y+")" );
                super.touchUp(event, x, y, pointer, button);
            }
        });
    }
}
