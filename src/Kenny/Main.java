package Kenny;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;


public class Main extends Application implements Constants
{
    private Alien aliens = new Alien();
    private InputStream inputStream = null;
    private InputStream inptStream = null;
    private InputStream inpStream = null;
    private InputStream inputStr = null;
    private InputStream explode = null;
    private ArrayList<Bullet> shotsFired = new ArrayList<Bullet>();
    private InputHandler inputHandler = new InputHandler();
    private int score = 22000, internalTick = 0, tempTick = -10, tempTick2 = 0;
    Image img = new Image("http://wallpapercave.com/wp/pEeUsp1.jpg", gameWidth , gameHeight, false, false);
    ImageView imgView = new ImageView(img);

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("S P A C E  I N V A D E R S");
        Canvas canvas = new Canvas(450, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        StackPane root = new StackPane();
        root.getChildren().addAll(canvas);
        Scene scene = new Scene(root, 450, 500);
        scene.setOnKeyPressed(this::KeyPressed);
        scene.setOnKeyReleased(this::onKeyReleased);
        primaryStage.setScene(scene);
        gc.setFill(Color.CRIMSON);
        gc.fillRect(0 , 0, 500 , 500);
        primaryStage.show();

        try
        {
            inputStream = new FileInputStream(new File("./res/ship.png"));
            inptStream = new FileInputStream(new File("./res/playerBullet.png"));
            inpStream = new FileInputStream(new File("./res/alienUp.png"));
            inputStr = new FileInputStream(new File("./res/ufo.png"));
            explode = new FileInputStream(new File("./res/explosion.png"));
        } catch (FileNotFoundException e) {e.printStackTrace();}

        Image player = new Image(inputStream);
        Image bullet = new Image(inptStream);
        Image alien = new Image(inpStream);
        Image alienUp = new Image(inputStr);
        Image explosion = new Image(explode);

        aliens.createArmy();

        KeyFrame frame = new KeyFrame(Duration.millis(4f), (event) ->
        {
            internalTick ++;

            gc.setFill(Color.BLACK);
            gc.setStroke(Color.GRAY);
            gc.fillRect(insets , insets, gameWidth , gameHeight);
            gc.strokeRect(insets , insets, gameWidth , gameHeight);
            gc.fillText("Score: " , insets, 15);
            gc.setFill(Color.SNOW);
            gc.fillText(String.valueOf(score), insets + 35, 15);

            if(inputHandler.isInStack(KeyCode.A) && (guy.getXPos() > insets + 1))
                guy.incrementXPos(-2);
            if(inputHandler.isInStack(KeyCode.D) && (guy.getXPos() < gameWidth + 7))
                guy.incrementXPos(2);
            if(inputHandler.isInStack(KeyCode.SPACE))
            {
                if(internalTick >= tempTick + 15)
                {
                    shotsFired.add(new Bullet());
                    tempTick = internalTick;
                    //check for max int
                }
            }

            if(shotsFired.size() > 0)
            {
                for (int i = shotsFired.size() - 1; i >= 0; i--)
                {
                    gc.drawImage(bullet, shotsFired.get(i).getxPosPlayer(), shotsFired.get(i).getyPosPlayer());
                    shotsFired.get(i).moveBulletPLayer();
                    if (shotsFired.get(i).isOutOfBounds())
                    {
                        shotsFired.remove(i);
                    }
                }
            }

            for(int x = 0; x < 10; x ++)
            {

                for(int y = 0; y < 6; y++)
                {

                    if()
                    {
                        gc.drawImage(alienUp, aliens.getArmy()[x][y].getXPos(), aliens.getArmy()[x][y].getYPos());
                    }
                    else
                        gc.drawImage(alien, aliens.getArmy()[x][y].getXPos(), aliens.getArmy()[x][y].getYPos());

                }
            }

            gc.drawImage(player, guy.getXPos(), playerHeight);



        });

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(frame);
        timeline.play();
    }

    public Color getRandomColor()
    {
        int a = (int)(Math.random() * 5) + 1;

        if(a == 1)
            return Color.WHITE;
        if(a == 2)
            return Color.RED;
        if(a == 3)
            return Color.DARKCYAN;
        if(a == 4)
            return Color.CRIMSON;
        if(a == 5)
            return Color.GOLD;

        return Color.CRIMSON;
    }

    public void KeyPressed(KeyEvent e)
    {
        inputHandler.keyPressed(e);
    }

    public void onKeyReleased(KeyEvent e)
    {
        inputHandler.keyReleased(e);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
