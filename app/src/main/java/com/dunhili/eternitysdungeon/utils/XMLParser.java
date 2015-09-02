package com.dunhili.eternitysdungeon.utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.HashMap;

public class XMLParser {
    private static final String TAG = "XMLParser";
    
    public static HashMap<String, Armor> getListOfArmors() {
        return getListOfArmors("armors.xml");
    }

    public static HashMap<String, Armor> getListOfArmors(String xmlFileName) {
        try {
            Document doc = getDocument(xmlFileName);
            NodeList nList = doc.getElementsByTagName("armor");
            HashMap<String, Armor> armorMap = new HashMap<>();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    // TODO
                }
            }
            return armorMap;
        } catch (Exception e) {
            Logging.error(TAG, e.getMessage(), e);
        }
        return null;
    }

    public static HashMap<String, Weapon> getListOfWeapons() {
        return getListOfWeapons("weapons.xml");
    }

    public static HashMap<String, Weapon> getListOfWeapons(String xmlFileName) {
        try {
            Document doc = getDocument(xmlFileName);       
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
                    float strengthScaling = Float.parseFloat(eElement.getElementsByTagName("strengthScaling").item(0).getTextContent());
                    float dexterityScaling = Float.parseFloat(eElement.getElementsByTagName("dexterityScaling").item(0).getTextContent());
                    float intelligenceScaling = Float.parseFloat(eElement.getElementsByTagName("intelligenceScaling").item(0).getTextContent());
                    float wisdomScaling = Float.parseFloat(eElement.getElementsByTagName("wisdomScaling").item(0).getTextContent());
                    
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
    
    private static getDocument(String xmlFileName) {
        File xmlFile = new File(xmlFileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        return doc;
    }
}
