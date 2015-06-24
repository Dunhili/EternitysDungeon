package com.dunhili.eternitysdungeon.ability;

/**
 * Outline for what each ability will look like. Each ability will have a cost associated with it (health and/or mana) 
 * unless it is a passive ability. Abilities will also have a range of [minRange, maxRange] that they can cast/used at.
 * The cast time for an ability is how many turns the unit will have to spend casting it before the effect goes off. Finally,
 * the flags for targetting enemies or allies will dictate whether abilities that have a target can target an enemy or
 * ally unit.
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

    /**
     * Returns the name of the ability.
     * @return ability name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the health cost of the ability.
     * @return health cost
     */
    public int getHealthCost() {
        return healthCost;
    }

    /**
     * Returns the mana cost of the ability.
     * @return mana cost
     */
    public int getManaCost() {
        return manaCost;
    }

    /**
     * Returns the casting time of the ability.
     * @return cast time
     */
    public int getCastTime() {
        return castTime;
    }

    /**
     * Returns the minimum range needed for the ability.
     * @return minimum range
     */
    public int getMinRange() {
        return minRange;
    }

    /**
     * Returns the maximum range that the ability can go.
     * @return maximum range
     */
    public int getMaxRange() {
        return maxRange;
    }

    /**
     * Returns the flag for whether this ability can target enemy units.
     * @return flag for if this target enemies
     */
    public boolean isTargetEnemies() {
        return targetEnemies;
    }

    /**
     * Returns the flag for whether this can ability can target allied units.
     * @return flag for if this targets allies
     * 
     */
    public boolean isTargetAllies() {
        return targetAllies;
    }

    /**
     * Returns the {@link AbilityType} of this ability.
     * @return type of ability.
     */
    public AbilityType getAbilityType() {
        return abilityType;
    }
}
