import javax.swing.*;
import java.awt.Image;
public class GameView extends JFrame {
    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_WIDTH = 1000;
    private Image[] diceImages;
    private Game g;

    public GameView(Game g) {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
