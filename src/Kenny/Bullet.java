package Kenny;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Bullet implements Constants
{
    private int yPosP = playerHeight, xPosP = guy.getXPos() + 7;

    public Bullet()
    {

    }

    public boolean isOutOfBounds()
    {
        if (yPosP <= 25)
            return true;

        return false;
    }

    public void moveBulletPLayer()
    {
        yPosP -= 3;
    }
    public int getxPosPlayer() {
        return xPosP;
    }

    public int getyPosPlayer() {
        return yPosP;
    }
}
