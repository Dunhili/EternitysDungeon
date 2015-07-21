package com.dunhili.eternitysdungeon.buff;

/**
 * Represents the buffs and debuffs that can be applied to an {@link com.dunhili.eternitysdungeon.character.Entity}.
 * These effects range from stunning or poisoning a target to boosting their defense.
 * Created by Dunhili on 7/21/2015.
 */
public class Buff {
    private StatusCondition condition;
    private String name         = "";
    private int duration        = 1;
    private int potency         = 1;
    private boolean dispellable = true;
    private boolean isBuff      = true;
    private boolean isDebuff    = false;

    /**
     * Creates a buff with the given {@link StatusCondition} and values.
     * @param condition Status condition to set for this buff
     * @param name name of the buff
     * @param duration number of turns this buff lasts
     * @param potency how strong the buff is
     * @param dispellable flag for whether this buff can be dispelled
     * @param isBuff flag for whether this is a buff (positive for the target)
     * @param isDebuff flag for whether this is a debuff (negative for the target)
     */
    public Buff(StatusCondition condition, String name, int duration, int potency,
                boolean dispellable, boolean isBuff, boolean isDebuff) {
        this.condition = condition;
        this.name = name;
        this.duration = duration;
        this.potency = potency;
        this.dispellable = dispellable;
        this.isBuff = isBuff;
        this.isDebuff = isDebuff;
    }

    /**
     * Returns the status condition enumerated type.
     * @return status condition
     */
    public StatusCondition getCondition() {
        return condition;
    }

    /**
     * Returns the name of the buff.
     * @return buff name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of turns this buff lasts.
     * @return duration of buff
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Returns the strength of the buff, ex how much this adds to a stat or how much damage a
     * target takes from bleeds or poisons.
     * @return strength of the buff
     */
    public int getPotency() {
        return potency;
    }

    /**
     * Returns the flag for whether this buff can be dispelled.
     * @return isDispellable flag
     */
    public boolean isDispellable() {
        return dispellable;
    }

    /**
     * Returns the flag for whether this is a buff, ie positive for the target.
     * @return isBuff flag
     */
    public boolean isBuff() {
        return isBuff;
    }

    /**
     * Returns the flag for whether this is a debuff, ie negative for the target.
     * @return isDebuff flag
     */
    public boolean isDebuff() {
        return isDebuff;
    }
}
