package com.dunhili.eternitysdungeon.tests;

import com.dunhili.eternitysdungeon.character.Attributes;

import junit.framework.TestCase;

/**
 * Created by Dunhili on 5/25/2015.
 */
public class AttributesTest extends TestCase {
    private Attributes attributes;
    private int[] initialStats = {10, 3, 10, 8, 6, 4, 5, 2};
    private int[] growthRates = {100, 250, 60, 40, 20, 20, 40, 20};

    /**
     * Called before every test method.
     */
    public void setUp() {
        attributes = new Attributes(initialStats, growthRates);
    }

    /**
     * Tests the {@link Attributes#Attributes(int[], int[])} constructor.
     */
    public void testConstructor() {
        assertEquals(initialStats[0], attributes.getMaxHP().getValue());
        assertEquals(initialStats[1], attributes.getMaxMana().getValue());
        assertEquals(initialStats[2], attributes.getStrength().getValue());
        assertEquals(initialStats[3], attributes.getDexterity().getValue());
        assertEquals(initialStats[4], attributes.getIntelligence().getValue());
        assertEquals(initialStats[5], attributes.getWillpower().getValue());
        assertEquals(initialStats[6], attributes.getDefense().getValue());
        assertEquals(initialStats[7], attributes.getResistance().getValue());

        assertEquals(attributes.getMaxHP().getValue(), attributes.getCurrentHP());
        assertEquals(attributes.getMaxMana().getValue(), attributes.getCurrentMana());

        assertEquals(growthRates[0], attributes.getMaxHP().getGrowthRate());
        assertEquals(growthRates[1], attributes.getMaxMana().getGrowthRate());
        assertEquals(growthRates[2], attributes.getStrength().getGrowthRate());
        assertEquals(growthRates[3], attributes.getDexterity().getGrowthRate());
        assertEquals(growthRates[4], attributes.getIntelligence().getGrowthRate());
        assertEquals(growthRates[5], attributes.getWillpower().getGrowthRate());
        assertEquals(growthRates[6], attributes.getDefense().getGrowthRate());
        assertEquals(growthRates[7], attributes.getResistance().getGrowthRate());
    }

    /**
     * Tests the {@link Attributes#addExp(int)} method.
     */
    public void testAddExperience() {
        assertEquals(0, attributes.getExperience());
        attributes.addExp(-10);
        assertEquals(0, attributes.getExperience());

        attributes.addExp(10);
        assertEquals(10, attributes.getExperience());

        attributes.addExp(10);
        assertEquals(20, attributes.getExperience());


        assertEquals(1, attributes.getLevel());
        attributes.addExp(80);
        assertEquals(0, attributes.getExperience());
        assertEquals(2, attributes.getLevel());


        attributes.addExp(300);
        assertEquals(5, attributes.getLevel());
        assertEquals(0, attributes.getExperience());
    }

    /**
     * Tests the {@link Attributes#addHP(int)} and {@link Attributes#addMana(int)} methods.
     */
    public void testAddHPAndMana() {
        attributes.getMaxHP().setValue(20);
        attributes.getMaxMana().setValue(20);

        assertEquals(10, attributes.getCurrentHP());
        attributes.addHP(5);
        assertEquals(15, attributes.getCurrentHP());
        attributes.addHP(10);
        assertEquals(20, attributes.getCurrentHP());
        attributes.addHP(-25);
        assertEquals(0, attributes.getCurrentHP());

        assertEquals(3, attributes.getCurrentMana());
        attributes.addMana(5);
        assertEquals(8, attributes.getCurrentMana());
        attributes.addMana(20);
        assertEquals(20, attributes.getCurrentMana());
        attributes.addMana(-25);
        assertEquals(0, attributes.getCurrentMana());
    }
}
