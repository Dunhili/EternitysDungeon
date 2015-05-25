package com.dunhili.eternitysdungeon.item;

/**
 * Created by Dunhili on 5/23/2015.
 */
public class Armor extends Item {
    private static final String TAG = "Armor";

    private int physicalDefense = 0;
    private int magicDefense = 0;

    public Armor(String name, int value, int id, int physicalDefense, int magicDefense) {
        super(name, value, id, 1);
        this.physicalDefense = physicalDefense;
        this.magicDefense = magicDefense;
    }

    public int getPhysicalDefense() {
        return physicalDefense;
    }


    public int getMagicDefense() {
        return magicDefense;
    }

    @Override
    public Item clone() {
        Item armor = new Armor(getName(), getValue(), getId(), getPhysicalDefense(), getMagicDefense());
        return armor;
    }

    @Override
    public void use() {
        return;
    }
}
