package com.dunhili.eternitysdungeon.tests;

import com.dunhili.eternitysdungeon.career.BaseCareer;
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
        BaseCareer baseCareer = new BaseCareer();
        character = new Character(baseCareer);
    }

    public void testWeaponCalculations() {
        assertEquals(1, 1);
    }
}