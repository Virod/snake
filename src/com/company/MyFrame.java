package com.company;

import javax.swing.*;

/**
 * Created by muhortova on 10.07.2017.
 */
public class MyFrame  extends JFrame {
    JFrame frame;
    MyFrame(){
        frame = new JFrame("Моя игра");
        frame.setSize(435,435);
        MyPanel panel=new MyPanel();
        frame.add(panel);
        frame.setResizable(false);//закон: Запретить изменять размер окна!
        frame.setVisible(true);
    }
}
