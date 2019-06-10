package com.starry.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.starry.game.Ball.BallManager;
import com.starry.game.Chracter.Attack.CharacterAttack;
import com.starry.game.Chracter.Base.CharacterBase;
import com.starry.game.Chracter.Base.PlayerCharacter;
import com.starry.game.MusicManager;

public class ItemUI
{
    Vector2 position;
    ImageButton btnItemShield;
    PlayerCharacter playerCharacter2;
    boolean itemShield = false;
    public void Init(Vector2 position, Stage stage, PlayerCharacter playerCharacter)
    {
        this.position = position;
        this.playerCharacter2 = playerCharacter;
        itemShield = true;

        if(BallManager.getInstance().hardLevel <= 0)
            itemShield = false;

        btnItemShield = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("shieldItem.png"))));
        btnItemShield.setScale(0.7f);
        btnItemShield.setTransform(true);
        btnItemShield.setPosition(position.x,position.y);
        btnItemShield.addListener(new ClickListener() {

            public void clicked(InputEvent event, float x, float y){
                if(!itemShield)
                    return;
                MusicManager.getInstance().PlayEffect("data/button.mp3");
                itemShield = false;
                playerCharacter2.useShield();
                btnItemShield.setVisible(itemShield);
                Gdx.app.log("gdx","btnItemShield Clicked");
            }
        });
        btnItemShield.setVisible(itemShield);
        stage.addActor(btnItemShield);
    }
}
