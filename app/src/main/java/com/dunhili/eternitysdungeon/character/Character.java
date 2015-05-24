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

    private Attributes attributes;
    private Gender gender = Gender.MALE;
    private Inventory inventory = new Inventory();
    private Weapon equippedWeapon = null;
    private Armor equippedArmor = null;
    private Item equppedOffHand = null;
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

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
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

    public int getPhysicalAttackDamage() {
        return equippedWeapon.getPhysicalAttack();
    }

    public int getSpellAttackDamage() {
        return equippedWeapon.getSpellAttack();
    }

    public int getPhysicalDefense() {
        return equippedArmor.getPhysicalDefense() + attributes.getDefense();
    }

    public int getSpellDefense() {
        return equippedArmor.getSpellDefense() + attributes.getResistance();
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
        attributes.setCurrentHP(0);
        attributes.setCurrentMana(0);

        // TODO
        List<Item> oldItems = inventory.getItems();
        inventory.clear();
        return new Inventory(oldItems);
    }
}
