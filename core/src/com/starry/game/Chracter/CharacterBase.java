package com.starry.game.Chracter;

public abstract class CharacterBase
{
    CharacterMovement characterMovement = new CharacterMovement();
    CharacterSprite chracterSprite = new CharacterSprite();


    protected void Init()
    {
        InitCopmonents();
    }

    protected void InitCopmonents()
    {
        characterMovement.Init();
        chracterSprite.Init();
    }
}
