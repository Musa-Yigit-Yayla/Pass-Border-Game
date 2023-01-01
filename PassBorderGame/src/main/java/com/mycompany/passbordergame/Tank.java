package com.mycompany.passbordergame;

public class Tank extends EnemyVehicle {
    private final double TANK_DAMAGE_RATIO = 0.5;

    public Tank(int minX, int maxX, int y){
        super(minX, maxX, y);
    }
    @Override
    public String getType(){
        return "Tank";
    }
    @Override
    public void takeDamage(double damage){
        super.takeDamage(damage * TANK_DAMAGE_RATIO);
    }
}
