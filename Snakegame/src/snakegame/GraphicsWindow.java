package snakegame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.lang.System;
import java.awt.event.KeyEvent;
/*
This class is a child of JPannel, JPannel is bassically a class that allows
you to print graphics and capture inputs
 */
public class GraphicsWindow extends JPanel{
    //Delcairing variables
    Snake MySnake;
    Fruit MyFruit;
    public static final byte Scale = 30;
    public static final int Width = 900, Height = 810;
    //Consturctor takes both A player and the object to render
    GraphicsWindow(Snake ASnake, Fruit AFruit){
        //sets the preferred size of the graphics window
        setPreferredSize(new Dimension(Width, Height));
        MySnake = ASnake;
        MyFruit = AFruit;
        //allows me to capture keyboard inputs
        this.setFocusable(true);
    }
    //Overriding the paintComponent
    @Override
    public void paintComponent(Graphics g){
        //clears background and replaces it with black
        this.setBackground(Color.black);
        g.clearRect(0, 0, Width, Height);
        super.paintComponent(g);
        //draws the snake's head
        g.setColor(new Color(0,255,0));
        g.fillRect(Scale * MySnake.GetX(), Scale * MySnake.GetY(), Scale, Scale);
        //draws the snake's tail
        g.setColor(new Color(0,190,0));
        for(int i = 0; i < MySnake.GetLength(); i++){
            g.fillRect(MySnake.GetIndxX(i) * Scale, MySnake.GetIndxY(i) * Scale, Scale, Scale);
        }
        //draws the fruit
        g.setColor(new Color(185,50,0));
        g.fillRect(MyFruit.GetXLocation() * Scale, MyFruit.GetYLocation() * Scale, Scale, Scale);
    }
}

