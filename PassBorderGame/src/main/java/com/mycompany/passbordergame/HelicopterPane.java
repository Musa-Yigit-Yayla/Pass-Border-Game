/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.passbordergame;


import java.time.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.animation.Timeline;
import javafx.geometry.Orientation;
import javafx.geometry.NodeOrientation;
import static javafx.util.Duration.INDEFINITE;
import javafx.scene.transform.Rotate;
import javafx.beans.value.ObservableValue;
/**
 *
 * @author yigit
 */
public class HelicopterPane extends Pane {
    private Helicopter helicopter;
    private Pane skeletonPane = new Pane(); //pervanesiz helikopter pane'i
    private Polygon skeleton = new Polygon();
    private Rectangle cockpit;
    private Rectangle pervaneler;
    private Circle pervaneHolder = new Circle(15);
    private Timeline propeller; // this is for rotating the pervane
    
    public static final Color damageTakenColor = Color.DARKRED;
    public static final double SKELETON_PANE_WIDTH = 90.0;
    public static final double SKELETON_PANE_HEIGHT = 162.0;
    public static final double COCKPIT_X = 42.0;
    public static final double COCKPIT_Y = 24.0;
    public static final double COCKPIT_WIDTH = 6.0;
    public static final double COCKPIT_LENGTH = 18.0;
    public static final double PERVANELER_LENGTH = 72;
    public static final double PERVANELER_WIDTH = 10;
    public static final double CENTER_X = 45;
    public static final double CENTER_Y = 84;
    public static final double PERVANE_HOLDER_RADIUS = 15;
    
    public HelicopterPane(){
        this.helicopter = new Helicopter((int)SKELETON_PANE_HEIGHT, (int)(1920 - SKELETON_PANE_HEIGHT) , (int) App.SPAWN_LINE);
        this.setSkeleton();
        this.setCockpit();
        this.setPervaneler();
        this.setPropeller();
    }
    private void setSkeleton(){
        skeleton.getPoints().addAll(42.0 , 12.0);
        skeleton.getPoints().addAll(30.0 , 54.0);
        skeleton.getPoints().addAll(18.0 , 66.0);
        //skeleton.getPoints().addAll(42.0 , 12.0);
        skeleton.getPoints().addAll(18.0 , 78.0);
        skeleton.getPoints().addAll(30.0 , 90.0);
        skeleton.getPoints().addAll(36.0 , 126.0);
        skeleton.getPoints().addAll(42.0 , 132.0);
        skeleton.getPoints().addAll(36.0 , 150.0);
        skeleton.getPoints().addAll(24.0 , 150.0);
        skeleton.getPoints().addAll(24.0 , 156.0);
        skeleton.getPoints().addAll(66.0 , 156.0);
        skeleton.getPoints().addAll(66.0 , 150.0);
        skeleton.getPoints().addAll(54.0 , 150.0);
        skeleton.getPoints().addAll(48.0 , 132.0);
        skeleton.getPoints().addAll(54.0 , 126.0);
        skeleton.getPoints().addAll(60.0 , 90.0);
        skeleton.getPoints().addAll(72.0 , 78.0);
        skeleton.getPoints().addAll(72.0 , 66.0);
        skeleton.getPoints().addAll(60.0 , 54.0);
        skeleton.getPoints().addAll(36.0 , 12.0);
        
        this.skeleton.setFill(Color.DARKGRAY);
        this.cockpit.setStroke(Color.BLACK);
    }
    private void setCockpit(){
        this.cockpit = new Rectangle();
        cockpit.setX(COCKPIT_X);
        cockpit.setX(COCKPIT_Y);
        cockpit.setWidth(COCKPIT_WIDTH);
        cockpit.setHeight(COCKPIT_LENGTH);
        
        this.cockpit.setFill(Color.CYAN);
        this.cockpit.setStroke(Color.BLACK);
    }
    private void setPervaneler(){
        this.pervaneler = new Rectangle(PERVANELER_LENGTH, PERVANELER_WIDTH);
        this.pervaneler.setX(CENTER_X - PERVANELER_WIDTH);
        this.pervaneler.setY(CENTER_Y - PERVANELER_LENGTH);
        this.pervaneler.setFill(Color.BLACK);
        this.pervaneHolder.setCenterX(CENTER_X);
        this.pervaneHolder.setCenterY(CENTER_Y);
        this.pervaneHolder.setFill(Color.DARKRED);
        
    }

    private void setPropeller() {
        this.propeller = new Timeline();
        this.propeller.setCycleCount(-1);
        Rotate rotate = new Rotate();
        rotate.setPivotX(CENTER_X);
        rotate.setPivotY(CENTER_Y);
        this.propeller.getTransforms()
        this.propeller.getKeyFrames().add(new KeyFrame(Duration.millis(2000), new KeyValue(this.propeller)));
    }
    
}
