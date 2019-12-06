package main;

import java.awt.*;

import javax.swing.JFrame;

import myGraph.GraphPanel;

public class MainFrame extends JFrame{

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
        GraphPanel graphPanel = new GraphPanel();
        add(graphPanel);

    }
    
	public static void main(String[] args) {
		new MainFrame();

	}

}
