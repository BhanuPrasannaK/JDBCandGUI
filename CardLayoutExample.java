import javax.swing.*;  
import java.awt.*;  
// import java.awt.event.ActionEvent;  
// import java.awt.event.ActionListener;  
public class CardLayoutExample {  
    public static void main(String[] args) {  
        JFrame frame = new JFrame("CardLayout Example");  
        CardLayout cardLayout = new CardLayout();  
        frame.setSize(400,300);
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        JPanel cardPanel = new JPanel(cardLayout);  
        JButton button1 = new JButton("Card 1");  
        JButton button2 = new JButton("Card 2");  
        JButton button3 = new JButton("Card 3");
        JButton button4 = new JButton("Card 4");  
        JButton button5 = new JButton("Card 5");  
        JButton button6 = new JButton("Card 6");  
        cardPanel.add(button1, "Card 1");  
        cardPanel.add(button2, "Card 2");  
        cardPanel.add(button3, "Card 3");  
        cardPanel.add(button6, "Card 6");  
        cardPanel.add(button5, "Card 5");  
        cardPanel.add(button4, "Card 4"); 
        frame.add(cardPanel);  
        // frame.pack();  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        button1.addActionListener(e -> cardLayout.show(cardPanel, "Card 2"));  
        button2.addActionListener(e -> cardLayout.show(cardPanel, "Card 4"));  
        button3.addActionListener(e -> cardLayout.show(cardPanel, "Card 5"));
        button4.addActionListener(e -> cardLayout.show(cardPanel, "Card 6"));  
        button5.addActionListener(e -> cardLayout.show(cardPanel, "Card 1"));  
        button6.addActionListener(e -> cardLayout.show(cardPanel, "Card 3"));  
    }  
}  