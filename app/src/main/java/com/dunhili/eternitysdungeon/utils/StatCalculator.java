package com.dunhili.eternitysdungeon.utils;

import com.dunhili.eternitysdungeon.character.Stat;
import com.dunhili.eternitysdungeon.character.StatType;

import java.util.Arrays;
import java.util.Random;

/**
 * Contains utility methods related to character stats.
 * Created by Dunhili on 5/27/2015.
 */
public class StatCalculator {
    private static Random rand = new Random();

    /**
     * Increases the stats based on their respective growth rates. A random number is generated and is checked to see if
     * it is lower than the growth rate and increments the stat if is. Stats that have growth rates higher than 100%
     * can be raised multiple times. 
     * @param stats list of stats to increase
     * @return stats after they have been improved
     */
    public static Stat[] levelUp(Stat[] stats) {
        for (Stat stat : stats) {
            stat.setValue(calculateStatLevelUp(stat));
        }
        return stats;
    }

    /**
     * Levels up the given stat based on its growth rate.
     * @param stat stat to level up
     * @return new value of the stat
     */
    private static int calculateStatLevelUp(Stat stat) {
        int growthRate = stat.getGrowthRate();
        int statValue = stat.getValue();
        while (growthRate > 0) {
            int roll = rand.nextInt(100) + 1;
            if (roll <= growthRate && statValue < stat.getCap()) {
                ++statValue;
            }
            growthRate -= 100;
        }
        return statValue;
    }

    /*private static int[] getStatStatistics(int initialStat, int growthRate, int startingLevel, int numLevels) {
        final int NUM_RUNS = 25;
        int low = 999;
        int average = 0;
        int high = 0;

        for (int j = 0; j < NUM_RUNS; j++) {
            int stat = initialStat;
            for (int level = startingLevel; level < numLevels; level++) {
                stat = calculateStat(new Stat(StatType.HITPOINTS, stat, growthRate));
            }
            average += stat;
            if (stat < low) {
                low = stat;
            } else if (stat > high) {
                high = stat;
            }
        }

        average /= NUM_RUNS;

        int[] result = {low, average, high};
        return result;
    }

    public static void main(String[] args) {
        String[] stats = {"HP  ", "Mana", "Str ", "Dex ", "Int ", "Will", "Def ", "Res "};
        int[] initialStats = {13, 8, 7, 7, 3, 4, 7, 5};
        int[] growthRates = {50, 50, 50, 45, 20, 25, 60, 30};
        int startingLevel = 1;
        int numLevels = 20;

        System.out.println(Arrays.toString(initialStats));
        System.out.println(Arrays.toString(growthRates));
        System.out.println();
        for (int i = 0; i < initialStats.length; i++) {
            int[] result = getStatStatistics(initialStats[i], growthRates[i], startingLevel, numLevels);
            System.out.println(stats[i] + "\n\tStart : " + initialStats[i] + "\n\tGrowth: " + growthRates[i] +
                    "\n\tLow : " + result[0] + "\n\tAverage : " + result[1] + "\n\tHigh : " + result[2]);
        }
    }*/
}
