package com.mycompany.passbordergame;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
public class Game implements Difficulty {
    private final int STARTING_DISTANCE = 20;
    private final int minX = 0;
    private int maxX;//will be set accordingly to the difficulty
    private int difficulty;
    private Player player;
    private ArrayList<EnemyVehicle> enemies = new ArrayList<>();
    private int passedVehicleCount = 0;
    private int MAX_NO_OF_PASSED_VEHICLES; //will be used to determine when the game ends, varies with respect to difficulty
    private GamePlotter gamePlotter = new GamePlotter(this);

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

            System.out.println("Enter x, y coordinates for the bomb: ");
            this.player.attack(input.nextInt(), input.nextInt(),this.enemies);
            
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
}
