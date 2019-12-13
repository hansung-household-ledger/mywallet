package main;

import java.awt.*;
import java.sql.Connection;

import javax.swing.*;

import RightFrame.MyRightPanel;
import config.DBconnection;
import dao.InputDataDao;
import myGraph.GraphPanel;

public class MainFrame extends JFrame{
	public static String detail1[] = {"A","B"};
	public static String detail2[] = {"식비", "문화생활", "쇼핑", "기타"};
	
	
	
	GraphPanel graphPanel = null;
	MyRightPanel RP = null;
	TopPanel1 tp = new TopPanel1();
	
    public MainFrame() {
        setTitle("mywallet project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);
        Container c = getContentPane();
        graphPanel = new GraphPanel(this);
        RP = new MyRightPanel(this);
        // batch 
        c.setLayout(new GridLayout(1,2));
        // add panel example
//        add(menuPanel, BorderLayout.NORTH);

        c.add(tp);

        
        RP.setSize(600, 1000);
        RP.setLocation(600,0);
        RP.setBackground(new Color(250,255,184));
        add(RP);


        DBconnection db = new DBconnection();
        Connection conn = db.getConnection();
        InputDataDao inputDataDao = new InputDataDao();
        inputDataDao.productSelectAll(db,conn);
//        add(graphPanel);
    }
    
    public void change(String panelName) {
    	if(panelName.equals("graphPanel")) {
    		getContentPane().removeAll();
    		getContentPane().add(graphPanel);
    		revalidate();
    		repaint();
    	} else {
    		getContentPane().removeAll();
    		getContentPane().add(tp);
    		getContentPane().add(RP);
    		revalidate();
    		repaint();
    	}
    }
    
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();

	}
}


