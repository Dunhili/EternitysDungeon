package com.dunhili.eternitysdungeon.tests;

import android.util.Log;

import com.dunhili.eternitysdungeon.item.Armor;
import com.dunhili.eternitysdungeon.item.ArmorType;
import com.dunhili.eternitysdungeon.item.Inventory;
import com.dunhili.eternitysdungeon.item.Item;
import com.dunhili.eternitysdungeon.item.Weapon;
import com.dunhili.eternitysdungeon.item.WeaponType;

import junit.framework.TestCase;

/**
 * Tests the {@link Inventory} class.
 * Created by Dunhili on 5/23/2015.
 */
public class InventoryTest extends TestCase {
    private Inventory inventory;

    /**
     * Called before every test method.
     */
    public void setUp() {
        inventory = new Inventory();
    }

    /**
     * Tests the {@link Inventory#removeItem(Item)} and {@link Inventory#addItem(Item)} methods.
     */
    public void testAddAndRemoveItems() {
        Armor armor1 = new Armor("testArmor", 10, 1, ArmorType.LIGHT, 1, 1, 0);
        inventory.addItem(armor1);
        assertEquals(1, inventory.getItemCount(armor1));

        inventory.addItem(armor1);
        assertEquals(2, inventory.getItemCount(armor1));

        Weapon weapon1 = new Weapon("testWeapon", 10, 2, WeaponType.DAGGER, 100, 1, 1, 1, 1, 1, 1, 1.5f, 1.0f, 0.0f, 0.0f);
        inventory.addItem(weapon1);

        assertTrue(inventory.removeItem(armor1, 1));
        assertEquals(1, inventory.getItemCount(armor1));
        assertTrue(inventory.removeItem(armor1));
        assertEquals(0, inventory.getItemCount(armor1));
    }
}
