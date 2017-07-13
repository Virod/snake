package com.company;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by muhortova on 10.07.2017.
 */
public class MySnake {
    ArrayList<Point> points = new ArrayList<Point>();

    public MySnake(){
        Point point1 = new Point(160,200);
        Point point2 = new Point(180,200);
        Point point3 = new Point(200,200);
        points.add(point1);
        points.add(point2);
        points.add(point3);
    }

    public Point getPoint(int i){
        return points.get(i);
    }
    public int getSize(){
        return points.size();
    }
    public boolean moveUp(){
        points.remove(0);
        int x = getPoint(points.size() - 1).x;
        int y = getPoint(points.size() - 1).y - 20;

        Point newPoint = new Point(x, y);
        points.add(newPoint);
        return true;
    }
    public boolean moveDown(){
        points.remove(0);
        int x = getPoint(points.size() - 1).x;
        int y = getPoint(points.size() - 1).y + 20;

        Point newPoint = new Point(x, y);
        points.add(newPoint);
        return true;
    }
    public boolean moveLeft(){
        points.remove(0);
        int x = getPoint(points.size() - 1).x - 20;
        int y = getPoint(points.size() - 1).y;

        Point newPoint = new Point(x, y);
        points.add(newPoint);
        return true;
    }
    public boolean moveRight(){
        points.remove(0);
        int x = getPoint(points.size() - 1).x + 20;
        int y = getPoint(points.size() - 1).y;

        Point newPoint = new Point(x, y);
        points.add(newPoint);
        return true;
    }

    public void growUp(int x, int y) {
        points.add(new Point(x,y));
    }

}