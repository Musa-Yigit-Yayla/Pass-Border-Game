package com.mycompany.passbordergame;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Game implements Difficulty {
    
    public static final int INITIAL_EXPLOSION_RADIUS = 20;
    public static final int DAMAGE = 50;
    
    private final int STARTING_DISTANCE = 20;
    private final int minX = 0;
    private int maxX;//will be set accordingly to the difficulty
    private int difficulty;
    private Player player;
    private ArrayList<EnemyVehicle> enemies = new ArrayList<>();
    private int passedVehicleCount = 0;
    private int MAX_NO_OF_PASSED_VEHICLES; //will be used to determine when the game ends, varies with respect to difficulty
    private GamePlotter gamePlotter = new GamePlotter(this);
    private Circle explosion;
    private Pane pane;
    private int explosionGrowthCount = 0; // how many times the current explosion has expended
    
    
    public Game(int difficulty){
        this.difficulty = difficulty;
        //create the player object
        this.player = new Player();
        this.initializeVehicles();
    }

    public void play(){
        Scanner input = new Scanner(System.in);
        while(passedVehicleCount < MAX_NO_OF_PASSED_VEHICLES){
            this.printGame();

            System.out.println("Enter x, y coordinates for the bomb: ");
            this.player.attack(input.nextInt(), input.nextInt(),this.enemies);
            
            //check each enemy vehicle to replace the destroyed ones
            for(int i = 0; i < enemies.size(); i++){
                if(enemies.get(i).isDestroyed()){
                    enemies.remove(i);
                    enemies.add(i,this.getNewRandomEnemyVehicle());
                    this.player.incrementScore();
                }
            }
            
            //Move the enemies
            for(int i = 0; i < enemies.size(); i++){
                enemies.get(i).move();
            }
            //replace the ones which passed the border
            for(int i = 0; i < enemies.size(); i++){
                if(enemies.get(i).passedTheBorder()){
                    this.passedVehicleCount++;
                    enemies.remove(i);
                    enemies.add(i,this.getNewRandomEnemyVehicle());
                }
            }
        }
        System.out.println("Well played! Your score is: " + this.player.getScore());
    }
    /*
    *@pane pane given from the App
    * draw the vehicles on this pane
    */
    public void playFX(Pane pane){
        while(passedVehicleCount < MAX_NO_OF_PASSED_VEHICLES){
            this.printGame();

            //set the pane's event fired method
            this.pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    //drop bomb
                    explosion = new Circle(INITIAL_EXPLOSION_RADIUS, e.getX(), e.getY());
                    explosion.setFill(Color.ORANGE);
                    Timeline tl = new Timeline();
                    tl.setCycleCount(3);
                    KeyValue keyValue = new KeyValue(explosion.radiusProperty(), 4 / 3.0);
                    
                    //tl.set
                    BombHandler bombHandler = new BombHandler();
                   // tl.getKeyFrames().add(new KeyFrame(Duration.ofSeconds(1), bombHandler, keyValue));
                }
            });
            
            //check each enemy vehicle to replace the destroyed ones
            for(int i = 0; i < enemies.size(); i++){
                if(enemies.get(i).isDestroyed()){
                    EnemyVehicle currEnemy = enemies.get(i);
                    pane.getChildren().remove(currEnemy.getGUI());
                    enemies.remove(i);
                    
                    //generate newVehicle
                    EnemyVehicle newVehicle = this.getNewRandomEnemyVehicle();
                    enemies.add(i,newVehicle);
                    pane.getChildren().add(newVehicle.getGUI());
                    this.player.incrementScore();
                }
            }
            
            //Move the enemies
            for(int i = 0; i < enemies.size(); i++){
                enemies.get(i).move();
            }
            //replace the ones which passed the border
            for(int i = 0; i < enemies.size(); i++){
                if(enemies.get(i).passedTheBorder()){
                    this.passedVehicleCount++;
                    enemies.remove(i);
                    enemies.add(i,this.getNewRandomEnemyVehicle());
                }
            }
        }
        System.out.println("Well played! Your score is: " + this.player.getScore());
        
    }
    @Override
    public int getDifficulty(){
        return this.difficulty;
    }
    private void initializeVehicles(){//spawn initial vehicles wrt to difficulty
        int spawnNumber = 0;
        switch(difficulty){
            case 1: spawnNumber = 2; maxX = 5; MAX_NO_OF_PASSED_VEHICLES = 6; break;
            case 2: spawnNumber = 4; maxX = 10; MAX_NO_OF_PASSED_VEHICLES = 5; break;
            case 3: spawnNumber = 6; maxX = 15; MAX_NO_OF_PASSED_VEHICLES= 4; break;
        }
        while(spawnNumber > 0){
            enemies.add(this.getNewRandomEnemyVehicle());
            spawnNumber--;
        }
    }
    private EnemyVehicle getNewRandomEnemyVehicle(){
        EnemyVehicle vehicle;
        //spawn a vehicle on the starting distance
        if((int)(Math.random() * 2) == 0){
            //generate tank
            vehicle = new Tank(minX,maxX,STARTING_DISTANCE);
        }
        else{
            vehicle = new Helicopter(minX,maxX,STARTING_DISTANCE);
        }
        return vehicle;
    }
    @Override
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    public int getStartingDistance(){
        return this.STARTING_DISTANCE;
    }
    public ArrayList<EnemyVehicle> getEnemies(){
        return this.enemies;
    }
    public void printGame(){
        //print the game state
        /*for(int i = STARTING_DISTANCE; i > 0; i--){
            for(int j = 0; j < maxX; j++){

            }
        }*/
        this.gamePlotter.plot();
    }
    public static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    class BombHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            //this event handler will be called from the timer of the bomb
            //remove the explosion from the pane
            explosion.setRadius(explosion.getRadius() * (4 / 3.0));
            explosionGrowthCount++;
                    
            if(explosionGrowthCount == 2){
                
                //check if any vehicle(s) are damaged
                for(int i = 0; i < enemies.size(); i++){
                    EnemyVehicle currEnemy = enemies.get(i);
                    double enemyX = currEnemy.getX();
                    double enemyY = currEnemy.getY();
                
                    double explosionCenterX = explosion.getCenterX();
                    double explosionCenterY = explosion.getCenterY();
                    
                    double distanceToExplosion = Game.distance(enemyX, enemyY, explosionCenterX, explosionCenterY);
                    if(distanceToExplosion < explosion.getRadius()){
                        //damage the vehicle
                        switch(difficulty){
                            case(1): currEnemy.takeDamage(DAMAGE * Difficulty.EASY_DAMAGE_RATE); break;
                            case(2): currEnemy.takeDamage(DAMAGE * Difficulty.MEDIUM_DAMAGE_RATE); break;
                            case(3): currEnemy.takeDamage(DAMAGE * Difficulty.HARD_DAMAGE_RATE); break;
                        }
                        
                    }
                }
                explosionGrowthCount = 0;
            }
            
            pane.getChildren().remove(explosion);
        }
            
    }
}
