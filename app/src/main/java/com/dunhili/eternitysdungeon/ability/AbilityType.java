package com.dunhili.eternitysdungeon.ability;

/**
 * Created by Dunhili on 5/27/2015.
 */
public enum AbilityType {
    /** Ability is a single target. */
    SINGLE, 
    
    /** Ability hits units in a cone shape. */
    CONE, 
    
    /** Ability hits units in a circle originating from a certain point. */
    CIRCLE,
    
    /** Ability hits units in a line. */
    LINE, 
    
    /** Ability that does not need to be cast and is usually always on. */
    PASSIVE, 
    
    /** Passive ability that also extends outward from the user. */
    AURA;
}
