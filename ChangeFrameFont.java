import javax.swing.*;
import java.awt.*;

public class ChangeFrameFont {
    public static void main(String[] args) {
        // Create a new JFrame instance
        JFrame frame = new JFrame("Font Change Frame");

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(400, 300);

        // Create components with default fonts
        JLabel label = new JLabel("Hello, World!");
        JButton button = new JButton("Click Me");
        JTextField textField = new JTextField("Type here");

        // Create a custom font
        Font customFont = new Font("Arial", Font.ITALIC, 20);

        // Apply the custom font to the components
        label.setFont(customFont);
        button.setFont(customFont);
        textField.setFont(customFont);

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1)); // Arrange components in a grid

        // Add components to the panel
        panel.add(label);
        panel.add(button);
        panel.add(textField);

        // Create labels with different font families
        JLabel serifLabel = new JLabel("This is Serif");
        JLabel sansSerifLabel = new JLabel("This is SansSerif");
        JLabel monospacedLabel = new JLabel("This is Monospaced");

        // Create fonts with different families
        Font serifFont = new Font("Serif", Font.PLAIN, 18);
        Font sansSerifFont = new Font("SansSerif", Font.BOLD, 18);
        Font monospacedFont = new Font("Monospaced", Font.ITALIC, 18);

        serifLabel.setFont(serifFont);
        sansSerifLabel.setFont(sansSerifFont);
        monospacedLabel.setFont(monospacedFont);

        // Create a panel and add labels to it
        // JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(serifLabel);
        panel.add(sansSerifLabel);
        panel.add(monospacedLabel);

        

        // Add the panel to the frame's content pane
        frame.getContentPane().add(panel);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}

/*
component.setFont(new Font(String fontName, int style, int size));

Font Styles:

Font.PLAIN: Regular text style.
Font.BOLD: Bold text style.
Font.ITALIC: Italic text style.
Font.BOLD | Font.ITALIC: Both bold and italic text styles.

Font Sizes:
Font sizes are specified in points (e.g., 12, 14, 18, 24). The size determines how large the text will appear.

 */

/*
 Common Font Families
1. Standard Java Fonts

Serif: A classic serif font.
SansSerif: A clean sans-serif font.
Monospaced: A fixed-width font commonly used for coding.

2. System-Specific Fonts
On different operating systems, additional font families might be available. For instance:

Windows: Fonts such as "Arial", "Calibri", "Times New Roman", "Courier New".
macOS: Fonts like "Helvetica", "Verdana", "Georgia", "Courier".
Linux: Fonts like "DejaVu Sans", "Liberation Serif", "Ubuntu", "Noto Sans".
 */