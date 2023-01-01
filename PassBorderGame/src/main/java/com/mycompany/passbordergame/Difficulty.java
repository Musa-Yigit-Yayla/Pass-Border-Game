public interface Difficulty {
    public final int EASY = 1;
    public final int MEDIUM = 2;
    public final int HARD = 3;
    
    void setDifficulty(int difficulty);
    int getDifficulty();
}
