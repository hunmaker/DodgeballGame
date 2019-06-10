package com.starry.game.Chracter.Attack;

import com.starry.game.Ball.BallType;

public class NextAttack
{
    public BallType eBallType;
    public NextAttack(int rand)
    {
        eBallType = BallType.valueOf(rand);
    }
}
