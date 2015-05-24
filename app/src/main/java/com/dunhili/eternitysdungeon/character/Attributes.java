package com.dunhili.eternitysdungeon.character;

/**
 * Created by Dunhili on 5/24/2015.
 */
public class Attributes {
    private int maxHP           = 1;
    private int maxMana         = 1;
    private int currentHP       = 1;
    private int currentMana     = 1;

    private int strength        = 1;
    private int dexterity       = 1;
    private int intelligence    = 1;
    private int willpower       = 1;
    private int defense         = 1;
    private int resistance      = 1;

    private int level           = 1;
    private int experience      = 0;
    private int experienceValue = 0;

    private int moveSpeed       = 1;

    /**
     * Returns the max HP for the character.
     * @return max HP
     */
    public int getMaxHP() {
        return maxHP;
    }

    /**
     * Sets the max HP for the character to the given value.
     * @param maxHP max HP to set
     */
    public void setMaxHP(int maxHP) {
        if (maxHP > 0) {
            this.maxHP = maxHP;
        }
    }

    /**
     * Returns the max mana for the character.
     * @return max mana
     */
    public int getMaxMana() {
        return maxMana;
    }

    /**
     * Sets the max mana for the character to the given value.
     * @param maxMana max mana to set
     */
    public void setMaxMana(int maxMana) {
        if (maxMana > 0) {
            this.maxMana = maxMana;
        }
    }

    /**
     * Returns the current HP for the character.
     * @return current HP
     */
    public int getCurrentHP() {
        return currentHP;
    }

    /**
     * Sets the current HP for the character to the given value.
     * @param currentHP current HP to set
     */
    public void setCurrentHP(int currentHP) {
        if (currentHP < 0) {
            this.currentHP = 0;
        } else {
            this.currentHP = currentHP;
        }
    }

    /**
     * Returns the current mana for the character.
     * @return current mana
     */
    public int getCurrentMana() {
        return currentMana;
    }

    /**
     * Sets the current mana for the character to the given value.
     * @param currentMana current mana to set
     */
    public void setCurrentMana(int currentMana) {
        this.currentMana = (currentMana < 0) ? 0 : currentMana;
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
        this.level = level;
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
        this.experience = experience;
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
        this.moveSpeed = moveSpeed;
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
        this.experienceValue = experienceValue;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWillpower() {
        return willpower;
    }

    public void setWillpower(int willpower) {
        this.willpower = willpower;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
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
     * Adds the HP to the current HP. If the HP drops to 0 or lower, then the character dies and
     * drops its inventory.
     * @param hpToAdd amount of HP to add
     */
    public void addHP(int hpToAdd) {
        currentHP += hpToAdd;
        if (currentHP <= 0) {
            currentHP = 0;
        } else if (currentHP > maxHP) {
            currentHP = maxHP;
        }
    }

    /**
     * Adds the mana to the current mana.
     * @param manaToAdd amount of mana to add
     */
    public void addMana(int manaToAdd) {
        currentMana += manaToAdd;
        if (currentMana < 0) {
            currentMana = 0;
        } else if (currentMana > maxMana) {
            currentMana = maxMana;
        }
    }

    private void levelUp() {
        ++level;
        // TODO
    }
}
