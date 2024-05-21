package com.company.jedi;

import com.company.universe.Universe;

import java.util.HashSet;

public class JediHelper {

    public static JediRank getPreviousRank(Jedi jedi) {
        int currentRankNumber = jedi.getRank().getRankNumber();
        switch (currentRankNumber) {
            case 2:
                return JediRank.YOUNG_LING;
            case 3:
                return JediRank.INITIATE;
            case 4:
                return JediRank.PADAWAN;
            case 5:
                return JediRank.KNIGHT_ASPIRANT;
            case 6:
                return JediRank.KNIGHT;
            case 7:
                return JediRank.MASTER;
            case 8:
                return JediRank.BATTLE_MASTER;
            default:
                return null;
        }
    }

    public static JediRank getNextRank(Jedi jedi) {
        int currentRankNumber = jedi.getRank().getRankNumber();
        switch (currentRankNumber) {
            case 1:
                return JediRank.INITIATE;
            case 2:
                return JediRank.PADAWAN;
            case 3:
                return JediRank.KNIGHT_ASPIRANT;
            case 4:
                return JediRank.KNIGHT;
            case 5:
                return JediRank.MASTER;
            case 6:
                return JediRank.BATTLE_MASTER;
            case 7:
                return JediRank.GRAND_MASTER;
            default:
                return null;
        }
    }


    public static double multiplier(double multiplier, double power) throws Exception {
        if (multiplier <= 0) {
            throw new Exception("Multiplier can't be 0 or lower");
        }
        return power / multiplier;
    }

    public static double multiplierPromote(double multiplier, double power) throws Exception {
        if (multiplier <= 0) {
            throw new Exception("Multiplier can't be 0 or lower");
        }
        return power * multiplier;
    }

    public static boolean jediExists(String jediName){
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        for (Jedi jedi : jedis) {
            if (jediName.equalsIgnoreCase(jedi.getName())) {
                return true;
            }
        }
        return false;
    }
}
