import java.util.ArrayList;
import java.awt.Point;
public class Player {
    private final double BOMB_RADIUS = 2.0;
    private final double DAMAGE = 50;
    private int score = 0;

    public void attack(int x, int y, ArrayList<EnemyVehicle> enemies){
        //check each vehicle individually whether they are in the bomb radius
        for(int i = 0; i < enemies.size(); i++){
            double enemyX = enemies.get(i).getLocation().getX();            
            double enemyY = enemies.get(i).getLocation().getY();
            
            double distance = Point.distance(x,y,enemyX,enemyY);
            if(distance <= BOMB_RADIUS){
                enemies.get(i).takeDamage(DAMAGE);
            }
        }
    }
    public void incrementScore(){
        this.score++;
    }
    public int getScore(){
        return this.score;
    }
}
