import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class SnakeGame extends JPanel{
    private class Tile {
        int x;
        int y;

        Tile(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    int boardWidth;
    int boardHeight;
    int tileSize=25;
    //snake
    Tile snakeHead;

    //food
    Tile food;
    Random random;


    SnakeGame(int boardWidth,int boardHeight){
        this.boardHeight=boardHeight;
        this.boardWidth=boardWidth;
        setPreferredSize(new Dimension(this.boardWidth,this.boardHeight));
        setBackground(Color.black);

        snakeHead=new Tile(5,5);
        food=new Tile(10,10);
        random=new Random();
        placeFood();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        //grid
        for(int i=0;i< boardWidth/tileSize;i++){
            g.drawLine(i*tileSize,0,i*tileSize, boardHeight);
            g.drawLine(0,i*tileSize, boardWidth,i*tileSize);
        }
        //food
        g.setColor(Color.green);
        g.fillRect(food.x*tileSize,food.y*tileSize,tileSize,tileSize);
        //snake
        g.setColor(Color.white);
        g.fillRect(snakeHead.x*tileSize,snakeHead.y*tileSize,tileSize,tileSize);
    }
    public void placeFood(){
        food.x= random.nextInt(boardWidth/tileSize);
        food.y= random.nextInt(boardHeight/tileSize);
    }
}
