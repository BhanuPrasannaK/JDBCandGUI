import javax.swing.*;
import java.awt.*;

public class ForegroundColorFrame {
    public static void main(String[] args) {
        // Create a new JFrame instance
        JFrame frame = new JFrame("Foreground Color Frame");

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(400, 300);

        // Create a JLabel with some text
        JLabel label = new JLabel("Hello, World!");

        // Change the foreground color of the JLabel
        label.setForeground(Color.RED); // You can choose any color you like

        // Add the JLabel to the frame's content pane
        frame.getContentPane().add(label);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        //Change Background color of the frame to CYAN
        frame.getContentPane().setBackground(Color.CYAN);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}

/*
Basic Colors:
Color.BLACK
Color.BLUE
Color.CYAN
Color.DARK_GRAY
Color.GRAY
Color.GREEN
Color.LIGHT_GRAY
Color.MAGENTA
Color.ORANGE
Color.PINK
Color.RED
Color.WHITE
Color.YELLOW

Custom Colors
If you need a color that is not predefined, 
you can create a custom color using the Color constructor that takes RGB values:

Color customColor = new Color(r, g, b);
r (red): An integer value between 0 and 255.
g (green): An integer value between 0 and 255.
b (blue): An integer value between 0 and 255.
 
import javax.swing.*;
import java.awt.*;

public class CustomColorsFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Colors Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a custom color using RGB values
        Color customColor = new Color(128, 0, 128); // RGB for purple

        // Set background color using the custom color
        frame.getContentPane().setBackground(customColor);

        frame.setVisible(true);
    }
}

*/
