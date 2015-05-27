package com.dunhili.eternitysdungeon.item;

/**
 * Created by Dunhili on 5/26/2015.
 */
public class WeaponAttributes {
    private static final String TAG = "WeaponAttributes";

    private static final int NUM_OFFENSIVE_STATS = 4;
    private static final int STRENGTH_SCALING = 0;
    private static final int DEXTERITY_SCALING = 1;
    private static final int INTELLIGENCE_SCALING = 2;
    private static final int WILLPOWER_SCALING = 3;

    private WeaponType weaponType = WeaponType.UNARMED;
    private int physicalAttack = 0;
    private int magicAttack = 0;
    private int minRange       = 1;
    private int maxRange       = 1;
    private int critModifier   = 1;
    private int speedModifier  = 1;
    private float[] weaponScaling = new float[NUM_OFFENSIVE_STATS];

    public WeaponAttributes(WeaponType weaponType, int physicalAttack, int magicAttack, int minRange,
                            int maxRange, int critModifier, int speedModifier, float[] weaponScaling) {
        this.weaponType = weaponType;
        this.physicalAttack = physicalAttack;
        this.magicAttack = magicAttack;
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.critModifier = critModifier;
        this.speedModifier = speedModifier;
        System.arraycopy(weaponScaling, 0, this.weaponScaling, 0, weaponScaling.length);
    }

    public WeaponType getWeaponType() { return weaponType; }

    public int getPhysicalAttack() { return physicalAttack; }

    public int getMagicAttack() { return magicAttack; }

    public int getMinRange() { return minRange; }

    public int getMaxRange() { return maxRange; }

    public int getCritModifier() { return critModifier; }

    public int getSpeedModifier() {
        return speedModifier;
    }

    public float getStrengthScaling() { return weaponScaling[STRENGTH_SCALING]; }

    public float getDexterityScaling() { return weaponScaling[DEXTERITY_SCALING]; }

    public float getIntelligenceScaling() { return weaponScaling[INTELLIGENCE_SCALING]; }

    public float getWillpowerScaling() { return weaponScaling[WILLPOWER_SCALING]; }
}
