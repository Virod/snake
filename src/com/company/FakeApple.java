package com.company;

import java.awt.*;
import java.util.Random;

/**
 * Created by muhortova on 10.07.2017.
 */
public class FakeApple {
    Point point;

    public FakeApple()
    {
        setFakeApple();
    }

    public Point getPoint()
    {

        return point;
    }

    public void setFakeApple()
    {
        Random random = new Random();
        int x = random.nextInt(20)*20;
        int y = random.nextInt(20)*20;
        point = new Point(x,y);
    }
}
