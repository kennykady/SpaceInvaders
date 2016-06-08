package Kenny;

import static Kenny.Constants.gameWidth;
import static Kenny.Constants.insets;

/**
 * Created by 10009354 on 6/2/2016.
 */
public class Alien
{
    private int xPos, yPos, points;
    private String name;
    private Alien[][] army = new Alien[10][6];

    public Alien(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;

        points = 200;
        name = "n";
    }

    public Alien(int i, int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;

        if (i == 1)
        {
            points = 250;
            name = "m";
        }
        if (i == 2)
        {
            points = 500;
            name = "u";
        }
    }

    public Alien()
    {

    }

    public void createArmy()
    {
        int startX = insets;
        int startY = 45;

        for(int x = 0; x < 10; x++)
            for(int y = 0; y < 6; y++)
            {
                if (x == 0)
                    startX = insets + 35;
                if (x == 1)
                    startX = insets + 70;
                if (x == 2)
                    startX = insets + 105;
                if (x == 3)
                    startX = insets + 140;
                if (x == 4)
                    startX = insets + 175;
                if (x == 5)
                    startX = insets + 210;
                if (x == 6)
                    startX = insets + 245;
                if (x == 7)
                    startX = insets + 275;
                if (x == 8)
                    startX = insets + 310;
                if (x == 9)
                    startX = insets + 345;

                if (y == 0)
                    startY = insets + 35;
                if (y == 1)
                    startY = insets + 50;
                if (y == 2)
                    startY = insets + 65;
                if (y == 3)
                    startY = insets + 80;
                if (y == 4)
                    startY = insets + 95;
                if (y == 5)
                    startY = insets + 110;

                army[x][y] = new Alien(startX,startY);
            }
    }

    public void move()
    {

    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getPoints() {
        return points;
    }

    public void setXPos(int a)
    {
        xPos = a;
    }

    public void setYPos(int a)
    {
        yPos = a;
    }

    public Alien[][] getArmy()
    {
        return army;
    }
}
