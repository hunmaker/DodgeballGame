package com.starry.game.Chracter.Base;

import com.badlogic.gdx.InputMultiplexer;
import com.starry.game.Chracter.Attack.PlayerAttack;
import com.starry.game.Chracter.CharacterHealth;
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
        characterHealth = new CharacterHealth();

        characterMovement.Init(characterSprite,characterState);
        characterSprite.Init(characterMovement, characterHealth, characterState);
        characterAttack.Init(multiplexer,characterMovement, characterState);

        super.InitCopmonents(multiplexer);

        characterHealth.setMaxHp(100);
    }
}
