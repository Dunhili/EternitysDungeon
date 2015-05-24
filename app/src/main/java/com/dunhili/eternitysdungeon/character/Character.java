package com.dunhili.eternitysdungeon.character;

import com.dunhili.eternitysdungeon.item.Armor;
import com.dunhili.eternitysdungeon.item.Inventory;
import com.dunhili.eternitysdungeon.item.Item;
import com.dunhili.eternitysdungeon.item.Weapon;
import com.dunhili.eternitysdungeon.map.Position;

import java.util.List;

/**
 * Represents all the characters in the game, which can include Non-playable characters (NPCs), such
 * as vendors, commoners, etc., playable characters (PCs), and enemies.
 * Created by Dunhili on 5/23/2015.
 */
public class Character {
    //////////////////////////////////////////////////////////////
    // FIELDS
    //////////////////////////////////////////////////////////////
    private static final String TAG = "Character";

    private int maxHP           = 1;
    private int maxMana         = 1;
    private int currentHP       = 1;
    private int currentMana     = 1;
    private int level           = 1;
    private int experience      = 0;
    private int experienceValue = 0;

    private Gender gender = Gender.MALE;
    private Inventory inventory = new Inventory();
    private Weapon equippedWeapon = null;
    private Armor equippedArmor = null;
    private Position currentPosition;

    //////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////////////////////////

    public Character() {

    }

    //////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    //////////////////////////////////////////////////////////////

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
     * Returns the gender of the character.
     * @return character gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the character's gender to the given gender.
     * @param gender gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
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
     * Adds the money to the current money in the inventory. Use positive values for adding money
     * and negative values for spending money. Returns true if the amount of money to add or subtract
     * is valid, otherwise false.
     * @param moneyToAdd amount of money to add
     * @return true if the amount of money to add is valid, otherwise false
     */
    public boolean addMoney(int moneyToAdd) {
        int money = inventory.getMoney();
        if (money + moneyToAdd < 0) {
            return false;
        }

        money += moneyToAdd;
        inventory.setMoney(money);
        return true;
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

    public void attack(Character target) {
        // TODO
    }

    public void castSpell(Character target) {
        // TODO
    }

    /**
     * Removes the character and drops the character's inventory.
     * @return character's inventory
     */
    public Inventory die() {
        currentHP = 0;
        currentMana = 0;

        // TODO
        List<Item> oldItems = inventory.getItems();
        inventory.clear();
        return new Inventory(oldItems);
    }

    //////////////////////////////////////////////////////////////
    // PRIVATE METHODS
    //////////////////////////////////////////////////////////////

    private void levelUp() {
        ++level;
        // TODO
    }
}
