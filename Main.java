import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setTitle("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setResizable(false); // Change size of window, not allowed
        // frame.setSize(420, 420); have frame.pack
        frame.setVisible(true);

        ImageIcon image = new ImageIcon("images/notepad-icon.jpg");
        frame.setIconImage(image.getImage()); // changes icon of frame frame

        // frame.getContentPane().setBackground(Color.blue); // Changes colour of
        // background

        JLabel label = new JLabel();
        label.setText("Example");
        label.setHorizontalTextPosition(JLabel.CENTER);// Sets the text center of IMAGE icon (label)
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("MV Boli", Font.PLAIN, 50));
        label.setIconTextGap(100);

        ImageIcon hundredIcon = new ImageIcon("images/100.png");
        label.setIcon(hundredIcon);

        Border Border = BorderFactory.createLineBorder(Color.green);
        label.setBorder(Border);

        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        // label.setBounds(0, 0, 400, 400);

        // frame.setLayout(null);
        frame.add(label); // Adds the label to window

        frame.pack();// automatically resizes components in window

    }
}