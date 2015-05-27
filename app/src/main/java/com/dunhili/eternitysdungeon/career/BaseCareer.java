package com.dunhili.eternitysdungeon.career;

import com.dunhili.eternitysdungeon.character.StatType;

/**
 * Created by Dunhili on 5/26/2015.
 */
public class BaseCareer extends Career {
    private int initialStats[] = new int[StatType.values().length];

    public BaseCareer() {

    }

    public int[] getInitialStats() {
        return initialStats;
    }
}
