package main;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame{
	private JLabel label[] = new JLabel[4];
	
    public MainFrame() {
        setTitle("mywallet project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2000, 2000);
        setVisible(true);
        Container c = getContentPane();

        // batch 
        c.setLayout(new BorderLayout());
        // add panel example
//        add(menuPanel, BorderLayout.NORTH);
        c.add(new TopPanel1());
    }
    
	public static void main(String[] args) {
		new MainFrame();

	}
}
