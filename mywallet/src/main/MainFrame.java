package main;

import java.awt.Container;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import GraphPanel.GraphPanel;
import LeftPanel.LeftPanel;
import RightPanel.MyRightPanel;
import RightPanel.SnowPanel;
import config.DBconnection;
import dao.GetWalletDao;
import model.ListObjectdata;
import model.UserData;

public class MainFrame extends JFrame{
	public static String detail1[] = {"A","B"};
	public static String detail2[] = {"식비", "문화생활", "쇼핑", "기타"};
	
	UserData userData = new UserData();
	ListObjectdata listObjectData = new ListObjectdata();
	GraphPanel graphPanel = null;
	MyRightPanel RP = null;
	LeftPanel tp = null;
	SnowPanel sp = null;
	GetWalletDao getWalletDao = new GetWalletDao();
	
    public MainFrame() {
    	play();
        setTitle("mywallet project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1800, 1000);
        setVisible(true);
        Container c = getContentPane();
        tp =  new LeftPanel(userData);
		sp = new SnowPanel();
        getWalletDao.getwalletListDao(new DBconnection(), userData, tp, listObjectData);
        getWalletDao.getDaysOutcomeMoneyDao(new DBconnection(), listObjectData);
        getWalletDao.getDaysIncomeMoneyDao(new DBconnection(), listObjectData);
        graphPanel = new GraphPanel(this, listObjectData);
        getWalletDao.getWalletData(new DBconnection(), userData, tp, graphPanel, listObjectData);
        
        RP = new MyRightPanel(this, userData, getWalletDao, tp, graphPanel, listObjectData);
        // batch 
        c.setLayout(null);

        tp.setSize(800,1000);
        tp.setLocation(0, 0);
        add(tp);

        RP.setSize(600, 1000);
        RP.setLocation(1200,0);
        add(RP);
        sp.setSize(400,1000);
        sp.setLocation(800, 0);
        add(sp);
        
        graphPanel.setLocation(0, 0);
        graphPanel.setSize(1800, 1000);

//        this.setResizable(false);
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
    		getContentPane().add(sp);
    		revalidate();
    		repaint();
    	}
    }
    
    public void play() {
        try {
//        	./image/Carol.wav
            File f = new File("./image/Carol.wav");

            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            Clip clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();

	}
}