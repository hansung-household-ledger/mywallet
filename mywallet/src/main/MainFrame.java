package main;

import java.awt.*;
import javax.swing.*;

import RightFrame.MyRightPanel;

import myGraph.GraphPanel;

public class MainFrame extends JFrame{
	public static String detail1[] = {"����","�뵷","���ʽ�","����"};
	public static String detail2[] = {"�����", "�ĺ�", "��ȭ��Ȱ", "����", "Ŀ��", "�Ƿ�", "������", "�ڱ���", "�", "����Ʈ"};

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
        add(graphPanel);

    }
	public static void main(String[] args) {
		new MainFrame();

	}
}


