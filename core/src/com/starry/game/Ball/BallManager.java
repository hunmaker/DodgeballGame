package com.starry.game.Ball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.starry.game.SpriteManager.SpriteManager;

import java.util.ArrayList;
import java.util.List;

public class BallManager
{
    private  List<Ball> ballList = new ArrayList<Ball>();

    private static BallManager instance;
    public static synchronized BallManager getInstance(){
        if(instance == null){
            instance = new BallManager();
        }
        return instance;
    }

    public void Init()
    {

    }

    public void Update()
    {
        for(Ball target : ballList)
        {
            target.Update();
        }
    }

    public void Render(Batch batch)
    {
        for(Ball target : ballList)
        {
            target.Render(batch);
        }
    }

    public void Shoot(Vector2 from, Vector2 to)
    {
        from = from.cpy();
        to = to.cpy();
        Ball newBall = new Ball();
        float degree = GetDegree(from,to);
        Gdx.app.log("gdx","degree " + degree);
        newBall.Init(from,degree);

        ballList.add(newBall);
    }

    private float GetDegree(Vector2 from, Vector2 to)
    {
        return MathUtils.atan2(to.y-from.y, to.x-from.x) * 180/MathUtils.PI;
    }
}
