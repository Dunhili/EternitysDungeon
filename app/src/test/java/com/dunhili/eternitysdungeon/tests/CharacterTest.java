package com.dunhili.eternitysdungeon.tests;

import com.dunhili.eternitysdungeon.character.Character;
import junit.framework.TestCase;

public class CharacterTest extends TestCase {
    private Character character;

    public void testAddExperience() {
        character = new Character();
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
}