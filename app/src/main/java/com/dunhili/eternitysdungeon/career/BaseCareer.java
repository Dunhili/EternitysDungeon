package com.dunhili.eternitysdungeon.career;

import com.dunhili.eternitysdungeon.ability.Ability;
import com.dunhili.eternitysdungeon.character.StatType;

/**
 * Created by Dunhili on 5/26/2015.
 */
public class BaseCareer extends Career {
    private int startingStats[] = new int[StatType.values().length];
    private static final int[] statCaps = {40, 40, 20, 20, 20, 20, 20, 20};

    private AdvancedCareer upgradedCareerA;
    private AdvancedCareer upgradedCareerB;

    public BaseCareer(String name, int[] growthRates, int[] startingStats, Ability[] abilities,
            AdvancedCareer upgradedCareerA, AdvancedCareer upgradedCareerB) {
        super(name, growthRates, statCaps, abilities);
        System.arraycopy(startingStats, 0, this.startingStats, 0, startingStats.length);
        this.upgradedCareerA = upgradedCareerA;
        this.upgradedCareerB = upgradedCareerB;
    }

    public int[] getStartingStats() {
        return startingStats;
    }

    public AdvancedCareer getUpgradedCareerA() {
        return upgradedCareerA;
    }

    public AdvancedCareer getUpgradedCareerB() {
        return upgradedCareerB;
    }
}
