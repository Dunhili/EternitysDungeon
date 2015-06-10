package com.dunhili.eternitysdungeon.career;

import com.dunhili.eternitysdungeon.ability.CareerAbilities;

/**
 * Created by Dunhili on 6/9/2015.
 */
public class AdvancedCareerSet {
    public static final AdvancedCareer WARRIOR = new AdvancedCareer("Warrior", new int[]{80, 10, 70, 55, 15, 25, 45, 25},
            new int[]{60, 30, 32, 25, 20, 22, 24, 21}, new int[]{4, 1, 3, 2, 0, 1, 2, 1}, CareerAbilities.WARRIOR_ABILITIES);

    public static final AdvancedCareer BARBARIAN = new AdvancedCareer("Barbarian", new int[]{100, 10, 80, 50, 10, 20, 40, 20},
            new int[]{65, 30, 32, 25, 20, 22, 24, 21}, new int[]{5, 1, 4, 2, 0, 1, 1, 0}, CareerAbilities.BARBARIAN_ABILITIES);

    public static final AdvancedCareer BISHOP = new AdvancedCareer("Bishop", new int[]{45, 90, 20, 35, 30, 65, 15, 80},
            new int[]{50, 80, 22, 24, 20, 32, 21, 30}, new int[]{2, 3, 1, 1, 2, 3, 1, 3}, CareerAbilities.BISHOP_ABILITIES);

    public static final AdvancedCareer CLERIC = new AdvancedCareer("Cleric", new int[]{55, 80, 35, 35, 30, 55, 25, 60},
            new int[]{55, 60, 26, 25, 20, 28, 24, 27}, new int[]{3, 2, 2, 2, 0, 2, 2, 1}, CareerAbilities.CLERIC_ABILITIES);

    public static final AdvancedCareer MARKSMAN = new AdvancedCareer("Marksman", new int[]{55, 40, 40, 60, 25, 40, 35, 30},
            new int[]{55, 40, 24, 32, 20, 21, 22, 23}, new int[]{3, 2, 2, 3, 0, 1, 2, 1}, CareerAbilities.MARKSMAN_ABILITIES);

    public static final AdvancedCareer RANGER = new AdvancedCareer("Ranger", new int[]{60, 45, 30, 45, 25, 45, 35, 30},
            new int[]{55, 50, 22, 30, 20, 24, 24, 24}, new int[]{2, 3, 1, 3, 0, 2, 1, 2}, CareerAbilities.RANGER_ABILITIES);

    public static final AdvancedCareer MERCENARY = new AdvancedCareer("Mercenary", new int[]{65, 40, 50, 55, 30, 20, 35, 25},
            new int[]{55, 60, 26, 28, 20, 20, 23, 21}, new int[]{4, 1, 2, 3, 1, 0, 2, 1}, CareerAbilities.MERCENARY_ABILITIES);

    public static final AdvancedCareer SCOUNDREL = new AdvancedCareer("Scoundrel", new int[]{60, 30, 45, 70, 35, 25, 30, 30},
            new int[]{55, 60, 23, 32, 21, 22, 21, 22}, new int[]{3, 2, 2, 3, 2, 0, 1, 1}, CareerAbilities.SCOUNDREL_ABILITIES);

    public static final AdvancedCareer SAGE = new AdvancedCareer("Sage", new int[]{50, 140, 20, 40, 65, 40, 20, 45},
            new int[]{50, 80, 22, 24, 32, 22, 21, 26}, new int[]{2, 4, 1, 1, 3, 1, 0, 1}, CareerAbilities.SAGE_ABILITIES);

    public static final AdvancedCareer SUMMONER = new AdvancedCareer("Summoner", new int[]{50, 125, 15, 35, 65, 40, 25, 50},
            new int[]{50, 80, 21, 23, 30, 22, 23, 28}, new int[]{2, 4, 1, 1, 3, 1, 0, 1}, CareerAbilities.SUMMONER_ABILITIES);

    public static final AdvancedCareer TEMPLAR = new AdvancedCareer("Templar", new int[]{65, 45, 50, 40, 20, 35, 45, 30},
            new int[]{60, 60, 28, 24, 22, 26, 24, 23}, new int[]{3, 2, 3, 1, 0, 1, 1, 1}, CareerAbilities.TEMPLAR_ABILITIES);

    public static final AdvancedCareer KNIGHT = new AdvancedCareer("Knight", new int[]{75, 40, 45, 35, 20, 25, 55, 40},
            new int[]{60, 40, 26, 24, 22, 22, 27, 25}, new int[]{4, 1, 2, 1, 0, 1, 2, 1}, CareerAbilities.KNIGHT_ABILITIES);
}
