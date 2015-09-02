package com.dunhili.eternitysdungeon.character;

import com.dunhili.eternitysdungeon.ability.Ability;
import com.dunhili.eternitysdungeon.ability.AbilityErrorStatus;
import com.dunhili.eternitysdungeon.buff.Buff;
import com.dunhili.eternitysdungeon.buff.StatusCondition;
import com.dunhili.eternitysdungeon.career.AdvancedCareer;
import com.dunhili.eternitysdungeon.career.BaseCareer;
import com.dunhili.eternitysdungeon.career.Career;
import com.dunhili.eternitysdungeon.item.Armor;
import com.dunhili.eternitysdungeon.item.Inventory;
import com.dunhili.eternitysdungeon.item.Item;
import com.dunhili.eternitysdungeon.item.Weapon;
import com.dunhili.eternitysdungeon.map.Position;
import com.dunhili.eternitysdungeon.map.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents all the characters in the game, which can include Non-playable characters (NPCs), such
 * as vendors, commoners, etc., playable characters (PCs), and enemies.
 * Created by Dunhili on 5/23/2015.
 */
public class Entity {
    //////////////////////////////////////////////////////////////
    // FIELDS
    //////////////////////////////////////////////////////////////
    private static final String TAG = "Entity";

    private Attributes attributes;
    private Career career;
    private Gender gender = Gender.MALE;
    private Inventory inventory = new Inventory();
    private Weapon equippedWeapon = null;
    private Armor equippedArmor = null;
    private Item equippedOffHand = null;
    private List<Buff> buffs = new ArrayList<>();
    private Position currentPosition;

    //////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////////////////////////

    public Entity(BaseCareer startingCareer) {
        // new career
        career = startingCareer;
        attributes = new Attributes(startingCareer.getStartingStats(), career.getGrowthRates(), career.getStatCaps());
    }

    //////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    //////////////////////////////////////////////////////////////

    /**
     * Returns the gender of the character.
     * @return character gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the character's gender to the given gender.
     * @param gender gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Career getCareer() {
        return career;
    }

    /**
     *
     * @return
     */
    public int getPhysicalAttackDamage() {
        //todo
        return 0;
    }

    public int getSpellAttackDamage() {
        //todo
        return 0;
    }

    public int getPhysicalDefense() {
        //todo
        return 0;
    }

    public int getSpellDefense() {
        //todo
        return 0;
    }

    public void attack(Entity target) {
        // TODO
    }

    public AbilityErrorStatus useAbility(Ability ability) {
        if (!hasEnoughHealth(ability.getHealthCost())) {
            return AbilityErrorStatus.NOT_ENOUGH_HEALTH;
        } else if (!hasEnoughMana(ability.getManaCost())) {
            return AbilityErrorStatus.NOT_ENOUGH_MANA;
        } else if (!ability.isAbiltyOffCooldown()) {
            return AbilityErrorStatus.ON_COOLDOWN;
        } else {
            return ability.use();
        }
    }

    public AbilityErrorStatus useAbility(Ability ability, Entity target) {
        if (!hasEnoughHealth(ability.getHealthCost())) {
            return AbilityErrorStatus.NOT_ENOUGH_HEALTH;
        } else if (!hasEnoughMana(ability.getManaCost())) {
            return AbilityErrorStatus.NOT_ENOUGH_MANA;
        } else if (!ability.isAbiltyOffCooldown()) {
            return AbilityErrorStatus.ON_COOLDOWN;
        } else {
            return ability.use(target);
        }
    }

    public AbilityErrorStatus useAbility(Ability ability, Tile targetArea) {
        if (!hasEnoughHealth(ability.getHealthCost())) {
            return AbilityErrorStatus.NOT_ENOUGH_HEALTH;
        } else if (!hasEnoughMana(ability.getManaCost())) {
            return AbilityErrorStatus.NOT_ENOUGH_MANA;
        } else if (!ability.isAbiltyOffCooldown()) {
            return AbilityErrorStatus.ON_COOLDOWN;
        } else {
            return ability.use(targetArea);
        }
    }

    public boolean hasEnoughMana(int manaCost) {
        return attributes.getCurrentMana() >= manaCost;
    }

    public boolean useMana(int manaCost) {
        if (hasEnoughMana(manaCost)) {
            attributes.setCurrentMana(attributes.getCurrentMana() - manaCost);
            return true;
        }
        return false;
    }

    public void restoreMana(int manaToRestore) {
        attributes.setCurrentMana(attributes.getCurrentMana() + manaToRestore);
    }

    public void heal(int healAmount) {
        attributes.setCurrentHP(attributes.getCurrentHP() + healAmount);
    }

    public boolean hasEnoughHealth(int healthCost) {
        return attributes.getCurrentHP() >= healthCost;
    }

    public boolean useHealth(int healthCost) {
        if (hasEnoughHealth(healthCost)) {
            attributes.setCurrentHP(attributes.getCurrentHP() - healthCost);
            return true;
        }
        return false;
    }

    public void damage(int damageAmount) {
        attributes.setCurrentHP(attributes.getCurrentHP() - damageAmount);
    }

    public boolean isPoisoned() {
        return hasStatusCondition(StatusCondition.POISON);
    }

    public boolean isStunned() {
        return hasStatusCondition(StatusCondition.STUN);
    }

    public boolean isBlinded() {
        return hasStatusCondition(StatusCondition.BLIND);
    }

    public boolean isStoned() {
        return hasStatusCondition(StatusCondition.STONE);
    }

    public boolean isConfused() {
        return hasStatusCondition(StatusCondition.CONFUSE);
    }

    public boolean isSilenced() {
        return hasStatusCondition(StatusCondition.SILENCE);
    }

    public boolean isBleeding() {
        return hasStatusCondition(StatusCondition.BLEED);
    }

    public boolean isBerserked() {
        return hasStatusCondition(StatusCondition.BERSERK);
    }

    public boolean isImmobilized() {
        return hasStatusCondition(StatusCondition.IMMOBILIE);
    }

    public boolean isSleeping() {
        return hasStatusCondition(StatusCondition.SLEEP);
    }

    public void promote(AdvancedCareer upgradedCareer) {
        career = upgradedCareer;
        attributes.addPromotionBonus(upgradedCareer);
    }

    /**
     * Removes the character and drops the character's inventory.
     * @return character's inventory
     */
    public Inventory die() {
        attributes.setCurrentHP(0);
        attributes.setCurrentMana(0);

        // TODO
        List<Item> oldItems = inventory.getItems();
        inventory.clear();
        return new Inventory(oldItems);
    }

    private boolean hasStatusCondition(StatusCondition conditionToCheck) {
        for (Buff buff : buffs) {
            for (StatusCondition condition : buff.getConditions()) {
                if (conditionToCheck == condition) {
                    return true;
                }
            }
        }
        return false;
    }
}
