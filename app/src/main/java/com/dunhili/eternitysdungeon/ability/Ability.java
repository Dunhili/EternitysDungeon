package com.dunhili.eternitysdungeon.ability;

import com.dunhili.eternitysdungeon.character.Entity;
import com.dunhili.eternitysdungeon.map.Tile;

import java.util.List;

/**
 * Outline for what each ability will look like. Each ability will have a cost associated with it (health and/or mana) 
 * unless it is a passive ability. Abilities will also have a range of [minRange, maxRange] that they can cast/used at.
 * The cast time for an ability is how many turns the unit will have to spend casting it before the effect goes off. Finally,
 * the flags for targetting enemies or allies will dictate whether abilities that have a target can target an enemy or
 * ally unit.
 * Created by Dunhili on 5/27/2015.
 */
public class Ability {
    //////////////////////////////////////////////////////////////
    // FIELDS
    //////////////////////////////////////////////////////////////

    private String name             = "";
    private int healthCost          = 0;
    private int manaCost            = 0;
    private int castTime            = 0;
    private int minRange            = 1;
    private int maxRange            = 1;
    private int maxNumberTargets    = 1;
    private int cooldown            = 0;
    private int turnsOnCooldown     = 0;
    private boolean targetEnemies   = true;
    private boolean targetAllies    = true;
    private boolean active          = true;
    private AbilityType abilityType = AbilityType.SINGLE;

    //////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////////////////////////

    // TODO add constructors
    public Ability(String name) {

    }

    //////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    //////////////////////////////////////////////////////////////

    /**
     * Returns the name of the ability.
     * @return ability name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the health cost of the ability.
     * @return health cost
     */
    public int getHealthCost() {
        return healthCost;
    }

    /**
     * Returns the mana cost of the ability.
     * @return mana cost
     */
    public int getManaCost() {
        return manaCost;
    }

    /**
     * Returns the casting time of the ability.
     * @return cast time
     */
    public int getCastTime() {
        return castTime;
    }

    /**
     * Returns the minimum range needed for the ability.
     * @return minimum range
     */
    public int getMinRange() {
        return minRange;
    }

    /**
     * Returns the maximum range that the ability can go.
     * @return maximum range
     */
    public int getMaxRange() {
        return maxRange;
    }

    /**
     * Returns the maximum number of targets that this ability can affect.
     * @return max number of targets
     */
    public int getMaxNumberTargets() {
        return maxNumberTargets;
    }

    /**
     * Returns the number of turns the user must wait after using this ability.
     * @return cooldown number
     */
    public int getCooldown() {
        return cooldown;
    }

    /**
     * Decrements the number of turns the ability is on cooldown.
     */
    public void decrementTurnsLeftForCooldown() {
        if (turnsOnCooldown > 0) {
            --turnsOnCooldown;
        }
    }

    /**
     * Returns true if the ability is off cooldown, ie the turns left is 0.
     * @return true if the ability is off cooldown, otherwise false
     */
    public boolean isAbiltyOffCooldown() {
        return turnsOnCooldown <= 0;
    }

    /**
     * Returns the flag for whether this ability can target enemy units.
     * @return flag for if this target enemies
     */
    public boolean canTargetEnemies() {
        return targetEnemies;
    }

    /**
     * Returns the flag for whether this can ability can target allied units.
     * @return flag for if this targets allies
     * 
     */
    public boolean canTargetAllies() {
        return targetAllies;
    }

    /**
     * Returns the {@link AbilityType} of this ability.
     * @return type of ability.
     */
    public AbilityType getAbilityType() {
        return abilityType;
    }

    /**
     * Returns the flag for whether this ability is currently active (usually used for passives
     * or auras to allow the user to toggle them).
     * @return active flag
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the flag for whether this ability is currently active to the given boolean value.
     * @param active boolean flag for whether this ability is active
     */
    public void isActive(boolean active) {
        this.active = active;
    }

    /**
     * Returns the String representation of this ability.
     * @return String representation
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * Returns true if the abilities have equal names, otherwise returns false.
     * @param other other ability to compare to
     * @return true if the abilities have equal names, otherwise false
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Ability)) {
            return false;
        }

        return ((Ability) other).getName().equals(getName());
    }

    /**
     * Returns the hash code for this ability.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    //////////////////////////////////////////////////////////////
    // CALLBACK METHODS
    //////////////////////////////////////////////////////////////

    /**
     * Method that is called when the ability is used that doesn't require a target or area.
     * Abilities that override this should be sure to call the super.use() at the start.
     * @return status of whether the ability was used
     */
    public AbilityErrorStatus use() {
        if (isAbiltyOffCooldown()) {
            turnsOnCooldown = cooldown;
            return AbilityErrorStatus.NONE;
        }
        return AbilityErrorStatus.ON_COOLDOWN;
    }

    /**
     * Method that is called when the ability is used that requires a single target.
     * Abilities that override this should be sure to call the super.use(Entity) at the start.
     * @param target target entity to use this ability on
     * @return status of whether the ability was used
     */
    public AbilityErrorStatus use(Entity target) {
        if (isAbiltyOffCooldown()) {
            turnsOnCooldown = cooldown;
            return AbilityErrorStatus.NONE;
        }
        return AbilityErrorStatus.ON_COOLDOWN;
    }

    /**
     * Method that is called when the ability is used that requires a target area.
     * Abilities that override this should be sure to call the super.use(Tile) at the start.
     * @param targetArea target area to use this ability at
     * @return status of whether the ability was used
     */
    public AbilityErrorStatus use(Tile targetArea) {
        if (isAbiltyOffCooldown()) {
            turnsOnCooldown = cooldown;
            return AbilityErrorStatus.NONE;
        }
        return AbilityErrorStatus.ON_COOLDOWN;
    }

    /**
     * Method that is called when the ability is used that requires multiple targets.
     * Abilities that override this should be sure to call the super.use(List Entity) at the start.
     * @param targets list of entities to use this ability on
     * @return status of whether the ability was used
     */
    public AbilityErrorStatus use(List<Entity> targets) {
        if (isAbiltyOffCooldown()) {
            turnsOnCooldown = cooldown;
            return AbilityErrorStatus.NONE;
        }
        return AbilityErrorStatus.ON_COOLDOWN;
    }

    /**
     * Callback method that is called when the entity casts a spell.
     */
    public void onCast() {
        // For abilities that need this to override
    }

    /**
     * Callback method that is called when the entity attacks a target.
     */
    public void onAttack() {
        // For abilities that need this to override
    }

    /**
     * Callback method that is called when the entity uses an ability.
     */
    public void onAbilityUse() {
        // For abilities that need this to override
    }

    /**
     * Callback method that is called when the entity uses an item.
     */
    public void onUseItem() {
        // For abilities that need this to override
    }

    /**
     * Callback method that is called when the entity moves.
     */
    public void onMove() {
        // For abilities that need this to override
    }

    /**
     * Callback method that is called when the entity hits a target.
     */
    public void onTargetHit() {
        // For abilities that need this to override
    }

    /**
     * Callback method that is called when the entity takes damage.
     */
    public void onDamageTaken() {
        // For abilities that need this to override
    }

    /**
     * Callback method that is called when the entity receives a buff or debuff.
     */
    public void onBuffReceived() {
        // For abilities that need this to override
    }

    /**
     * Callback method that is called when the entity gives a buff or debuff.
     */
    public void onBuffGiven() {
        // For abilities that need this to override
    }

    /**
     * Callback method that is called when the entity dies.
     */
    public void onDeath() {
        // For abilities that need this to override
    }

    /**
     * Callback method that is called when the entity kills a target.
     */
    public void onKill() {
        // For abilities that need this to override
    }
}
