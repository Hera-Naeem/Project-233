package com.example.demo3;

import java.util.HashMap;

/**
 * Partner 1: Efren Garcia
 * Partner 2: Hera Naeem
 * T08
 */

/**
 * gets KDA of the HashMap, and it's not used a lot
 */


public class KDA {
    //public HashMap<String, Double> allPlayerStats = new HashMap<String, Double>(); //playerIdentity : KDA
    private final String KDAIdentity;
    private final double KDANumber;

    KDA(String identity, double KDA)
    {
        this.KDAIdentity = identity;
        this.KDANumber = KDA;
    }

    //********
    public Double getKDA(HashMap allPlayerStats, String playerIdentity)
    {
        if(allPlayerStats.containsKey(playerIdentity))
        {
            return (Double) allPlayerStats.get(playerIdentity);
        }
        return null;
    }
    //********
}
