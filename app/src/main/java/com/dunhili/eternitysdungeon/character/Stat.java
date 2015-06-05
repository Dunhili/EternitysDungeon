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
    private int cap;

    public Stat(StatType type, int value, int growthRate, int cap) {
        name = type.getName();
        shortName = type.getShortName();
        this.value = value;
        this.growthRate = growthRate;
        this.cap = cap;
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

    public int getCap() { return cap; }

    public void setCap(int cap) { this.cap = cap; }
}
