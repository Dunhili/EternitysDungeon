package com.dunhili.eternitysdungeon.item;

import com.dunhili.eternitysdungeon.map.Tile;

/**
 * Represents an item that can be consumed by the character to cause some kind of effect.
 * Created by Dunhili on 7/10/2015.
 */
public class Consumable extends Item {
    public Consumable(String name, int value, int id) {
        super (name, value, id, true);
    }

    /**
     * Creates and returns a copy of this consumable item.
     * @return
     */
    @Override
    public Item clone() {
        Consumable clone = new Consumable(getName(), getValue(), getId());
        return clone;
    }
}
