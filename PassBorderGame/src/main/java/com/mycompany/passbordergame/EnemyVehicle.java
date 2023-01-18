 package com.mycompany.passbordergame;

//import java.awt.Point;

import javafx.scene.Group;
import javafx.scene.shape.Polygon;

public abstract class EnemyVehicle implements Moveable, Destructible{
    private int x;
    private int y; //these denote positions
    private final int BASE_SPEED = 3;
    private int speed = BASE_SPEED;
    private Point point;
    //My instance variable declarations
    private double healthPoint = 100;
    private boolean passedTheBorder = false;
    private Game game; //game object
    protected Polygon damageArea; // area in which the vehicle lives
            
    protected EnemyVehicle(int minX, int maxX, int y){
        this.x = (int)(Math.random() * maxX) + minX;
        this.y = y;
        point = new Point(this.x,this.y);
    }
    
    private void setEventWhenClicked(){
        this.damageArea.setOnMouseClicked(e -> {
            double damageRatio = 1.0;
            switch(this.game.getDifficulty()){
                case(0): damageRatio = Game.EASY_DAMAGE_RATE; break;
                case(1): damageRatio = Game.MEDIUM_DAMAGE_RATE; break;
                case(2): damageRatio = Game.HARD_DAMAGE_RATE; break;
            }
            this.takeDamage(Game.DAMAGE * damageRatio);
        });
    }
    public int getDistanceToBorder(){
        return this.y; // since the border is y = 0
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.getDistanceToBorder();
    }
    abstract Group getGUI();
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
    public void setGame(Game game){
        this.game = game;
    }
    protected void incrementSpeed(){//will be used in the heli class
        speed++;
    }
    protected abstract void setDamageArea();
}
