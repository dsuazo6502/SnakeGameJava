/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;
import java.awt.Color;
import javax.swing.JFrame;
import java.lang.System;
/**
 *
 * @author ProjectTron
 */
public class Snakegame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Making variables
        boolean GameEnd = false;
        Controller GameController = new Controller();
        Snake Player = new Snake();
        Fruit SnakeFood = new Fruit();
        GraphicsWindow Graphics = new GraphicsWindow(Player, SnakeFood);
        //setting up the windows
        Graphics.setSize(900, 810);
        JFrame Window = new JFrame("Snake");
        //adding graphics layer
        Window.add(Graphics);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window.setBounds(650, 200, 920, 858);
        //Keyboard listener
        Graphics.addKeyListener(GameController);
        //making the window visible
        Window.setVisible(true);
        //Main Game loop
        while(GameEnd != true){
        try{
            //game clock
            Thread.sleep(200);
        }
        catch(InterruptedException ex){
            System.out.print("sleep exception was thrown");
        }
        try{
            //Moves the snake
        Player.Move(GameController.GetDirection(), Graphics);
        }
        /* If you do somthing like hit the tail of the snake then the game over
        exception will be thrown
        */
        catch(GameOver ex){
            GameEnd = true;
        }
        //This is when the snake "Eats" the fruit
        if(Player.GetX() == SnakeFood.GetXLocation() && Player.GetY() == SnakeFood.GetYLocation()){
            Player.AddToLength();
            SnakeFood.RespawnFruit();
        }
        //Update Graphics Pannel
        Graphics.repaint();
        }
        //tells the player the game is over.
        System.out.println("Game Over");
        
    }
    
}
