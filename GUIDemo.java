import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIDemo {
    JTextField jtfi;
    JTextField jtfo;
    static final int W=400;
    static final int H=300;
    JFrame frame =new JFrame();
    public GUIDemo(){   
        
        frame.setTitle("CardLayout");
        frame.setSize(W,H);
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        
        // setLayout(new GridLayout());  
        // for (int i = 1; i < 12; i++) {  
        //     add(new JButton("Button " + i));  
        // } 

        // setLayout(new BorderLayout());
        // add(new JButton("North"), BorderLayout.NORTH);
        // add(new JButton("South"), BorderLayout.SOUTH);
        // add(new JButton("East"), BorderLayout.EAST);
        // add(new JButton("Center"), BorderLayout.CENTER);
        // add(new JButton("West"), BorderLayout.WEST);
        
        frame.setLayout(new FlowLayout());

        


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createContent();

        frame.setVisible(true);       
    }
    void createContent(){
        
        JLabel jl1=new JLabel("Enter a number ");
        jl1.setForeground(Color.RED);
        frame.getContentPane().add(jl1);
        
        jtfi=new JTextField(6);
        jtfi.setForeground(Color.black);
        frame.getContentPane().add(jtfi);

        JLabel jl2=new JLabel("Factorial is ");
        jl2.setForeground(Color.RED);
        frame.getContentPane().add(jl2);

        jtfo=new JTextField(10);
        jtfo.setForeground(Color.black);
        frame.getContentPane().add(jtfo);

        JButton jb=new JButton("Compute");
        jb.setForeground(Color.RED);
        frame.getContentPane().add(jb);

        frame.getContentPane().setBackground(Color.CYAN);

        
        MyListener ml1=new MyListener();
        jb.addActionListener(ml1);
        
    }
    private class MyListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            String s=jtfi.getText();
            int n,f;
            try{
                n=Integer.parseInt(s);
                f=1;
                for(int i=1;i<=n; ++i){
                    f=f*i;
                }
                jtfo.setText(Integer.toString(f));

                JLabel jl3=new JLabel("Successfully Completed ");
                frame.add(jl3);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String []args){
        new GUIDemo();
    }
}