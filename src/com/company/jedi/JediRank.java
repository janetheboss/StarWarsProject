package com.company.jedi;

public enum JediRank {
    YOUNG_LING(1, "Young-ling"),
    INITIATE(2, "Initiate"),
    PADAWAN(3, "Padawan"),
    KNIGHT_ASPIRANT(4, "Knight Aspirant"),
    KNIGHT(5, "Knight"),
    MASTER(6, "Master"),
    BATTLE_MASTER(7, "Battle Master") ,
    GRAND_MASTER(8, "Grand Master");

    private final int rankNumber;
    private final String name;

    JediRank(int rankNumber, String name) {
        this.rankNumber = rankNumber;
        this.name = name;
    }

    public int getRankNumber() {
        return rankNumber;
    }

    public String getName() {
        return name;
    }
}
