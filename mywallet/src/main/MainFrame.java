package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import RightFrame.MyRightPanel;

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
        MyRightPanel RP = new MyRightPanel();
        RP.setSize(500, 1000);
        RP.setLocation(500,0);
        RP.setBackground(new Color(120,255,0));
        add(RP);
    }
	public static void main(String[] args) {
		new MainFrame();

	}

}


