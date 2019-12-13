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
import myGraph.GraphPanel;


public class MyRightPanel extends JPanel {
    	String a;
    	private JLabel label[] = new JLabel[3];
    	private JTextField tf = new JTextField();
    	public static JComboBox<String> combo = new JComboBox(MainFrame.detail1);
    	
    	private JButton in = new JButton("수입");
    	private JButton out = new JButton("지출");
    	private JButton ok = new JButton("확인");
    	private JButton check = new JButton("통계 확인하기");
    

    	public MyRightPanel(MainFrame mainframe) {
			setLayout(null);
				in.setSize(100, 30);
				in.setLocation(40+120,60);
				in.setBackground(Color.MAGENTA);
				in.setForeground(Color.BLACK);
				in.setFont(new Font("맑은고딕", Font.ITALIC, 25));

				add(in);
				out.setSize(100, 30);
				out.setLocation(40+220,60);
				out.setBackground(Color.BLUE);
				out.setForeground(Color.BLACK);
				out.setFont(new Font("맑은고딕", Font.ITALIC, 25));
				add(out);
				label[0] = new JLabel("0");
				label[0].setSize(200, 30);
				label[0].setLocation(40+210,120);
				label[0].setBackground(Color.MAGENTA);
				label[0].setForeground(Color.BLACK);
				label[0].setFont(new Font("맑은고딕", Font.ITALIC, 25));
				add(label[0]);

				label[1] = new JLabel("금액입력 : ");
				label[1].setSize(130, 30);
				label[1].setLocation(40+80,180);
				label[1].setBackground(Color.MAGENTA);
				label[1].setForeground(Color.BLACK);
				label[1].setFont(new Font("맑은고딕", Font.ITALIC, 25));
				add(label[1]);
				tf.setSize(200,30);
				tf.setLocation(270, 180);
				add(tf);
				label[2] = new JLabel(" 카테고리 : ");
				label[2].setSize(130, 30);
				label[2].setLocation(40+80,240);
				label[2].setBackground(Color.MAGENTA);
				label[2].setForeground(Color.BLACK);
				label[2].setFont(new Font("맑은고딕", Font.ITALIC, 25));
				add(label[2]);
				
				combo.setSize(200, 30);
				combo.setLocation(270, 240);
				add(combo);
				ok.setSize(100,30);
				ok.setLocation(230, 300);
				add(ok);
				check.setSize(200, 30);
				check.setLocation(180, 800);
				add(check);
				
				in.addActionListener( new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						combo.removeAllItems();
						for(int i=0; i<MainFrame.detail1.length; i++) {
							combo.addItem(MainFrame.detail1[i]);
						}
					}     
		        });
				
				
				out.addActionListener( new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent e) {
						combo.removeAllItems();
						for(int i=0; i<MainFrame.detail2.length; i++) {
							combo.addItem(MainFrame.detail2[i]);
						}
					}     
		        });
				ok.addActionListener( new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						label[0].setText(tf.getText());
						// db
					}
				});

				check.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {	
						mainframe.change("graphPanel");
					}     
		        });
    	}
    }
