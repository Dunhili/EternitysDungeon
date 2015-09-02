package com.dunhili.eternitysdungeon.item;

import com.dunhili.eternitysdungeon.character.Stat;

/**
 * Created by Dunhili on 5/23/2015.
 */
public class Weapon extends EquippableItem {
    private static final String TAG = "Weapon";

    private WeaponType weaponType = WeaponType.UNARMED;
    private int accuracy              = 100;
    private int physicalAttack        = 0;
    private int magicAttack           = 0;
    private int minRange              = 1;
    private int maxRange              = 1;
    private int critModifier          = 1;
    private int speedModifier         = 1;
    private float strengthScaling     = 0.0f;
    private float dexterityScaling    = 0.0f;
    private float intelligenceScaling = 0.0f;
    private float wisdomScaling       = 0.0f;
    
    public Weapon(String name, int value, int id, WeaponType weaponType, int accuracy, int physicalAttack, int magicAttack, 
    		int minRange, int maxRange, int critModifier, int speedModifier, 
    		float strengthScaling, float dexterityScaling, float intelligenceScaling, float wisdomScaling) {
    	super(name, value, id);
    	this.weaponType = weaponType;
    	this.accuracy = accuracy;
    	this.physicalAttack = physicalAttack;
    	this.magicAttack = magicAttack;
    	this.minRange = minRange;
    	this.maxRange = maxRange;
    	this.critModifier = critModifier;
    	this.speedModifier = speedModifier;
    	this.strengthScaling = strengthScaling;
    	this.dexterityScaling = dexterityScaling;
    	this.intelligenceScaling = intelligenceScaling;
    	this.wisdomScaling = wisdomScaling;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getAccuracy() { 
        return accuracy;
    }

    public int getPhysicalAttack() {
        return physicalAttack;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public int getCritModifier() {
        return critModifier;
    }

    public int getSpeedModifier() {
        return speedModifier;
    }

    public float getStrengthScaling() {
        return strengthScaling;
    }

    public float getDexterityScaling() {
        return dexterityScaling;
    }

    public float getIntelligenceScaling() {
        return intelligenceScaling;
    }

    public float getWisdomScaling() {
        return wisdomScaling;
    }
    
    @Override
    public Item clone() {
        Item weapon = new Weapon(getName(), getValue(), getId(), getWeaponType(), getAccuracy(), getPhysicalAttack(),
            getMagicAttack(), getMinRange(), getMaxRange(), getCritModifier(), getSpeedModifier(), getStrengthScaling(),
            getDexterityScaling(), getIntelligenceScaling(), getWisdomScaling());
        return weapon;
    }
}
