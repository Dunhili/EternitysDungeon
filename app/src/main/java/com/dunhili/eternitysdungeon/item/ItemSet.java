package com.dunhili.eternitysdungeon.item;

import com.dunhili.eternitysdungeon.character.*;

/**
 * Created by Dunhili on 7/10/2015.
 */
public class ItemSet {
    // Item IDs 0-99 are consumable items
    public static final Consumable LIGHT_POTION_OF_HEALING = new Consumable("Light Potion of Healing", 2, 0) {
        @Override
        public void use(com.dunhili.eternitysdungeon.character.Character target) {
            target.heal(10);
        }
    };
    public static final Consumable POTION_OF_HEALING = new Consumable("Potion of Healing", 8, 1) {
        @Override
        public void use(com.dunhili.eternitysdungeon.character.Character target) {
            target.heal(20);
        }
    };
    public static final Consumable HEAVY_POTION_OF_HEALING = new Consumable("Heavy Potion of Healing", 18, 2) {
        @Override
        public void use(com.dunhili.eternitysdungeon.character.Character target) {
            target.heal(40);
        }
    };

    // Item IDs 100-199 are weapons
    public static final Weapon BRONZE_DAGGER = new Weapon(new WeaponAttributes(WeaponType.DAGGER, 2, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Bronze Dagger", 2, 100);
    public static final Weapon BRONZE_SWORD = new Weapon(new WeaponAttributes(WeaponType.SWORD, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Bronze Sword", 5, 101);
    public static final Weapon BRONZE_AXE = new Weapon(new WeaponAttributes(WeaponType.AXE, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Bronze Axe", 6, 102);
    public static final Weapon BRONZE_MACE = new Weapon(new WeaponAttributes(WeaponType.MACE, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Bronze Mace", 4, 103);
    public static final Weapon BRONZE_LANCE = new Weapon(new WeaponAttributes(WeaponType.LANCE, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Bronze Lance", 4, 104);
    public static final Weapon BRONZE_HANDAXE = new Weapon(new WeaponAttributes(WeaponType.HANDAXE, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Bronze Handaxe", 3, 105);
    public static final Weapon BRONZE_JAVELIN = new Weapon(new WeaponAttributes(WeaponType.JAVELIN, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Bronze Javelin", 3, 106);
    public static final Weapon BRONZE_BOW = new Weapon(new WeaponAttributes(WeaponType.BOW, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Bronze Bow", 5, 107);
    public static final Weapon BRONZE_CROSSBOW = new Weapon(new WeaponAttributes(WeaponType.CROSSBOW, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Bronze Crossbow", 7, 108);

    public static final Weapon IRON_DAGGER = new Weapon(new WeaponAttributes(WeaponType.DAGGER, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Iron Dagger", 5, 110);
    public static final Weapon IRON_SWORD = new Weapon(new WeaponAttributes(WeaponType.SWORD, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Iron Sword", 9, 111);
    public static final Weapon IRON_AXE = new Weapon(new WeaponAttributes(WeaponType.AXE, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Iron Axe", 10, 112);
    public static final Weapon IRON_MACE = new Weapon(new WeaponAttributes(WeaponType.MACE, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Iron Mace", 8, 113);
    public static final Weapon IRON_LANCE = new Weapon(new WeaponAttributes(WeaponType.LANCE, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Iron Lance", 8, 114);
    public static final Weapon IRON_HANDAXE = new Weapon(new WeaponAttributes(WeaponType.HANDAXE, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Iron Handaxe", 7, 115);
    public static final Weapon IRON_JAVELIN = new Weapon(new WeaponAttributes(WeaponType.JAVELIN, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Iron Javelin", 7, 116);
    public static final Weapon IRON_BOW = new Weapon(new WeaponAttributes(WeaponType.BOW, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Iron Bow", 12, 117);
    public static final Weapon IRON_CROSSBOW = new Weapon(new WeaponAttributes(WeaponType.CROSSBOW, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Iron Crossbow", 15, 118);

    public static final Weapon STEEL_DAGGER = new Weapon(new WeaponAttributes(WeaponType.DAGGER, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Steel Dagger", 8, 120);
    public static final Weapon STEEL_SWORD = new Weapon(new WeaponAttributes(WeaponType.SWORD, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Steel Sword", 14, 121);
    public static final Weapon STEEL_AXE = new Weapon(new WeaponAttributes(WeaponType.AXE, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Steel Axe", 16, 122);
    public static final Weapon STEEL_MACE = new Weapon(new WeaponAttributes(WeaponType.MACE, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Steel Mace", 12, 123);
    public static final Weapon STEEL_LANCE = new Weapon(new WeaponAttributes(WeaponType.LANCE, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Steel Lance", 12, 124);
    public static final Weapon STEEL_HANDAXE = new Weapon(new WeaponAttributes(WeaponType.HANDAXE, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Steel Handaxe", 11, 125);
    public static final Weapon STEEL_JAVELIN = new Weapon(new WeaponAttributes(WeaponType.JAVELIN, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Steel Javelin", 11, 126);
    public static final Weapon STEEL_BOW = new Weapon(new WeaponAttributes(WeaponType.BOW, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Steel Bow", 16, 127);
    public static final Weapon STEEL_CROSSBOW = new Weapon(new WeaponAttributes(WeaponType.CROSSBOW, 4, 0, 1, 1, 1, 1, 1.0f, 0.0f, 0.0f, 0.0f), "Steel Crossbow", 20, 128);

    // Item IDs 200-299 is armor
}
