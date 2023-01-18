package com.mycompany.passbordergame;
import javafx.scene.Group;
import javafx.scene.shape.*;

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

    @Override
    Group getGUI() {
        return null;
    }

    @Override
    protected void setDamageArea() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
