package com.starry.game.Chracter.Base;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.starry.game.Chracter.Attack.CharacterAttack;
import com.starry.game.Chracter.CharacterHealth;
import com.starry.game.Chracter.CharacterSprite;
import com.starry.game.Chracter.Movement.CharacterMovement;
import com.starry.game.Faction;

public abstract class CharacterBase
{
    public CharacterMovement characterMovement;
    public CharacterSprite characterSprite;
    public CharacterAttack characterAttack;
    public CharacterHealth characterHealth;
    public CharacterState characterState = new CharacterState();

    public void useShield()
    {
        characterHealth.StartShield();
    }

    public class CharacterState
    {
        public boolean isPlayer = true;
        public Faction faction;
    }

    public void Init(InputMultiplexer multiplexer, boolean isPlayer, Vector2 startAt)
    {
        this.characterState.isPlayer = isPlayer;
        this.characterState.faction = isPlayer ? Faction.Ally : Faction.Enemy;
        InitCopmonents(multiplexer);
        this.characterMovement.position = startAt.cpy();
    }

    protected void InitCopmonents(InputMultiplexer multiplexer)
    {
        characterHealth.Init(characterMovement,characterSprite);
    }

    public void Update()
    {
        characterMovement.Update();
        characterAttack.Update();
    }

    public void Render(SpriteBatch batch)
    {
        characterSprite.Render(batch);
    }

    public void Dispose()
    {
        characterSprite.Dispose();
    }
}
