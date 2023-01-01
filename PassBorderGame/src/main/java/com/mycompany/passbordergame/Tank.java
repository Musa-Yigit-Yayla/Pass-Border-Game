package com.mycompany.passbordergame;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Tank extends EnemyVehicle {
    private final double TANK_DAMAGE_RATIO = 0.5;
    private Group tankGUI = new Group();
    
    public Tank(int minX, int maxX, int y){
        super(minX, maxX, y);
        this.setTankGUI();
    }
    @Override
    public String getType(){
        return "Tank";
    }
    @Override
    public void takeDamage(double damage){
        super.takeDamage(damage * TANK_DAMAGE_RATIO);
    }
    private void setTankGUI(){
        //set the gui elements for tank
        Polygon palet = new Polygon();
        palet.getPoints().addAll(0.0, 2.0, 2.0, 2.0, 2.0, 5.0, 1.0, 6.0, 1.0, 11.0, 2.0, 12.0, 2.0, 13.0, 2.0, 14.0, 0.0, 14.0, 7.0, 13.0, 8.0, 10.0, 10.0, 14.0, 10.0, 2.0, 8.0, 2.0, 8.0, 5.0, 9.0 ,6.0, 9.0, 12.0, 8.0 ,3.0);
        palet.setStroke(Color.BLACK);
        palet.setFill(Color.LIMEGREEN);
        
        Polygon torso = new Polygon();
        torso.getPoints().addAll(2.0, 3.0, 2.0, 5.0, 1.0, 6.0, 1.0, 11.0, 2.0, 12.0, 2.0, 13.0, 8.0, 13.0, 9.0, 12.0, 9.0, 6.0, 8.0, 5.0, 8.0, 3.0);
        torso.setStroke(Color.BLACK);
        torso.setFill(Color.SANDYBROWN);
        
        Polygon turret = new Polygon(4.0, 6.0, 4.0, 7.0, 3.0, 7.0, 2.0, 8.0, 2.0, 11.0, 3.0, 12.0, 7.0, 12.0, 8.0, 11.0, 8.0, 8.0, 7.0, 7.0, 6.0, 7.0, 6.0, 6.0);
        turret.setStroke(Color.BLACK);
        turret.setFill(Color.DARKGREEN);
        
        Polygon cannon = new Polygon(4.5, 6.0, 5.5, 6.0, 4.5, 0.0, 5.5, 0.0);
        cannon.setFill(Color.DARKGREEN);
        cannon.setStroke(Color.DARKGREEN);
        
        Circle exitHatchet = new Circle(1, 4, 10);
        exitHatchet.setStroke(Color.BLACK);
        exitHatchet.setFill(Color.SANDYBROWN);
        
        Circle machineGun = new Circle(0.8, 6.5, 4.5);
        machineGun.setFill(Color.DARKGREEN);
        Line gun = new Line(6.5, 3.7, 6.5, 2.0);
        
        //add the visual elements into the group
        this.tankGUI.getChildren().addAll(palet, torso, turret, cannon, exitHatchet, machineGun, gun);
    }
}
