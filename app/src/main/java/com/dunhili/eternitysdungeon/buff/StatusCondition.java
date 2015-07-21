package com.dunhili.eternitysdungeon.buff;

/**
 * Represents the different types of status conditions that can affect a target.
 * Created by Dunhili on 7/21/2015.
 */
public enum StatusCondition {
    /** Adjusts the HP of the target. */
    ADJUST_HP,

    /** Adjusts the Mana of the target. */
    ADJUST_MANA,

    /** Adjusts the Strength of the target. */
    ADJUST_STRENGTH,

    /** Adjusts the Dexterity of the target. */
    ADJUST_DEXTERITY,

    /** Adjusts the Intelligence of the target. */
    ADJUST_INTELLIGENCE,

    /** Adjusts the Wisdom of the target. */
    ADJUST_WISDOM,

    /** Adjusts the Defense of the target. */
    ADJUST_DEFENSE,

    /** Adjusts the Resistance of the target. */
    ADJUST_RESISTANCE,

    /** Adjusts the Attack Damage of the target. */
    ADJUST_ATTACK_DAMAGE,

    /** Adjusts the Spell Damage of the target. */
    ADJUST_SPELL_DAMAGE,

    /** Target takes damage over time. */
    BLEED,

    /** Target takes damage over time. */
    POISON,

    /** Target can't act, damage to this target interrupts the effect. */
    SLEEP,

    /** Target can't act. */
    STUN,

    /** Target will perform random actions (ex move, attack, cast, do nothing, etc).*/
    CONFUSE,

    /** Target will attack nearest target, gain a bonus to Strength. */
    BERSERK,

    /** Target can't move, takes a penalty to dodging. */
    IMMOBILIE,

    /** Target can't cast any spells. */
    SILENCE,

    /** Target's vision is reduced, chance to hit is greatly reduced. */
    BLIND,

    /** Target can't act, defense is greatly increased. */
    STONE
}
