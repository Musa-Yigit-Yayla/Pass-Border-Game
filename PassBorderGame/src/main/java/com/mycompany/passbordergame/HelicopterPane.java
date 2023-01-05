/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.passbordergame;


import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.animation.Timeline;
/**
 *
 * @author yigit
 */
public class HelicopterPane extends Pane {
    private Helicopter helicopter;
    private Pane skeletonPane = new Pane(); //pervanesiz helikopter pane'i
    private Polygon skeleton = new Polygon();
    private Rectangle cockpit;
    
    public static final Color damageTakenColor = Color.DARKRED;
    public static final double SKELETON_PANE_WIDTH = 90.0;
    public static final double SKELETON_PANE_HEIGHT = 162.0;
    public static final double COCKPIT_X = 42.0;
    public static final double COCKPIT_Y = 24.0;
    public static final double COCKPIT_WIDTH = 6.0;
    public static final double COCKPIT_LENGTH = 18.0;
    
    public HelicopterPane(){
        this.helicopter = new Helicopter((int)SKELETON_PANE_HEIGHT, (int)(1920 - SKELETON_PANE_HEIGHT) , (int) App.SPAWN_LINE);
        this.setSkeleton();
        this.setCockpit();
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
    
    
}
