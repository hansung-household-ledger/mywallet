package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

import RightFrame.MyRightPanel;
import config.DBconnection;
import dao.GetWalletDao;
import model.ListObjectdata;
import model.UserData;
import myGraph.GraphPanel;

public class MainFrame extends JFrame{
	public static String detail1[] = {"A","B"};
	public static String detail2[] = {"식비", "문화생활", "쇼핑", "기타"};
	
	
	UserData userData = new UserData();
	ListObjectdata listObjectData = new ListObjectdata();
	GraphPanel graphPanel = null;
	MyRightPanel RP = null;
	TopPanel1 tp = null;
	GetWalletDao getWalletDao = new GetWalletDao();
	
	
	
    public MainFrame() {
        setTitle("mywallet project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1800, 1000);
        setVisible(true);
        Container c = getContentPane();
        graphPanel = new GraphPanel(this);
        tp =  new TopPanel1(userData);
        getWalletDao.getwalletListDao(new DBconnection(), userData, tp, graphPanel, listObjectData);
        getWalletDao.getWalletData(new DBconnection(), userData, tp, graphPanel, listObjectData);
//        tp = new TopPanel1(userData);
        RP = new MyRightPanel(this, userData, getWalletDao, tp, graphPanel, listObjectData);
        // batch 
        c.setLayout(null);
        // add panel example
//        add(menuPanel, BorderLayout.NORTH);
        tp.setSize(800,1000);
        tp.setLocation(0, 0);
        add(tp);

        RP.setSize(1000, 1000);
        RP.setLocation(800,0);
        RP.setBackground(new Color(250,255,184));
        add(RP);
        
        graphPanel.setLocation(0, 0);
        graphPanel.setSize(1800, 1000);
        this.setResizable(false);
        
   
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


