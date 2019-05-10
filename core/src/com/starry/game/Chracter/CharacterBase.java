package com.starry.game.Chracter;

public abstract class CharacterBase
{
    public CharacterMovement characterMovement = new CharacterMovement();
    public CharacterSprite chracterSprite = new CharacterSprite();


    public void Init()
    {
        InitCopmonents();
    }

    protected void InitCopmonents()
    {
        characterMovement.Init();
        chracterSprite.Init(characterMovement);
    }

    public void Dispose()
    {
        chracterSprite.Dispose();
    }
}
