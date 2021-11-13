/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author ProjectTron
 */
public class Controller implements KeyListener{
    //This variable saves which direction the snake should be going
    private Snake.Direction ControllerDirection = Snake.Direction.Up;
    @Override
    public void keyPressed(KeyEvent e){
    //gets the key
    int keyCode = e.getKeyCode();
    //based on what key it is this will decide the direction
    switch(keyCode) { 
        case KeyEvent.VK_W:
            ControllerDirection = Snake.Direction.Up;
            break;
        case KeyEvent.VK_S:
            ControllerDirection = Snake.Direction.Down;
            break;
        case KeyEvent.VK_A:
            ControllerDirection = Snake.Direction.Left;
            break;
        case KeyEvent.VK_D:
            ControllerDirection = Snake.Direction.Right;
            break;
        default:
            break;
    }
    }
    //defined because I had to define it to get the class to work
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    //defined because I had to define it to get the class to work
    @Override
    public void keyReleased(KeyEvent e) {
    
    }
    //Gets the direction suggested by the controller.
    public Snake.Direction GetDirection(){
        return ControllerDirection;
    }
}
