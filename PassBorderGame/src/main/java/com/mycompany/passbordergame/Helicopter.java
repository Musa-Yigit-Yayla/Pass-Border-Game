package com.mycompany.passbordergame;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;

public class Helicopter extends EnemyVehicle {
    private HelicopterPane heliPane;
    public Helicopter(int minX, int maxX, int y) {
        super(minX, maxX, y);
        this.heliPane = new HelicopterPane(this);
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
    public Group getGUI() {
        return null;
    }
    //Polymorphic return
    //Invoke from App class
    public Pane getHelicopterPane(){
        return this.heliPane;
    }
    @Override
    protected void setDamageArea() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
