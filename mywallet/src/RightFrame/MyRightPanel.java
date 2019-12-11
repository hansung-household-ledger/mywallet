package RightFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MainFrame;
import main.MyActionListener;
import myGraph.GraphPanel;

public class MyRightPanel extends JPanel {
    	String a;
    	private JLabel label[] = new JLabel[3];
    	private JTextField tf = new JTextField();
    	//private String detail1[] = {"����","�뵷","���ʽ�","����"};
    	//private String detail2[] = {"�����", "�ĺ�", "��ȭ��Ȱ", "����", "Ŀ��", "�Ƿ�", "������", "�ڱ���", "�", "����Ʈ"};
    	
    	public static JComboBox<String> combo = new JComboBox(main.MainFrame.detail1);
    	
    	private JButton in = new JButton("수입");
    	private JButton out = new JButton("지출");
    	private JButton ok = new JButton("확인");
    	private JButton check = new JButton("통계확인");
    	

    	public MyRightPanel(MainFrame mainframe) {
			setLayout(null);
				in.setSize(100, 30);
				in.setLocation(40+120,60);
				in.setBackground(Color.MAGENTA);
				in.setForeground(Color.BLACK);
				in.setFont(new Font("�������", Font.ITALIC, 25));
				add(in);
				//in.addActionListener(new MyActionListener());
				out.setSize(100, 30);
				out.setLocation(40+220,60);
				out.setBackground(Color.BLUE);
				out.setForeground(Color.BLACK);
				out.setFont(new Font("�������", Font.ITALIC, 25));
				add(out);
				//out.addActionListener(new MyActionListener());
				label[0] = new JLabel("+0");
				label[0].setSize(60, 30);
				label[0].setLocation(40+210,120);
				label[0].setBackground(Color.MAGENTA);
				label[0].setForeground(Color.BLACK);
				label[0].setFont(new Font("�������", Font.ITALIC, 25));
				add(label[0]);
				label[1] = new JLabel("금액입력 : ");
				label[1].setSize(130, 30);
				label[1].setLocation(40+80,180);
				label[1].setBackground(Color.MAGENTA);
				label[1].setForeground(Color.BLACK);
				label[1].setFont(new Font("�������", Font.ITALIC, 25));
				add(label[1]);
				tf.setSize(200,30);
				tf.setLocation(270, 180);
				add(tf);
				label[2] = new JLabel(" 카테고리 : ");
				label[2].setSize(130, 30);
				label[2].setLocation(40+80,240);
				label[2].setBackground(Color.MAGENTA);
				label[2].setForeground(Color.BLACK);
				label[2].setFont(new Font("�������", Font.ITALIC, 25));
				add(label[2]);
				combo.setSize(200, 30);
				combo.setLocation(270, 240);
				add(combo);
				//combo.addActionListener(new MyActionListener());
				ok.setSize(100,30);
				ok.setLocation(230, 300);
				add(ok);
				check.setSize(200, 30);
				check.setLocation(180, 800);
				add(check);
				
				check.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {	
						mainframe.change("graphPanel");
					}     
		        });
		}
    }