package com.dunhili.eternitysdungeon.career;

import com.dunhili.eternitysdungeon.ability.Ability;
import com.dunhili.eternitysdungeon.character.StatType;

/**
 * Created by Dunhili on 5/26/2015.
 */
public class BaseCareer extends Career {
    private int startingStats[] = new int[StatType.values().length];
    private static final int[] statCaps = {40, 40, 20, 20, 20, 20, 20, 20};

    public BaseCareer(String name, int[] growthRates, int[] startingStats, Ability[] abilities) {
        super(name, growthRates, statCaps, abilities);
        for (int i = 0; i < StatType.values().length; i++) {
            this.startingStats[i] = startingStats[i];
        }
    }

    public int[] getStartingStats() {
        return startingStats;
    }
}
