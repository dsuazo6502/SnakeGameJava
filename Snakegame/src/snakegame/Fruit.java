/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;
import java.util.Random;
/**
 *
 * @author ProjectTron
 */
public class Fruit {
    //Declairing variables
    private int XLocation;
    private int YLocation;
    Fruit(){
        //Sets a random spawn location for fruit
        Random RandomNum = new Random();
        XLocation = RandomNum.nextInt(GraphicsWindow.Width/GraphicsWindow.Scale);
        YLocation = RandomNum.nextInt(GraphicsWindow.Height/GraphicsWindow.Scale);
    }
    public void RespawnFruit(){
        //Moves the fruit to a new location or "Respawns it"
        Random RandomNum = new Random();
        XLocation = RandomNum.nextInt(GraphicsWindow.Width/GraphicsWindow.Scale);
        YLocation = RandomNum.nextInt(GraphicsWindow.Height/GraphicsWindow.Scale);
    }
    //Gets the X position of the fruit
    public int GetXLocation(){
        return XLocation;
    }
    //Gets the Y position of the fruit
    public int GetYLocation(){
        return YLocation;
    }
}
