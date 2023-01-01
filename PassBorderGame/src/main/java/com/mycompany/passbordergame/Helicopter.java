public class Helicopter extends EnemyVehicle {

    public Helicopter(int minX, int maxX, int y) {
        super(minX, maxX, y);
        
    }
    @Override
    public void move(){
        //increment the base speed after each move
        super.move();
        this.incrementSpeed();
    }
    @Override
    public String getType() {
            return "Helicopter";
    }
    
}
