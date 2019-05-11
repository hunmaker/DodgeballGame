package com.starry.game.Chracter;

import com.badlogic.gdx.InputMultiplexer;

public abstract class CharacterBase
{
    public CharacterMovement characterMovement = new CharacterMovement();
    public CharacterSprite characterSprite = new CharacterSprite();
    public CharacterAttack characterAttack = new CharacterAttack();

    public void Init(InputMultiplexer multiplexer)
    {
        InitCopmonents(multiplexer);
    }

    protected void InitCopmonents(InputMultiplexer multiplexer)
    {
        characterMovement.Init(characterSprite);
        characterSprite.Init(characterMovement);
        characterAttack.Init(multiplexer,characterMovement);
    }

    public void Dispose()
    {
        characterSprite.Dispose();
    }
}
