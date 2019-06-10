package com.starry.game.Chracter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.starry.game.Chracter.Movement.CharacterMovement;

public class CharacterSprite
{
    Texture textureChracter;
    public Sprite spriteCharacter;

    public Sprite spriteHp;
    public Sprite spriteBackGround;


    CharacterMovement characterMovement;
    CharacterHealth characterHealth;
    public void Init(CharacterMovement characterMovement, CharacterHealth characterHealth)
    {
        textureChracter = new Texture("badlogic.jpg");
        spriteCharacter = new Sprite(textureChracter);
        spriteBackGround = new Sprite(new Texture("badlogic.jpg"));
        spriteHp = new Sprite(new Texture("badlogic.jpg"));
        spriteCharacter.setOrigin(spriteCharacter.getWidth()/2,spriteCharacter.getHeight()/2);
        spriteHp.setOrigin(0,0);
        this.characterMovement = characterMovement;
        this.characterHealth = characterHealth;

    }

    public void Render(SpriteBatch batch)
    {
        spriteCharacter.setPosition(characterMovement.position.x,characterMovement.position.y);
        spriteCharacter.draw(batch);

        spriteBackGround.setPosition(characterMovement.position.x,characterMovement.position.y - spriteCharacter.getHeight());
        spriteBackGround.draw(batch);

        spriteHp.setPosition(characterMovement.position.x, characterMovement.position.y - spriteCharacter.getHeight());
        spriteHp.setRegion(0,0,(int)(spriteHp.getWidth()*characterHealth.getHpRate()), (int)spriteHp.getHeight());
        spriteHp.setScale(characterHealth.getHpRate(), 1);
        spriteHp.draw(batch);
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
