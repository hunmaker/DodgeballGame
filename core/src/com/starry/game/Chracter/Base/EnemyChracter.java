package com.starry.game.Chracter.Base;

import com.badlogic.gdx.InputMultiplexer;
import com.starry.game.Chracter.Attack.EnemyAttack;
import com.starry.game.Chracter.CharacterHealth;
import com.starry.game.Chracter.CharacterSprite;
import com.starry.game.Chracter.Movement.EnemyMovement;

public class EnemyChracter extends CharacterBase
{
    @Override
    protected void InitCopmonents(InputMultiplexer multiplexer)
    {
        characterMovement = new EnemyMovement();
        characterSprite = new CharacterSprite();
        characterAttack = new EnemyAttack();

        characterMovement.Init(characterSprite,characterState);
        characterSprite.Init(characterMovement);
        characterAttack.Init(multiplexer,characterMovement, characterState);

        super.InitCopmonents(multiplexer);

        characterHealth.setMaxHp(200);
    }
}
