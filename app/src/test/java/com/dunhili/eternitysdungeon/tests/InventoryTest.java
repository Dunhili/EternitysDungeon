package com.dunhili.eternitysdungeon.tests;

import android.util.Log;

import com.dunhili.eternitysdungeon.item.Armor;
import com.dunhili.eternitysdungeon.item.Inventory;
import com.dunhili.eternitysdungeon.item.Item;
import com.dunhili.eternitysdungeon.item.Weapon;

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
        Armor armor1 = new Armor("testArmor", 10, 1, 1, 1);
        inventory.addItem(armor1);
        assertEquals(1, inventory.getItem(armor1).getItemCount());
        assertEquals(armor1, inventory.getItem(armor1));
        assertEquals(armor1, inventory.getItemByID(armor1.getId()));

        inventory.addItem(armor1);
        assertEquals(2, inventory.getItem(armor1).getItemCount());

        Weapon weapon1 = new Weapon("testWeapon", 10, 2, 1, 1);
        inventory.addItem(weapon1);
        assertEquals(1, inventory.getItem(weapon1).getItemCount());
        assertEquals(weapon1, inventory.getItem(weapon1));
        assertEquals(weapon1, inventory.getItemByID(weapon1.getId()));

        assertTrue(inventory.removeItem(armor1, 1));
        assertEquals(1, inventory.getItem(armor1).getItemCount());
        assertTrue(inventory.removeItem(armor1));
        assertEquals(null, inventory.getItem(armor1));
    }
}
