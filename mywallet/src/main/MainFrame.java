package main;

import java.awt.*;
import java.sql.Connection;

import javax.swing.*;

import RightFrame.MyRightPanel;
import config.DBconnection;
import dao.*;
import model.UserData;
import myGraph.GraphPanel;

public class MainFrame extends JFrame{
	public static String detail1[] = {"월급","용돈","보너스","수당"};
	public static String detail2[] = {"교통비", "식비", "문화생활", "쇼핑", "커피", "의류", "경조사", "자기계발", "운동", "데이트"};
	
	
	UserData userData = new UserData();
	GraphPanel graphPanel = null;
	MyRightPanel RP = null;
	TopPanel1 tp = null;
	GetWalletDao getWalletDao = new GetWalletDao();
	
	
	
    public MainFrame() {
        setTitle("mywallet project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);
        Container c = getContentPane();
        getWalletDao.getWalletData(new DBconnection(), userData);
        graphPanel = new GraphPanel(this);
        tp = new TopPanel1(userData);
        RP = new MyRightPanel(this, userData, getWalletDao, tp);
        // batch 
        c.setLayout(new GridLayout(1,2));
        // add panel example
//        add(menuPanel, BorderLayout.NORTH);

        c.add(tp);

        
        RP.setSize(500, 1000);
        RP.setLocation(500,0);
//        RP.setBackground(new Color(120,255,0));
        add(RP);

        
   
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


