package com.dunhili.eternitysdungeon.character;

import com.dunhili.eternitysdungeon.career.AdvancedCareer;
import com.dunhili.eternitysdungeon.utils.StatCalculator;

import java.util.Random;

/**
 * Created by Dunhili on 5/24/2015.
 */
public class Attributes {
    private static final String TAG = "Attributes";

    private Stat[] stats = new Stat[StatType.values().length];

    private int currentHP       = 1;
    private int currentMana     = 1;

    private int level           = 1;
    private int experience      = 0;
    private int experienceValue = 0;

    private int moveSpeed       = 1;

    public Attributes(int[] initialStats, int[] growthRates, int[] statCaps) {
        StatType[] listOfStats = StatType.values();
        // this is done because the list of stats are not going to be in order, so we get their
        // index and grab the corresponding values from the initial stats and growth rates
        for (int i = 0; i < listOfStats.length; i++) {
            int currIndex = listOfStats[i].getIndex();
            stats[currIndex] = new Stat(listOfStats[i], initialStats[currIndex], growthRates[currIndex], statCaps[currIndex]);
        }

        currentHP = getMaxHP().getValue();
        currentMana = getMaxMana().getValue();
    }

    /**
     * Returns the max HP for the character.
     * @return max HP
     */
    public Stat getMaxHP() { return stats[StatType.HITPOINTS.getIndex()]; }

    /**
     * Returns the max mana for the character.
     * @return max mana
     */
    public Stat getMaxMana() { return stats[StatType.MANA.getIndex()]; }

    /**
     * Returns the strength of the character.
     * @return strength
     */
    public Stat getStrength() { return stats[StatType.STRENGTH.getIndex()]; }

    /**
     * Returns the dexterity of the character.
     * @return dexterity
     */
    public Stat getDexterity() { return stats[StatType.DEXTERITY.getIndex()]; }

    /**
     * Returns the intelligence of the character.
     * @return intelligence
     */
    public Stat getIntelligence() { return stats[StatType.INTELLIGENCE.getIndex()]; }

    /**
     * Returns the willpower of the character.
     * @return willpower
     */
    public Stat getWillpower() { return stats[StatType.WILLPOWER.getIndex()]; }

    /**
     * Returns the defense of the character.
     * @return defense
     */
    public Stat getDefense() { return stats[StatType.DEFENSE.getIndex()]; }

    /**
     * Returns the resistance of the character.
     * @return resistance
     */
    public Stat getResistance() { return stats[StatType.RESISTANCE.getIndex()]; }

    /**
     * Returns the current HP for the character.
     * @return current HP
     */
    public int getCurrentHP() { return currentHP; }

    /**
     * Sets the current HP for the character to the given value.
     * @param currentHP current HP to set
     */
    public void setCurrentHP(int currentHP) {
        if (currentHP < 0) {
            this.currentHP = 0;
        } else if (currentHP > getMaxHP().getValue()) {
            this.currentHP = getMaxHP().getValue();
        } else {
            this.currentHP = currentHP;
        }
    }

    /**
     * Returns the current mana for the character.
     * @return current mana
     */
    public int getCurrentMana() { return currentMana; }

    /**
     * Sets the current mana for the character to the given value.
     * @param currentMana current mana to set
     */
    public void setCurrentMana(int currentMana) {
        if (currentMana < 0) {
            this.currentMana = 0;
        } else if (currentMana > getMaxMana().getValue()) {
            this.currentMana = getMaxMana().getValue();
        } else {
            this.currentMana = currentMana;
        };
    }

    /**
     * Returns the level of the character.
     * @return character level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the character level to the given value.
     * @param level level to set
     */
    public void setLevel(int level) {
        if (level >= 1) {
            this.level = level;
        }
    }

    /**
     * Returns the amount of experience for the character.
     * @return character experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Sets the amount of experience to the given value.
     * @param experience experience amount to set
     */
    public void setExperience(int experience) {
        if (experience >= 0) {
            this.experience = experience;
        }
    }


    /**
     * Returns the character's movement speed.
     * @return movement speed
     */
    public int getMoveSpeed() {
        return moveSpeed;
    }

    /**
     * Sets the character's movement speed to the given value.
     * @param moveSpeed movement speed to set
     */
    public void setMoveSpeed(int moveSpeed) {
        if (moveSpeed >= 0) {
            this.moveSpeed = moveSpeed;
        }
    }

    /**
     * Returns the character's exp value when killed.
     * @return exp value
     */
    public int getExperienceValue() {
        return experienceValue;
    }

    /**
     * Sets the character's exp value to the given value.
     * @param experienceValue experience value
     */
    public void setExperienceValue(int experienceValue) {
        if (experienceValue >= 0) {
            this.experienceValue = experienceValue;
        }
    }

    /**
     * Adds the bonuses from upgraded the career to the stats.
     * @param upgradedCareer career that has the new growth rates, stat caps, and promotion bonus
     */
    public void addPromotionBonus(AdvancedCareer upgradedCareer) {
        StatType[] listOfStats = StatType.values();
        int[] promotionBonus = upgradedCareer.getPromotionBonus();
        int[] newGrowthRates = upgradedCareer.getGrowthRates();
        int[] newStatCaps = upgradedCareer.getStatCaps();
        for (int i = 0; i < listOfStats.length; i++) {
            int currIndex = listOfStats[i].getIndex();
            stats[currIndex].setValue(stats[currIndex].getValue() + promotionBonus[currIndex]);
            stats[currIndex].setGrowthRate(newGrowthRates[currIndex]);
            stats[currIndex].setCap(newStatCaps[currIndex]);
        }
    }

    /**
     * Adds the exp to the current amount of experience. If the character has over 100 experience,
     * then the character levels up.
     * @param expToAdd amount of experience to add
     */
    public void addExp(int expToAdd) {
        experience += expToAdd;

        if (experience < 0) {
            experience = 0;
        }

        if (experience >= 100) {
            while (experience >= 100) {
                levelUp();
                experience -= 100;
            }
        }
    }

    /**
     * Adds the HP to the current HP.
     * @param hpToAdd amount of HP to add
     */
    public void addHP(int hpToAdd) {
        setCurrentHP(currentHP + hpToAdd);
    }

    /**
     * Adds the mana to the current mana.
     * @param manaToAdd amount of mana to add
     */
    public void addMana(int manaToAdd) {
        setCurrentMana(currentMana + manaToAdd);
    }

    private void levelUp() {
        ++level;
        StatCalculator.levelUp(stats);
    }
}
