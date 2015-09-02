package com.dunhili.eternitysdungeon.tests;

import com.dunhili.eternitysdungeon.utils.XMLParser;
import junit.framework.TestCase;

public class XMLParserTest extends TestCase {
    public void testGetAllArmors() {
        assertNotNull(XMLParser.getListOfArmors());
    }

    public void testGetAllWeapons() {
        assertNotNull(XMLParser.getListOfWeapons());
    }
}