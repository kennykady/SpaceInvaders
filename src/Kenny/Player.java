package Kenny;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by 10009354 on 5/25/2016.
 */
public class Player implements Constants
{
    private int xPos = gameWidth/2, yPos= 450, lives;
    private GraphicsContext gc;

    public Player(GraphicsContext gc)
    {
        this.gc = gc;
    }

    public Player()
    {
    }

    public void incrementXPos(int a)
    {
        xPos += a;
    }

    public int getXPos() {
        return xPos;
    }

    public int getyPos() {
        return 350;
    }
}
