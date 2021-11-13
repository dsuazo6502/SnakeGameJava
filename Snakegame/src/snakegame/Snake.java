/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

/**
 *
 * @author ProjectTron
 */
public class Snake {
    //Declairing variables
    private static byte Length;
    private byte []PrevX = new byte[100];
    private byte []PrevY = new byte[100];
    private byte X;
    private byte Y;
    //enumeration for the direction control
    public enum Direction {
        Up, Down, Left, Right
    }
    Snake(){
        //sets snake spawn
        X = 24;
        Y = 19;
        //initializes length back to zero
        Length = 0;
    }
    public void Move(Direction MyDirect, GraphicsWindow ThisWindow) throws GameOver{
        //saves previous positions for the snakes tail
        for(int i = Length; i >= 0; i--){
            if(i == 0){
                PrevX[i+1] = PrevX[i];
                PrevY[i+1] = PrevY[i];
                PrevX[i] = X;
                PrevY[i] = Y;
            }
            else{
                PrevX[i+1] = PrevX[i];
                PrevY[i+1] = PrevY[i];
            }
        }
        //Moves the snakes head in a direction
        switch(MyDirect){
            case Up:
                Y--;
                break;
            case Down:
                Y++;
                break;
            case Left:
                X--;
                break;
            case Right:
                X++;
                break;
            default:
                break;
        }
        //Checks if snakes head has hit part of the tail
        for(int i = 0; i < Length; i++){
            if(X == PrevX[i] && Y == PrevY[i]){
                throw new GameOver();
            }
        }
        /*
        Checks the size of the current graphics window and if the snake
        goes outside of it gives the player a game over
        */
        if(X >= ThisWindow.Width/ThisWindow.Scale || Y >= ThisWindow.Height/ThisWindow.Scale){
            throw new GameOver();
        }
        if(X<0 || Y<0){
            throw new GameOver();
        }
    }
    //Adds to the length so that the user doesn't have direct write permmission
    public void AddToLength(){
        Length++;
    }
    //Allows the user to read from X
    public byte GetX(){
        return X;
    }
    //allows the user to read from Y
    public byte GetY(){
        return Y;
    }
    //Allows the user to read from the index of previous X locations
    public byte GetIndxX(int i){
        return PrevX[i];
    }
    //Allows the user to read from the index of previous Y locations
    public byte GetIndxY(int i){
        return PrevY[i];
    }
    //Allows the user to read from the length
    public byte GetLength(){
        return Length;
    }
}
