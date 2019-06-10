package com.starry.game.Chracter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.starry.game.Chracter.Movement.CharacterMovement;

public class CharacterSprite
{
    Texture textureChracter;
    public Sprite spriteCharacter;
    public Sprite spriteShieldAura;

    public Sprite spriteHp;
    public Sprite spriteBackGround;


    CharacterMovement characterMovement;
    CharacterHealth characterHealth;
    public void Init(CharacterMovement characterMovement, CharacterHealth characterHealth)
    {
        textureChracter = new Texture("player_charactor.png");
        spriteShieldAura = new Sprite(new Texture("shieldAura.png"));
        spriteShieldAura.setScale(1.4f);
        spriteCharacter = new Sprite(textureChracter);
        spriteBackGround = new Sprite(new Texture("black_bar.png"));
        spriteHp = new Sprite(new Texture("red_bar.png"));
        spriteCharacter.setOrigin(spriteCharacter.getWidth()/2,spriteCharacter.getHeight()/2);
        spriteShieldAura.setOrigin(spriteShieldAura.getWidth()/2,spriteShieldAura.getHeight()/2);
        spriteHp.setOrigin(0,0);
        this.characterMovement = characterMovement;
        this.characterHealth = characterHealth;

    }

    public void Render(SpriteBatch batch)
    {
        if(characterHealth.isInvincibil)
        {
            spriteShieldAura.setPosition(characterMovement.position.x,characterMovement.position.y);
            spriteShieldAura.rotate(360.0f * Gdx.graphics.getDeltaTime());
            spriteShieldAura.draw(batch);
        }

        spriteCharacter.setPosition(characterMovement.position.x,characterMovement.position.y);
        //spriteCharacter.setRegion(0,0,(int)(spriteCharacter.getWidth()),(int)spriteCharacter.getHeight());
        //spriteCharacter.setScale(1,1);
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
