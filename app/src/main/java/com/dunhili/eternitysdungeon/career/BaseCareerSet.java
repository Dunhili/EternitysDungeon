package com.dunhili.eternitysdungeon.career;

import com.dunhili.eternitysdungeon.ability.CareerAbilities;

/**
 * Created by Dunhili on 6/6/2015.
 */
public class BaseCareerSet {
    public static final BaseCareer FIGHTER = new
            BaseCareer("Fighter", new int[]{24, 5, 8, 6, 2, 3, 5, 2}, new int[]{80, 10, 70, 50, 15, 20, 40, 20}, CareerAbilities.FIGHTER_ABILITIES);

    public static final BaseCareer PRIEST = new
            BaseCareer("Priest", new int[]{14, 12, 3, 5, 6, 8, 2, 7}, new int[]{45, 80, 20, 35, 30, 65, 15, 60}, CareerAbilities.PRIEST_ABILITIES);

    public static final BaseCareer ARCHER = new
            BaseCareer("Archer", new int[]{18, 8, 5, 8, 4, 4, 3, 4}, new int[]{55, 40, 30, 65, 25, 40, 35, 30}, CareerAbilities.ARCHER_ABILITIES);

    public static final BaseCareer THIEF = new
            BaseCareer("Thief", new int[]{16, 7, 5, 9, 5, 4, 4, 3}, new int[]{60, 30, 45, 70, 30, 20, 30, 25}, CareerAbilities.THIEF_ABILITIES);

    public static final BaseCareer MAGE = new
            BaseCareer("Mage", new int[]{15, 14, 3, 5, 9, 5, 2, 6}, new int[]{50, 120, 15, 45, 70, 40, 20, 45}, CareerAbilities.MAGE_ABILITIES);

    public static final BaseCareer SQUIRE = new
            BaseCareer("Squire", new int[]{24, 8, 7, 7, 3, 4, 7, 5}, new int[]{75, 40, 50, 45, 20, 25, 60, 30}, CareerAbilities.SQUIRE_ABILITIES);
}
