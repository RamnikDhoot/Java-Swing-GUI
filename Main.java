import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setTitle("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // Change size of window, not allowed
        frame.setSize(420, 420);
        frame.setVisible(true);

    }
}