package com.starry.game.Chracter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.starry.game.Chracter.Movement.CharacterMovement;

public class CharacterSprite
{
    Texture textureChracter;
    public Sprite spriteCharacter;

    CharacterMovement characterMovement;
    public void Init(CharacterMovement characterMovement)
    {
        textureChracter = new Texture("badlogic.jpg");
        spriteCharacter = new Sprite(textureChracter);
        spriteCharacter.setOrigin(spriteCharacter.getWidth()/2,spriteCharacter.getHeight()/2);
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

    public float getWidth()
    {
        return spriteCharacter.getWidth();
    }
    public float getHeight()
    {
        return spriteCharacter.getHeight();
    }
}
