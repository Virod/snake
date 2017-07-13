package com.company;

import com.sun.deploy.uitoolkit.impl.fx.FXApplet2Adapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Random;

/**
 * Created by muhortova on 10.07.2017.
 */
public class MyPanel  extends JPanel {

    private int score;
    private ImageIcon icon;
    JPanel panel;
    MySnake snake;
    int X;
    int Y;
    int width = 20;
    int height = 20;
    MyApple apple;
    FakeApple FApple;

    public MyPanel(){
        icon = createIcon("/resourse/apple.jpg");
        createNewGame();
        // Регистрация приложения, как обработчика клавиатуры
        addKeyListener(new CustomKeyAdapter());
        // Установка фокуса мыши для панели
        setFocusable(true);
    }

    private ImageIcon createIcon(String s) {
        URL imgURL = Main.class.getResource(s);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found" + s);
            return null;
        }
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random random = new Random();

        g.setColor(new Color(0, 100, 100));

        g.fillRect(0, 0, getSize().width - 1, getSize().height - 1);

      //  g.setColor(new Color(0, 0, 0));
      // for(int i=0; i<(int)getSize().width/20; i++)
       //     g.drawLine(i*20, 0, i*20, getSize().width-1);
       // for(int i=0; i<(int)getSize().height/20; i++)
        //    g.drawLine(0, i*20, getSize().height - 1, i*20);
        g.setColor(new Color(53, 248, 255));
        g.drawString("Score:"+score, 0 , 20 );

        //g.drawImage(icon.getImage(),10,30,null);

        g.setColor(new Color(0, 0, 255));
        for(int i=0;i<snake.getSize();i++)
        {
            if(i==snake.getSize()-1){
                g.fillRect(snake.getPoint(snake.getSize()-1).x, snake.getPoint(snake.getSize()-1).y, 20, 20);
            }else{
                g.fillRect(snake.getPoint(i).x, snake.getPoint(i).y, 20, 20);
            }
        }
       g.setColor(new Color(255, 0, 0));
       //g.fillRect(apple.getPoint().x, apple.getPoint().y, 20, 20);
       g.drawImage(icon.getImage(),apple.getPoint().x, apple.getPoint().y,null);
        //while(count!=6) {
        for (int i=0; i<=10; i++){
            g.setColor(new Color(255, 0, 0));
            g.drawImage(icon.getImage(),width, height,null);
            //g.drawImage(icon.getImage(),10,20,null);

            width = random.nextInt(20)*20;
            height = random.nextInt(20)*20;

        }
//        g.drawImage(icon.getImage(), 90, 90, null);
       // g.setColor(new Color(255, 42, 44));
        //g.fillRect(FApple.getPoint().x, FApple.getPoint().y, 20, 20);
       // g.setColor(new Color(255, 42, 44));
       // g.fillRect(FApple.getPoint().x, FApple.getPoint().y, 20, 20);
    }

    private class CustomKeyAdapter extends KeyAdapter
    {
        public void keyPressed(KeyEvent e) {


            if(e.getKeyCode() == KeyEvent.VK_UP)
            {
                System.out.println("up");
                if( 0 > snake.getPoint(snake.getSize()-1).y - 20 ) gameOver();
                else
                if( stepOn() == false)
                {
                    snake.moveUp();
                    isEnd();
                }
                else{
                    score++;
                    snake.growUp(apple.getPoint().x,apple.getPoint().y);
                    apple.setNewApple();
                    FApple.setFakeApple();
                    isEnd();
                }
                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                System.out.println("down");
                if( getSize().height - 1 < snake.getPoint(snake.getSize()-1).y + 20 ) gameOver();
                else
                if( stepOn() == false)
                {
                    snake.moveDown();
                    isEnd();

                }
                else{
                    score++;
                    snake.growUp(apple.getPoint().x,apple.getPoint().y);
                    apple.setNewApple();
                    isEnd();
                }
                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                System.out.println("left");
                if( 0 > snake.getPoint(snake.getSize()-1).x - 20 ) gameOver();
                else
                if( stepOn() == false)
                {
                    snake.moveLeft();
                    isEnd();
                }
                else{
                    score++;
                    snake.growUp(apple.getPoint().x,apple.getPoint().y);
                    apple.setNewApple();
                    isEnd();
                }
                repaint();

            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                System.out.println("right");
                if( getSize().width - 1 < snake.getPoint(snake.getSize()-1).x + 20 ) gameOver();
                else
                if( stepOn() == false)
                {
                    snake.moveRight();
                    isEnd();
                }
                else{
                    score++;
                    snake.growUp(apple.getPoint().x,apple.getPoint().y);
                    apple.setNewApple();
                    isEnd();
                }
                repaint();

            }
        }
    }
    public boolean  stepOn()
    {
        int apple_x = apple.getPoint().x;
        int apple_y = apple.getPoint().y;
        int snake_x = snake.getPoint(snake.getSize()-1).x;
        int snake_y = snake.getPoint(snake.getSize()-1).y;
        if(apple_x == snake_x && apple_y == snake_y+20 || apple_x == snake_x && apple_y+20 == snake_y )
        {


            System.out.println("Doh !");
            return true;
        }else if(apple_x == snake_x+20 && apple_y == snake_y || apple_x+20 == snake_x && apple_y == snake_y) {
            System.out.println("Doh !");
            return true;
        }

        return false;
    }
    public void isEnd()
    {
        for(int i=0;i<snake.getSize()-1;i++)
        {
            if(snake.getPoint(i).x == snake.getPoint(snake.getSize()-1).x && snake.getPoint(i).y == snake.getPoint(snake.getSize()-1).y)
            {
                gameOver();
            }
        }
    }
    public void gameOver()
    {
        score=0;
        System.out.println("BooM* !");
        // need dialog window
        Object[] options = {"Yes, please",
                "No, thanks"};
        int n = JOptionPane.showOptionDialog(null,
                "Game over, try again?",
                "Game over Question",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if( n != 0) System.exit(0);
        createNewGame();
    }
    public void createNewGame()
    {
        snake = new MySnake();
        panel = new JPanel();
        X = Y = 200;
        apple = new MyApple();
        FApple = new FakeApple();
        //icon=new ImageIcon(getClass().getResource("/resources/1.png"));

    }
}
