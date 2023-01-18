package com.mycompany.passbordergame;
import java.io.File;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Tank extends EnemyVehicle {
    private final double TANK_DAMAGE_RATIO = 0.5;
    private Group tankGUI = new Group();
    private Polygon torso; // also damage area
    private Polygon damageArea;
    private ImageView tankImg;
    
    public static final double TANK_SCALE = 150.0; // 30 PIXELS
    public static final int x = 30; // Value to add to the polygons' points
    public static final double TANK_SCALE_RATIO = 1 / 7.0;
    
    public Tank(int minX, int maxX, int y){
        super(minX, maxX, y);
        this.setTankGUI();
        this.damageArea = torso;
        this.setImage();
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
        palet.getPoints().addAll(0.0 + x, 2.0 + x, 2.0 + x, 2.0 + x, 2.0 + x, 5.0 + x, 1.0 + x, 6.0 + x, 1.0 + x, 11.0 + x, 2.0 + x, 12.0 + x, 2.0 + x, 13.0 + x, 2.0 + x, 14.0 + x, 0.0 + x, 14.0 + x, 7.0 + x, 13.0 + x, 8.0 + x, 10.0 + x, 10.0 + x, 14.0 + x, 10.0 + x, 2.0 + x, 8.0 + x, 2.0 + x, 8.0 + x, 5.0 + x, 9.0 + x ,6.0 + x, 9.0 + x, 12.0 + x, 8.0 + x, 3.0 + x);
        palet.setStroke(Color.BLACK);
        palet.setFill(Color.LIMEGREEN);
        
        torso = new Polygon();
        torso.getPoints().addAll(2.0 + x, 3.0 + x, 2.0 + x, 5.0 + x, 1.0 + x, 6.0 + x, 1.0 + x, 11.0 + x, 2.0 + x, 12.0 + x, 2.0 + x, 13.0 + x, 8.0 + x, 13.0 + x, 9.0 + x, 12.0 + x, 9.0 + x, 6.0 + x, 8.0 + x, 5.0 + x, 8.0 + x, 3.0 + x);
        torso.setStroke(Color.BLACK);
        torso.setFill(Color.SANDYBROWN);
        
        Polygon turret = new Polygon(4.0 + x, 6.0 + x, 4.0 + x, 7.0 + x, 3.0 + x, 7.0 + x, 2.0 + x, 8.0 + x, 2.0 + x, 11.0 + x, 3.0 + x, 12.0 + x, 7.0 + x, 12.0 + x, 8.0 + x, 11.0 + x, 8.0 + x, 8.0 + x, 7.0 + x, 7.0 + x, 6.0 + x, 7.0 + x, 6.0 + x, 6.0 + x);
        turret.setStroke(Color.BLACK);
        turret.setFill(Color.DARKGREEN);
        
        Polyline cannon = new Polyline(4.5 + x, 6.0 + x, 5.5 + x, 6.0 + x, 4.5 + x, 0.0 + x, 5.5 + x, 0.0 + x);
        cannon.setFill(Color.DARKGREEN);
        cannon.setStroke(Color.DARKGREEN);
        
        Circle exitHatchet = new Circle(1 + x, 4 + x, 10 + x);
        exitHatchet.setStroke(Color.BLACK);
        exitHatchet.setFill(Color.SANDYBROWN);
        
        Circle machineGun = new Circle(0.8 + x, 6.5 + x, 4.5 + x);
        machineGun.setFill(Color.DARKGREEN);
        Line gun = new Line(6.5 + x, 3.7 + x, 6.5 + x, 2.0 + x);
        
        //add the visual elements into the group
        this.tankGUI.getChildren().addAll(palet, torso, turret, cannon, exitHatchet, machineGun, gun);
        for(int i = 0; i < tankGUI.getChildren().size(); i++){
            Node curr = tankGUI.getChildren().get(i);
            curr.scaleXProperty().multiply(TANK_SCALE);
            curr.scaleYProperty().multiply(TANK_SCALE);
        }
    }
    private void setImage(){
        Image img = new Image(new File("Pass-Border-Game\\PassBorderGame\\src\\main\\java\\imgs\\tank.jpg").toURI().toString());
        this.tankImg = new ImageView(img);
    }
    public ImageView getImage(){
        return this.tankImg;
    }
    //Invoke from the Game class
    //Might be problematic
    @Override
    public Group getGUI(){
        return this.tankGUI;
    }

    @Override
    protected void setDamageArea() {
        this.damageArea = this.torso;
    }
}
