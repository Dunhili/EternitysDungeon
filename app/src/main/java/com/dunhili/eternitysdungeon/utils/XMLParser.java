package com.dunhili.eternitysdungeon.utils;

import com.dunhili.eternitysdungeon.utils.Logging;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.HashMap;

/**
 * Utility class that creates a list of items, weapons, armors, etc. from a given XML file or from the
 * default XML file. These methods should realistically only be called once in a static initializer, although
 * it is possible to alter the xml files afterward and then reread them. 
 * Created by Dunhili on 9/2/2015.
 */
public class XMLParser {
    private static final String TAG = "XMLParser";
    
    /**
     * Can't be instantiated.
     */
    private XMLParser() { }
    
    /**
     * Returns the list of armors using the default XML file 'armors.xml' in a hash map with the key as the name of
     * the item. 
     * @return list of armors in a hash map.
     */    
     public static HashMap<String, Armor> getListOfArmors() {
        return getListOfArmors("armors.xml");
    }

	/**
     * Returns the list of armors using the given XML file name in a hash map with the key as the name of
     * the item. 
     * @param xmlFileName name of the XML file with the weapons
     * @return list of armors in a hash map.
     */
    public static HashMap<String, Armor> getListOfArmors(String xmlFileName) {
        try {
            Document doc = getDocument(xmlFileName);
            if (doc == null) {
            	Logger.error("Could not find/open xml file.");
            	return null;
            }
            
            NodeList nList = doc.getElementsByTagName("armor");
            HashMap<String, Armor> armorMap = new HashMap<>();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    
                    String name = eElement.getAttribute("name");
                    int value = Integer.parseInt(eElement.getElementsByTagName("value").item(0).getTextContent());
                    int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                    ArmorType armorType = ArmorType.valueOf(eElement.getElementsByTagName("armorType").item(0).getTextContent().toUpperCase()); 
                    int physicalDefense = Integer.parseInt(eElement.getElementsByTagName("physDefense").item(0).getTextContent());
                    int magicDefense = Integer.parseInt(eElement.getElementsByTagName("magicDefense").item(0).getTextContent());
                    int speedPenalty = Integer.parseInt(eElement.getElementsByTagName("speedPenalty").item(0).getTextContent());
                    
                    Armor armor = new Armor(name, value, id, armorType, physicalDefense, magicDefense, speedPenalty);
                    armorMap.put(name, armor);
                }
            }
            return armorMap;
        } catch (Exception e) {
            Logging.error(TAG, e.getMessage(), e);
        }
        return null;
    }

	/**
     * Returns the list of weapons using the default XML file 'weapons.xml' in a hash map with the key as the name of
     * the item. 
     * @return list of weapons in a hash map.
     */
    public static HashMap<String, Weapon> getListOfWeapons() {
        return getListOfWeapons("weapons.xml");
    }

	/**
     * Returns the list of weapons using the given XML file in a hash map with the key as the name of
     * the item. 
     * @param xmlFileName name of the XML file with the weapons
     * @return list of weapons in a hash map.
     */
    public static HashMap<String, Weapon> getListOfWeapons(String xmlFileName) {
        try {
            Document doc = getDocument(xmlFileName);
            if (doc == null) {
            	Logger.error("Could not find/open xml file.");
            	return null;
            }
            
            NodeList nList = doc.getElementsByTagName("weapon");
            HashMap<String, Weapon> weaponMap = new HashMap<>();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
               
                    String name = eElement.getAttribute("name");
                    int value = Integer.parseInt(eElement.getElementsByTagName("value").item(0).getTextContent());
                    int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                    WeaponType weaponType = WeaponType.valueOf(eElement.getElementsByTagName("weaponType").item(0).getTextContent().toUpperCase()); 
                    int accuracy = Integer.parseInt(eElement.getElementsByTagName("accuracy").item(0).getTextContent());
                    int physicalAttack = Integer.parseInt(eElement.getElementsByTagName("physicalAttack").item(0).getTextContent());
                    int magicAttack = Integer.parseInt(eElement.getElementsByTagName("magicAttack").item(0).getTextContent());
                    int minRange = Integer.parseInt(eElement.getElementsByTagName("minRange").item(0).getTextContent());
                    int maxRange = Integer.parseInt(eElement.getElementsByTagName("maxRange").item(0).getTextContent());
                    int critModifier = Integer.parseInt(eElement.getElementsByTagName("critModifier").item(0).getTextContent());
                    int speedModifier = Integer.parseInt(eElement.getElementsByTagName("speedModifier").item(0).getTextContent());
                    float strengthScaling = Float.parseFloat(eElement.getElementsByTagName("strScaling").item(0).getTextContent());
                    float dexterityScaling = Float.parseFloat(eElement.getElementsByTagName("dexScaling").item(0).getTextContent());
                    float intelligenceScaling = Float.parseFloat(eElement.getElementsByTagName("intScaling").item(0).getTextContent());
                    float wisdomScaling = Float.parseFloat(eElement.getElementsByTagName("wisScaling").item(0).getTextContent());
                    
                    Weapon weapon = new Weapon(name, value, id, weaponType, accuracy, physicalAttack, magicAttack, minRange, maxRange, 
                    		critModifier, speedModifier, strengthScaling, dexterityScaling, intelligenceScaling, wisdomScaling);
                    weaponMap.put(name, weapon);
                }
            }
            return weaponMap;
        } catch (Exception e) {
            Logging.error(TAG, e.getMessage(), e);
        }
        return null;
    }
    
    /**
     * Opens the XML document with the given file name, or returns null if it can't be found or opened.
     * @param xmlFileName name of the XML file to open
     * @return XML document or null if not found
     */
    private static Document getDocument(String xmlFileName) {
		try {
	        File xmlFile = new File(xmlFileName);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(xmlFile);
	        doc.getDocumentElement().normalize();
	        return doc;
		} catch (ParserConfigurationException | IOException | SAXException e) {
			Logger.error(TAG, e.getMessage(), e);
		}
		return null;
    }
}
