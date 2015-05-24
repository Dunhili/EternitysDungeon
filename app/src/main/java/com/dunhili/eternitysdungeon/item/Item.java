package com.dunhili.eternitysdungeon.item;

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
    private int itemCount = 1;

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
        this(name, value, id, 1);
    }

    /**
     * Creates an item with the given value, ID, and item count.
     * @param name name of the item
     * @param value item's value (in gp)
     * @param id item ID
     * @param itemCount count of the item
     */
    public Item(String name, int value, int id, int itemCount) {
        this(name, value, id, itemCount, false);
    }

    /**
     * Creates an item with the given value, ID, item count, and consumable flag.
     * @param name name of the item
     * @param value item's value (in gp)
     * @param id item ID
     * @param itemCount count of the item
     * @param consumable flag for whether the item is removed on use
     */
    public Item(String name, int value, int id, int itemCount, boolean consumable) {
        this.name = name;
        this.value = value;
        this.id = id;
        this.itemCount = itemCount;
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
    public int getId() {
        return id;
    }

    /**
     * Returns the item count.
     * @return item count
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * Sets the item count to the given value
     * @param itemCount number of items
     */
    public void setItemCount(int itemCount) {
        if (itemCount >= 0) {
            this.itemCount = itemCount;
        }
    }

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

    /**
     * Adds the count to the item count.
     * @param count amount of items to add
     */
    public void addCount(int count) {
        itemCount += count;
        if (itemCount > MAX_ITEM_COUNT) {
            itemCount = MAX_ITEM_COUNT;
        } else if (itemCount < 0) {
            itemCount = 0;
        }
    }

    /**
     * Increments the item count.
     */
    public void increaseCount() {
        if (itemCount < MAX_ITEM_COUNT) {
            ++itemCount;
        }
    }

    /**
     * Decrements the item count.
     */
    public void decreaseCount() {
        if (itemCount > 0) {
            --itemCount;
        }
    }

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
     * Creates a copy of the current item and returns it.
     * @return copy of the item
     */
    public abstract Item clone();

    public abstract void use();

    /**
     * Returns a String representation of the Item.
     * @return String reprensetation of the Item
     */
    @Override
    public String toString() {
        return getName() + " (" + getId() + ") - " + getItemCount();
    }
}
