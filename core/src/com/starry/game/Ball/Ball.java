package com.starry.game.Ball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Ball
{
    Vector2 pos = new Vector2();
    float speed = 600.0f;
    float accelerationSpeed = -25;
    float angle = 45;
    float rotation = 0;
    ///초당 돌릴 각도
    float rotationAngle = 360*2;
    float rotationAngleacceleration = 0.9f;
    Sprite spriteBall;
    Texture textureBall;
    String strBall = "ball.png";
    public void Init(Vector2 startAt, float angle)
    {
        pos = startAt;
        this.angle = angle;
        Gdx.app.log("gdx","angle " + angle);
        textureBall = new Texture(strBall);
        spriteBall = new Sprite(textureBall);
        spriteBall.setSize(100,100);
        spriteBall.setOrigin(50,50);
        Gdx.app.log("gdx"," MathUtils.cos(angle) " + MathUtils.cosDeg(angle));
        Gdx.app.log("gdx"," MathUtils.sin(angle) " + MathUtils.sinDeg(angle));
    }

    public void Update()
    {
        pos.x += MathUtils.cosDeg(angle) * speed * Gdx.graphics.getDeltaTime();
        pos.y += MathUtils.sinDeg(angle) * speed * Gdx.graphics.getDeltaTime();
        speed += accelerationSpeed * Gdx.graphics.getDeltaTime();
        rotation += rotationAngle * Gdx.graphics.getDeltaTime();
        rotationAngle -= ((rotationAngle) * ((1.0f-rotationAngleacceleration) * Gdx.graphics.getDeltaTime()));
        //Gdx.app.log("gdx","rotation " + rotation);

        //Gdx.app.log("gdx","rotationAngle " + rotationAngle);
    }

    public void Render(Batch batch)
    {
        spriteBall.setPosition(pos.x,pos.y);
        spriteBall.setRotation(rotation);
        spriteBall.draw(batch);
    }

    public void Dispose()
    {
        textureBall.dispose();
    }

    public boolean isExpired()
    {
        return speed <= 0;
    }
}
