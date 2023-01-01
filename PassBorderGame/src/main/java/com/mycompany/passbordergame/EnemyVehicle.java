import java.awt.Point;

public abstract class EnemyVehicle implements Moveable, Destructible{
    private int x;
    private int y; //these denote positions
    private final int BASE_SPEED = 3;
    private int speed = BASE_SPEED;
    private Point point;
    //My instance variable declarations
    private double healthPoint = 100;
    private boolean passedTheBorder = false;

    protected EnemyVehicle(int minX, int maxX, int y){
        this.x = (int)(Math.random() * maxX) + minX;
        this.y = y;
        point = new Point(this.x,this.y);
    }
    public int getDistanceToBorder(){
        return this.y; // since the border is y = 0
    }
    abstract String getType();
    @Override
    public Point getLocation() {
        return this.point;
    }
    @Override
    public void move() {
        //move the vehicle on their y axis wrt base speed
        if(this.y - speed < 0){
            //passed the border
            this.passedTheBorder = true;
            return;
        }
        this.y -= speed;
        this.point.setLocation(this.x, this.y);
    }
    @Override
    public boolean isDestroyed() {
       return this.healthPoint <= 0;
    }
    @Override
    public void takeDamage(double damage) {
        this.healthPoint -= damage;
    }
    public boolean passedTheBorder(){
        return this.passedTheBorder;
    }
    protected void incrementSpeed(){//will be used in the heli class
        speed++;
    }
}
