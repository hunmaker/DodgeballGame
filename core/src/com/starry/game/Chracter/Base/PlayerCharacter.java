package com.starry.game.Chracter.Base;

import com.badlogic.gdx.InputMultiplexer;
import com.starry.game.Chracter.Attack.CharacterAttack;
import com.starry.game.Chracter.Attack.PlayerAttack;
import com.starry.game.Chracter.CharacterSprite;
import com.starry.game.Chracter.Movement.PlayerMovement;

public class PlayerCharacter extends CharacterBase
{
    @Override
    protected void InitCopmonents(InputMultiplexer multiplexer)
    {
        characterMovement = new PlayerMovement();
        characterSprite = new CharacterSprite();
        characterAttack = new PlayerAttack();

        characterMovement.Init(characterSprite,characterState);
        characterSprite.Init(characterMovement);
        characterAttack.Init(multiplexer,characterMovement);
    }
}
