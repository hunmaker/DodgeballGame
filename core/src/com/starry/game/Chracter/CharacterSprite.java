package com.starry.game.Chracter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CharacterSprite
{
    Texture textureChracter;
    Sprite spriteCharacter;

    CharacterMovement characterMovement;
    protected void Init(CharacterMovement characterMovement)
    {
        textureChracter = new Texture("badlogic.jpg");
        spriteCharacter = new Sprite(textureChracter);
        this.characterMovement = characterMovement;
    }

    public void Render(SpriteBatch batch)
    {
        spriteCharacter.setPosition(characterMovement.position.x,characterMovement.position.y);
        spriteCharacter.draw(batch);
    }

    public void Dispose()
    {
        textureChracter.dispose();
    }
}
