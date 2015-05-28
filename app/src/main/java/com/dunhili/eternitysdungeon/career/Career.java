package com.dunhili.eternitysdungeon.career;

import com.dunhili.eternitysdungeon.ability.Ability;
import com.dunhili.eternitysdungeon.character.StatType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dunhili on 5/25/2015.
 */
public abstract class Career {
    private static final String TAG = "Career";

    private String name;

    private int growthRates[] = new int[StatType.values().length];
    private int statCaps[] = new int[StatType.values().length];

    private List<Ability> abilities;

    public Career() {
        abilities = new ArrayList<>();
    }

    public int[] getGrowthRates() {
        return growthRates;
    }

    public int[] getStatCaps() {
        return statCaps;
    }
}
