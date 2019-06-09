package com.starry.game;

import com.starry.game.Ball.BallType;

import java.util.HashMap;
import java.util.Map;

public enum Faction
{
    Ally(0),
    Enemy(1);

    private int value;
    private static Map map = new HashMap();

    private Faction(int value) {
        this.value = value;
    }

    static {
        for (Faction pageType : Faction.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static Faction valueOf(int pageType) {
        return (Faction) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}
