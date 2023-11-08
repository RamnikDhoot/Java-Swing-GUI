import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;

public class MyFrame extends JFrame {
    MyFrame() {
        this.setTitle("Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); // Change size of window, not allowed
        this.setSize(420, 420);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("images/notepad-icon.jpg");
        this.setIconImage(image.getImage()); // changes icon of this frame

        // this.getContentPane().setBackground(Color.blue); // Changes colour of
        // background

        JLabel label = new JLabel();
        label.setText("Example");
        this.add(label); // Adds the label to window
    }
}
