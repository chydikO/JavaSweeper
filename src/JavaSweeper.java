import javax.swing.*;
import java.awt.*;
import Sweeper.Box;
import Sweeper.Coord;

public class JavaSweeper extends JFrame {

    private final int COLS = 15;
    private final int ROWS = 1;

    private final int IMAGE_SIZE = 50;
    private JPanel panel;

    public static void main(String[] args) {
        new JavaSweeper();
    }

    private JavaSweeper() {

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
                for (Box box : Box.values()) {
                    Coord coord = new Coord(box.ordinal(), 0);
                    g.drawImage((Image) box.image,
                                IMAGE_SIZE * coord.x,
                                IMAGE_SIZE * coord.y,
                                this);
                }
            }
        };
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
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
