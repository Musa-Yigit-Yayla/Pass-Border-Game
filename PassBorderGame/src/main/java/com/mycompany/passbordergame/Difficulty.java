package com.mycompany.passbordergame;

public interface Difficulty {
    public final int EASY = 1;
    public final int MEDIUM = 2;
    public final int HARD = 3;
    public final double EASY_DAMAGE_RATE = 1.0;
    public final double MEDIUM_DAMAGE_RATE = 0.8;
    public final double HARD_DAMAGE_RATE = 0.7;
    
    
    void setDifficulty(int difficulty);
    int getDifficulty();
}
