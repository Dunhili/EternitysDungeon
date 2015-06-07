package com.dunhili.eternitysdungeon.ability;

/**
 * Created by Dunhili on 5/27/2015.
 */
public class Ability {
    private String name             = "";
    private int healthCost          = 0;
    private int manaCost            = 0;
    private int castTime            = 0;
    private int minRange            = 1;
    private int maxRange            = 1;
    private boolean targetEnemies   = true;
    private boolean targetAllies    = true;
    private AbilityType abilityType = AbilityType.SINGLE;

    public Ability() {

    }

    public String getName() {
        return name;
    }

    public int getHealthCost() {
        return healthCost;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getCastTime() {
        return castTime;
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public boolean isTargetEnemies() {
        return targetEnemies;
    }

    public boolean isTargetAllies() {
        return targetAllies;
    }

    public AbilityType getAbilityType() {
        return abilityType;
    }
}
