package com.starry.game.Chracter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.starry.game.Ball.Ball;
import com.starry.game.Chracter.Movement.CharacterMovement;

public class CharacterHealth
{
    private int hp;
    private int maxHp;
    private CharacterMovement characterMovement;
    private CharacterSprite chracterSprite;

    public void Init(CharacterMovement characterMovement, CharacterSprite chracterSprite)
    {
        this.characterMovement = characterMovement;
        this.chracterSprite = chracterSprite;
    }

    public void setMaxHp(int value)
    {
        this.maxHp = value;
        this.hp = maxHp;
    }

    public Rectangle getRectangle()
    {
        return new Rectangle(characterMovement.position.x, characterMovement.position.y, chracterSprite.getWidth(), chracterSprite.getHeight());
    }

    public void Hited(Ball target)
    {
        hp -= target.damage;
        Gdx.app.log("gdx",String.format("Hited! %d/%d",hp,maxHp));
    }
}
