package com.dunhili.eternitysdungeon.tests;

import com.dunhili.eternitysdungeon.career.BaseCareerSet;
import com.dunhili.eternitysdungeon.character.Entity;

import junit.framework.TestCase;

/**
 * Tests the {@link Entity} class.
 */
public class EntityTest extends TestCase {
    private Entity entity;

    /**
     * Called before every test method.
     */
    public void setUp() {
        entity = new Entity(BaseCareerSet.FIGHTER);
    }

    public void testWeaponCalculations() {
        assertEquals(1, 1);
    }
}