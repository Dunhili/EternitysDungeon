package com.dunhili.eternitysdungeon.character;

/**
 * Created by Dunhili on 5/25/2015.
 */
public class Stat {
    private static final String TAG = "Stat";

    private String name;
    private String shortName;
    private int value;
    private int growthRate;

    public Stat(StatType type, int value, int growthRate) {
        name = type.getName();
        shortName = type.getShortName();
        this.value = value;
        this.growthRate = growthRate;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(int growthRate) {
        this.growthRate = growthRate;
    }
}
