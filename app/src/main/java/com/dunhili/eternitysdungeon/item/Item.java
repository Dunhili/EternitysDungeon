package com.dunhili.eternitysdungeon.item;

/**
 *
 * Created by Dunhili on 5/23/2015.
 */
public abstract class Item {
    private int value = 0;

    public Item(int value) {
        setValue(value);
    }

    /**
     * Returns the item's value (in gp).
     * @return item's value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the item's value (in gp) to the given value.
     * @param value value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
}
