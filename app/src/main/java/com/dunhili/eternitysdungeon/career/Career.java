package com.dunhili.eternitysdungeon.career;

import com.dunhili.eternitysdungeon.character.StatType;

/**
 * Created by Dunhili on 5/25/2015.
 */
public abstract class Career {
    private static final String TAG = "Career";

    private String name;

    private int growthRates[] = new int[StatType.values().length];
    private int statCaps[] = new int[StatType.values().length];

    public Career() {

    }

    public int[] getGrowthRates() {
        return growthRates;
    }

    public int[] getStatCaps() {
        return statCaps;
    }
}
