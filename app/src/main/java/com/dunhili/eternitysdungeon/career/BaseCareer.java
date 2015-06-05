package com.dunhili.eternitysdungeon.career;

import com.dunhili.eternitysdungeon.character.StatType;

/**
 * Created by Dunhili on 5/26/2015.
 */
public class BaseCareer extends Career {
    private int startingStats[] = new int[StatType.values().length];

    public BaseCareer(String name, int[] growthRates, int[] statCaps, int[] startingStats) {
        super(name, growthRates, statCaps);
        for (int i = 0; i < StatType.values().length; i++) {
            this.startingStats[i] = startingStats[i];
        }
    }

    public int[] getStartingStats() {
        return startingStats;
    }
}
