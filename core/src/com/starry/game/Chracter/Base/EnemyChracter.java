package com.starry.game.Chracter.Base;

import com.badlogic.gdx.InputMultiplexer;
import com.starry.game.Ball.BallManager;
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
        characterHealth = new CharacterHealth();

        characterMovement.Init(characterSprite,characterState);
        characterSprite.Init(characterMovement, characterHealth, characterState);
        characterAttack.Init(multiplexer,characterMovement, characterState);

        super.InitCopmonents(multiplexer);

        if(BallManager.getInstance().hardLevel == 0)
        {
            characterHealth.setMaxHp(60);
        }
        else if(BallManager.getInstance().hardLevel == 1)
        {
            characterHealth.setMaxHp(120);
        }
        else if(BallManager.getInstance().hardLevel == 2)
        {
            characterHealth.setMaxHp(200);
        }
    }
}
