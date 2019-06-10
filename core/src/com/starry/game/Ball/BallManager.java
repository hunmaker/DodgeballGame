package com.starry.game.Ball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.starry.game.Chracter.Attack.NextAttack;
import com.starry.game.Chracter.Base.EnemyChracter;
import com.starry.game.Chracter.CharacterHealth;
import com.starry.game.Faction;
import com.starry.game.SpriteManager.SpriteManager;

import java.util.ArrayList;
import java.util.List;

public class BallManager
{

    public int hardLevel = 0;
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

    public void Update(CharacterHealth player, CharacterHealth enemy)//
    {
        List<Ball> expiredBallList = new ArrayList<Ball>();
        for(Ball target : ballList)
        {
            boolean hited = false;
            target.Update();
            if(target.eFaction == Faction.Enemy)
            {
                hited =Intersector.overlaps(target.getCircle(),player.getRectangle());
                if(hited)
                    player.Hited(target);
            }
            else if(target.eFaction == Faction.Ally)
            {
                hited =Intersector.overlaps(target.getCircle(),enemy.getRectangle());
                if(hited)
                    enemy.Hited(target);
            }

            if(target.isExpired() || hited)
            {
                target.Dispose();
                expiredBallList.add(target);
            }
        }
        ballList.removeAll(expiredBallList);
    }

    public void Render(Batch batch)
    {
        for(Ball target : ballList)
        {
            target.Render(batch);
        }
    }

    public void Shoot(Vector2 from, Vector2 to, Vector2 startAt, Faction faction, NextAttack nextAttack)
    {
        from = from.cpy();
        to = to.cpy();
        Ball newBall = new Ball();
        float degree = GetDegree(from,to);
        Gdx.app.log("gdx","degree " + degree);
        newBall.Init(startAt,degree,faction, nextAttack);

        ballList.add(newBall);
    }

    private float GetDegree(Vector2 from, Vector2 to)
    {
        return MathUtils.atan2(to.y-from.y, to.x-from.x) * 180/MathUtils.PI;
    }
}
