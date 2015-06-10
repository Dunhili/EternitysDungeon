package com.dunhili.eternitysdungeon.career;

import com.dunhili.eternitysdungeon.ability.Ability;
import com.dunhili.eternitysdungeon.character.StatType;

/**
 * Created by Dunhili on 5/26/2015.
 */
public class AdvancedCareer extends Career {
    private int[] promotionBonus = new int[StatType.values().length];

    public AdvancedCareer(String name, int[] growthRates, int[] statCaps, int[] promotionBonus, Ability[] abilities) {
        super(name, growthRates, statCaps, abilities);
        for (int i = 0; i < StatType.values().length; i++) {
            this.promotionBonus[i] = promotionBonus[i];
        }
    }

    public int[] getPromotionBonus() {
        return promotionBonus;
    }
}
