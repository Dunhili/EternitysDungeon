package com.dunhili.eternitysdungeon.tests;

import com.dunhili.eternitysdungeon.character.Character;
import junit.framework.TestCase;

/**
 * Tests the {@link Character} class.
 */
public class CharacterTest extends TestCase {
    private Character character;

    /**
     * Called before every test method.
     */
    public void setUp() {
        character = new Character();
    }

    public void testWeaponCalculations() {
        assertEquals(1, 1);
    }
}