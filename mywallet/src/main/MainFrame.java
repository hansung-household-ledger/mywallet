package main;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;

import RightFrame.MyRightPanel;

import myGraph.GraphPanel;

public class MainFrame extends JFrame{
	public static String detail1[] = {"월급","용돈","보너스","수당"};
	public static String detail2[] = {"교통비", "식비", "문화생활", "쇼핑", "커피", "의류", "경조사", "자기계발", "운동", "데이트"};
	public static Vector incoming = new Vector();
	public static Vector outgoing = new Vector();
	public static int allincoming;
	public static int alloutgoing;
	public static int now = allincoming - alloutgoing;
	
    public MainFrame() {
        setTitle("mywallet project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);
        Container c = getContentPane();

        // batch 
        c.setLayout(new GridLayout(1,2));
        // add panel example
//        add(menuPanel, BorderLayout.NORTH);

        c.add(new TopPanel1());

        MyRightPanel RP = new MyRightPanel();
        RP.setSize(500, 1000);
        RP.setLocation(500,0);
        RP.setBackground(new Color(120,255,0));
        add(RP);

        GraphPanel graphPanel = new GraphPanel();
//        add(graphPanel);

    }
	public static void main(String[] args) {
		new MainFrame();

	}
}


