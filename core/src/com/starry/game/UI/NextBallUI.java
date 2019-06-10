package com.starry.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.starry.game.Chracter.Attack.CharacterAttack;
import com.starry.game.Chracter.CharacterSprite;

import java.util.ArrayList;

public class NextBallUI
{
    Vector2 position ;
    CharacterAttack characterAttack;
    Sprite[] spriteNextBallList;
    Sprite[] spriteBoxList;

    Texture[] textureBall;
    String[] strBall = {"dodge_ball.png", "soccer_ball.png", "basket_ball.png"};

    public void Init(CharacterAttack characterAttack, Vector2 position)
    {
        this.characterAttack = characterAttack;
        spriteNextBallList = new Sprite[characterAttack.maxAttack];
        spriteBoxList = new Sprite[characterAttack.maxAttack];

        textureBall = new Texture[3];
        this.position = position;
        for(int i=0; i<3; i++)
        {
            textureBall[i] = new Texture(strBall[i]);
        }
        for(int i=0; i<spriteNextBallList.length; i++)
        {
            spriteNextBallList[i] = new Sprite(textureBall[0]);
            spriteBoxList[i] = new Sprite(new Texture("box.png"));
            spriteBoxList[i].setSize(150.0f,140.0f);
            spriteBoxList[i].setAlpha(0.9f);
        }
    }

    public void Render(SpriteBatch batch)
    {
        float totalHeight = 0;

        for(int i=0; i<spriteBoxList.length; i++)
        {
            spriteBoxList[i].setPosition(position.x-5.0f,position.y + totalHeight);
            spriteBoxList[i].draw(batch);
            totalHeight += 140.0f;//spriteBoxList[i].getHeight();
        }
        totalHeight = 0;
        for(int i=0; i<characterAttack.nextAttackList.size(); i++)
        {
            spriteNextBallList[i].setTexture(textureBall[characterAttack.nextAttackList.get(i).eBallType.getValue()]);
            spriteNextBallList[i].setPosition(position.x,position.y + totalHeight);
            spriteNextBallList[i].draw(batch);
            spriteNextBallList[i].rotate(90.0f* Gdx.graphics.getDeltaTime());
            totalHeight += 140.0f;//spriteNextBallList[i].getHeight();
        }
    }
}
