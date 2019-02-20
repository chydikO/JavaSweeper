import javax.swing.*;
import java.awt.*;
import Sweeper.Box;
import Sweeper.Coord;
import Sweeper.Ranges;

public class JavaSweeper extends JFrame {

    private final int COLS = 9;
    private final int ROWS = 9;

    private final int IMAGE_SIZE = 50;
    private JPanel panel;

    public static void main(String[] args) {
        new JavaSweeper();
    }

    private JavaSweeper() {

        Ranges.setSize(COLS,ROWS);
        setImages();
        initPanel();
        initFrame();
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaSweeter");
        setVisible(true);
        setResizable(false);
        setSize(300,100);
        pack();
        setLocationRelativeTo(null);
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCoords()) {
                    g.drawImage((Image) Box.BOMB.image,
                                IMAGE_SIZE * coord.x,
                                IMAGE_SIZE * coord.y,
                                this);
                }
            }
        };
        panel.setPreferredSize(new Dimension(
                                                Ranges.getSize().x * IMAGE_SIZE,
                                                Ranges.getSize().y * IMAGE_SIZE));
        add(panel);
    }

    /*
        Устанавливаем картинку для каждго перечисления
     */
    private void setImages() {
        for (Box box: Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }

    private Image getImage(String name) {
        String filename = "img/" + name + ".png";
        return new ImageIcon(getClass().getResource(filename)).getImage();
    }
}
