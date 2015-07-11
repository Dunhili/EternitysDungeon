package com.dunhili.eternitysdungeon.item;

import android.media.Image;

import com.dunhili.eternitysdungeon.character.*;
import com.dunhili.eternitysdungeon.map.Tile;

/**
 * Represents an item that can be used or worn by the characters.
 * Created by Dunhili on 5/23/2015.
 */
public abstract class Item implements Comparable<Item>, Cloneable {
    //////////////////////////////////////////////////////////////
    // FIELDS
    //////////////////////////////////////////////////////////////
    private static final String TAG = "Item";

    private static final int MAX_ITEM_COUNT = 99;

    private String name = "";

    private int value     = 0;
    private int id        = 0;

    private Image portrait;

    protected boolean consumable = false;

    //////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////////////////////////

    /**
     * Creates an item with the given value and ID.
     * @param name name of the item
     * @param value item's value (in gp)
     * @param id item ID
     */
    public Item(String name, int value, int id) {
        this(name, value, id, true);
    }

    /**
     * Creates an item with the given value, ID, item count, and consumable flag.
     * @param name name of the item
     * @param value item's value (in gp)
     * @param id item ID
     * @param consumable flag for whether the item is removed on use
     */
    public Item(String name, int value, int id, boolean consumable) {
        this.name = name;
        this.value = value;
        this.id = id;
        this.consumable = consumable;
    }

    //////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    //////////////////////////////////////////////////////////////

    /**
     * Returns the item's value (in gp).
     * @return item's value
     */
    public int getValue() { return value; }

    /**
     * Returns the item's ID.
     * @return item's ID
     */
    public int getId() { return id; }

    /**
     * Returns the flag for whether the item is consumed on use.
     * @return consumable flag
     */
    public boolean isConsumable() { return consumable; }

    /**
     * Returns the name of the item.
     * @return item name
     */
    public String getName() { return name; }

    public Image getPortrait() { return portrait; }

    /**
     * Returns a positive number if the other ID is higher, a negative number if this ID is higher
     * than the other item's ID, or 0 if they're equal.
     * @param otherItem other item to compare to
     * @return int indicating if the other item is higher or lower
     */
    public int compareTo(Item otherItem) {
        if (otherItem == null) {
            return 1;
        }

        return otherItem.getId() - getId();
    }

    /**
     * Returns true if the items have equal IDs, otherwise returns false.
     * @param other other item to compare to
     * @return true if the items have equal IDs
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Item)) {
            return false;
        }

        Item otherItem = (Item) other;
        return otherItem.getId() == getId();
    }

    /**
     * Returns the hash code for this item. The hash code is merely the item's ID number.
     * @return hash code of the item, ie. the item's ID
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Creates a copy of the current item and returns it.
     * @return copy of the item
     */
    public abstract Item clone();

    /**
     * General use method that doesn't have some kind of target.
     */
    public void use() {
        // should be overridden by any item that needs it
    }

    /**
     * Use method that targets a single character.
     * @param target character to target with this item
     */
    public void use(com.dunhili.eternitysdungeon.character.Character target) {
        // should be overridden by any item that needs it
    }

    /**
     * Use method that targets an area.
     * @param targetArea area to target with this item
     */
    public void use(Tile targetArea) {
        // should be overridden by any item that needs it
    }

    /**
     * Returns a String representation of the Item.
     * @return String representation of the Item
     */
    @Override
    public String toString() {
        return getName() + " (" + getId() + ")";
    }
}
