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

    /**
     * Tests the {@link Character#addExp(int)} method.
     */
    public void testAddExperience() {
        assertEquals(0, character.getExperience());
        character.addExp(-10);
        assertEquals(0, character.getExperience());

        character.addExp(10);
        assertEquals(10, character.getExperience());

        character.addExp(10);
        assertEquals(20, character.getExperience());


        assertEquals(1, character.getLevel());
        character.addExp(80);
        assertEquals(0, character.getExperience());
        assertEquals(2, character.getLevel());


        character.addExp(300);
        assertEquals(5, character.getLevel());
        assertEquals(0, character.getExperience());
    }

    /**
     * Tests the {@link Character#addHP(int)} and {@link Character#addMana(int)} methods.
     */
    public void testAddHPAndMana() {
        character.setMaxHP(10);
        character.setMaxMana(10);

        assertEquals(1, character.getCurrentHP());
        character.addHP(5);
        assertEquals(6, character.getCurrentHP());
        character.addHP(10);
        assertEquals(10, character.getCurrentHP());
        character.addHP(-15);
        assertEquals(0, character.getCurrentHP());

        assertEquals(1, character.getCurrentMana());
        character.addMana(5);
        assertEquals(6, character.getCurrentMana());
        character.addMana(10);
        assertEquals(10, character.getCurrentMana());
        character.addMana(-15);
        assertEquals(0, character.getCurrentMana());
    }
}