package com.starry.game.Ball;

import java.util.HashMap;
import java.util.Map;

public enum BallType {
    DodgeBall(1),
    SoccerBall(2),
    BasketBall(3);

    private int value;
    private static Map map = new HashMap();

    private BallType(int value) {
        this.value = value;
    }

    static {
        for (BallType pageType : BallType.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static BallType valueOf(int pageType) {
        return (BallType) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}