package com.dunhili.eternitysdungeon.character;

/**
 * Enumerated type for the different types of stats. Contains their long name and shortened name.
 * Created by Dunhili on 5/25/2015.
 */
public enum StatType {
    HITPOINTS("Hit Points", "HP", 0),
    MANA("Mana", "Mana", 1),
    STRENGTH("Strength", "Str", 2),
    DEXTERITY("Dexterity", "Dex", 3),
    INTELLIGENCE("Intelligence", "Int", 4),
    WILLPOWER("Willpower", "Will", 5),
    DEFENSE("Defense", "Def", 6),
    RESISTANCE("Resistance", "Res", 7);

    private String name;
    private String shortName;
    private int index;

    /**
     * Creates a Stat with the given name and shortened name.
     * @param name long name of the stat
     * @param shortName shortened name of the stat
     * @param index index of the stat in the list of stats
     */
    private StatType(String name, String shortName, int index) {
        this.name = name;
        this.shortName = shortName;
        this.index = index;
    }

    /**
     * Returns the long name of the stat.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the shortened name of the stat.
     * @return short name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Returns the index of the stat in the list of stats.
     * @return stat index
     */
    public int getIndex() { return index; }
}
