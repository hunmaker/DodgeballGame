package com.starry.game.Chracter;

import com.badlogic.gdx.InputMultiplexer;

public abstract class CharacterBase
{
    public CharacterMovement characterMovement = new CharacterMovement();
    public CharacterSprite chracterSprite = new CharacterSprite();
    public CharacterAttack characterAttack = new CharacterAttack();

    public void Init(InputMultiplexer multiplexer)
    {
        InitCopmonents(multiplexer);
    }

    protected void InitCopmonents(InputMultiplexer multiplexer)
    {
        characterMovement.Init();
        chracterSprite.Init(characterMovement);
        characterAttack.Init(multiplexer);
    }

    public void Dispose()
    {
        chracterSprite.Dispose();
    }
}
