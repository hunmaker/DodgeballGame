package com.starry.game.Ball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.starry.game.Faction;

import java.util.Random;

public class Ball
{
    public int damage = 5;
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

    String[] strBall = {"dodge_ball.png", "soccer_ball.png", "basket_ball.png"};
    Random r = new Random();
    int ballType = r.nextInt(3);
    String rndBall = "";

    public BallType eBallType;
    public Faction eFaction;

    float reverse = 1.0f;

    public void Init(Vector2 startAt, float angle, Faction faction) // ballType
    {
        pos = startAt;
        this.angle = angle;
        Gdx.app.log("gdx","angle " + angle);
        rndBall = strBall[ballType];
        textureBall = new Texture(rndBall);
        spriteBall = new Sprite(textureBall);
        //spriteBall.setSize(100,100);
        //spriteBall.setOrigin(50,50);
        eFaction = faction;
        Gdx.app.log("gdx"," MathUtils.cos(angle) " + MathUtils.cosDeg(angle));
        Gdx.app.log("gdx"," MathUtils.sin(angle) " + MathUtils.sinDeg(angle));

        eBallType = getBallType();
        switch (eBallType)
        {
            case DodgeBall:
                speed *= 2;
                damage = 5;
                break;

            case SoccerBall:
                speed *= 1.5;
                damage = 7;
                break;

            case BasketBall:
                speed *= 1.0;
                damage = 10;
                break;
        }
    }

    public void Update()
    {
        if(rndBall == strBall[0]) {
            Move();
            speed += accelerationSpeed * Gdx.graphics.getDeltaTime();
            rotation += rotationAngle * Gdx.graphics.getDeltaTime();
            rotationAngle -= ((rotationAngle) * ((1.0f - rotationAngleacceleration) * Gdx.graphics.getDeltaTime()));
        }
        else if(rndBall == strBall[1]){
            Move();
            speed += accelerationSpeed * Gdx.graphics.getDeltaTime();
            rotation += rotationAngle * Gdx.graphics.getDeltaTime();
            rotationAngle -= ((rotationAngle) * ((1.0f - rotationAngleacceleration) * Gdx.graphics.getDeltaTime()));
        }
        else {
            Move();
            speed += accelerationSpeed * Gdx.graphics.getDeltaTime();
            rotation += rotationAngle * Gdx.graphics.getDeltaTime();
            rotationAngle -= ((rotationAngle) * ((1.0f - rotationAngleacceleration) * Gdx.graphics.getDeltaTime()));
        }

        //Gdx.app.log("gdx","rotation " + rotation);

        //Gdx.app.log("gdx","rotationAngle " + rotationAngle);

        if(eBallType == BallType.BasketBall &&
                pos.x > Gdx.graphics.getWidth()-spriteBall.getWidth() ||
                pos.x <= 0)
        {
            reverse();
            Move();
        }

    }

    private void Move()
    {
        pos.x += MathUtils.cosDeg(angle) * speed * Gdx.graphics.getDeltaTime() * reverse;
        pos.y += MathUtils.sinDeg(angle) * speed * Gdx.graphics.getDeltaTime();
    }

    private void reverse()
    {
        reverse *= -1.0f;
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

    public BallType getBallType()
    {
        return BallType.valueOf(ballType);
    }

    public Circle getCircle()
    {
        return new Circle(pos.x+spriteBall.getWidth()/2,pos.y+spriteBall.getHeight()/2,spriteBall.getWidth()/2);
    }
}

