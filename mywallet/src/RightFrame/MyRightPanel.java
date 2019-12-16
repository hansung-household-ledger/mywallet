package RightFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.DBconnection;
import dao.GetWalletDao;
import dao.IdDataDao;
import dao.InsertDataDao;
import main.MainFrame;
import main.TopPanel1;
import model.UserData;
import myGraph.GraphPanel;


public class MyRightPanel extends JPanel {
    	String a;
    	private JLabel label[] = new JLabel[4];
    	private JTextField tf = new JTextField();
    	public static JComboBox<String> combo = new JComboBox(MainFrame.detail1);
    	
    	private JButton in = new JButton("수입");
    	private JButton out = new JButton("지출");
    	private JButton ok = new JButton(new ImageIcon("./image/ok.png"));
    	private JButton check = new JButton(new ImageIcon("./image/check.png"));
    	
    	int incomeOroutcome = 0; //in=0 out=1
    

    	public MyRightPanel(MainFrame mainframe, UserData userData, GetWalletDao getWalletDao, TopPanel1 tp,GraphPanel graphPanel) {
			setLayout(null);
				in.setSize(100, 30);
				in.setLocation(160,60);
				in.setBackground(Color.MAGENTA);
				in.setForeground(Color.BLACK);
				in.setFont(new Font("맑은고딕", Font.BOLD, 25));

				add(in);
				out.setSize(100, 30);
				out.setLocation(260,60);
				out.setBackground(Color.BLUE);
				out.setForeground(Color.BLACK);
				out.setFont(new Font("맑은고딕", Font.BOLD, 25));
				add(out);
				label[0] = new JLabel("0");
				label[0].setSize(240, 30);
				label[0].setLocation(240,120);
				label[0].setBackground(Color.MAGENTA);
				label[0].setForeground(Color.BLACK);
				label[0].setFont(new Font("맑은고딕", Font.BOLD, 25));
				add(label[0]);

				label[1] = new JLabel("금액입력 : ");
				label[1].setSize(130, 30);
				label[1].setLocation(120,180);
				label[1].setBackground(Color.MAGENTA);
				label[1].setForeground(Color.BLACK);
				label[1].setFont(new Font("맑은고딕", Font.BOLD, 25));
				add(label[1]);
				tf.setSize(200,30);
				tf.setLocation(270, 180);
				add(tf);
				label[2] = new JLabel("카테고리 : ");
				label[2].setSize(130, 30);
				label[2].setLocation(120,240);
				label[2].setBackground(Color.MAGENTA);
				label[2].setForeground(Color.BLACK);
				label[2].setFont(new Font("맑은고딕", Font.BOLD, 25));
				add(label[2]);
				label[3] = new JLabel(new ImageIcon("./image/couple.png"));
				label[3].setSize(512, 512);
				label[3].setLocation(20,380);
				add(label[3]);
				
				combo.setSize(200, 30);
				combo.setLocation(270, 240);
				add(combo);
				ok.setSize(100,53);
				ok.setLocation(230, 300);
		        ok.setBorderPainted(false);

				add(ok);
				check.setSize(200, 36);
				check.setLocation(180, 900);
				check.setBorderPainted(false);
				add(check);
				
				in.addActionListener( new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						combo.removeAllItems();
						for(int i=0; i<MainFrame.detail1.length; i++) {
							combo.addItem(MainFrame.detail1[i]);
						}
						incomeOroutcome = 0;
					}     
		        });
				
				tf.addKeyListener(new KeyListener() {
				        @Override
				        public void keyTyped(KeyEvent e) {
				        	label[0].setText(tf.getText());
				        }
				         
				        @Override
				        public void keyReleased(KeyEvent e) {
				        	label[0].setText(tf.getText());
				        }
				         
				        @Override
				        public void keyPressed(KeyEvent e) {
				        	label[0].setText(tf.getText());
				        }
				    });
				
				out.addActionListener( new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent e) {
						combo.removeAllItems();
						for(int i=0; i<MainFrame.detail2.length; i++) {
							combo.addItem(MainFrame.detail2[i]);
						}
						incomeOroutcome = 1;
					}     
		        });
				ok.addActionListener( new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						int money = Integer.parseInt(tf.getText());
						int type = incomeOroutcome;
						String category = combo.getItemAt(combo.getSelectedIndex());
						
						if(type == 0) {
							// 수입 
							InsertDataDao insertDataDao = new InsertDataDao();
					        insertDataDao.insertIncomeData(new DBconnection(), money, type, category);
					        insertDataDao.insertList(new DBconnection(), money, type, category);

						} else {
							// 지출
							InsertDataDao insertDataDao = new InsertDataDao();
							insertDataDao.insertOutcomeData(new DBconnection(), money, type, category);
					        insertDataDao.insertList(new DBconnection(), money, type, category);
						}
						getWalletDao.getWalletData(new DBconnection(), userData , tp, graphPanel);
						label[0].setText("0");
						tf.setText("0");
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
