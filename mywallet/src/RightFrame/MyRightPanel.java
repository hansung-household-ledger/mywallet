package RightFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

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
import model.ListObjectdata;
import model.UserData;
import myGraph.GraphPanel;


public class MyRightPanel extends JPanel {
    	String a;
    	private JLabel label[] = new JLabel[5];
    	private JTextField tf = new JTextField();
    	public static JComboBox<String> combo = new JComboBox(MainFrame.detail1);
    	
    	private JButton in = new JButton(new ImageIcon("./image/in1.png"));
    	private JButton out = new JButton(new ImageIcon("./image/out.png"));
    	private JButton ok = new JButton(new ImageIcon("./image/ok.png"));
    	private JButton check = new JButton(new ImageIcon("./image/check.png"));
    	
    	int incomeOroutcome = 0; //in=0 out=1
    	

    	public MyRightPanel(MainFrame mainframe, UserData userData, GetWalletDao getWalletDao, TopPanel1 tp,GraphPanel graphPanel, ListObjectdata listObjectData) {
			setLayout(null);
				in.setSize(100, 41);
				in.setLocation(170,60);
				

				add(in);
				out.setSize(100, 41);
				out.setLocation(270,60);
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
				label[4] = new JLabel(new ImageIcon("./image/merry.png"));
				label[4].setSize(400,1000);
				label[4].setLocation(600, 0);
		        add(label[4]);
				combo.setSize(200, 30);
				combo.setLocation(270, 240);
				add(combo);
				ok.setSize(100,53);
				ok.setLocation(230, 300);
				add(ok);
				check.setSize(200, 36);
				check.setLocation(180, 900);
				add(check);
				
				
				
				
				/*class SnowPanel extends JPanel {
					private final int SNOWS = 50;
					private final int SNOW_SIZE = 10;
					private Vector<Point> snowVector = new Vector<Point>(); // 눈 송이의 왼쪽 좌표 Point
					
					public SnowPanel() {
						this.addComponentListener(new ComponentAdapter() {
							@Override
							public void componentResized(ComponentEvent e) { // 패널의 위치와 크기가 설정되면 그 때 비로소 눈을 만든다.
								addSnow(); //눈을 만들고
								new SnowThread().start(); // 눈 내리는 스레드를 시작시킨다.
								SnowPanel.this.removeComponentListener(this); // 현재 패널에 적합하도록 눈을 만들면 리스너를 제거한다.
							}				
						});
					}
					
					@Override
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						drawSnow(g); // 눈을 그린다.
					}
					
					private void addSnow() { // 각 눈의 위치를 랜덤하게 생성하여 벡터에 삽입한다.
						for(int i=0; i<SNOWS; i++) {
							Point p = new Point((int)(Math.random()*getWidth()), 
									(int)(Math.random()*getHeight()));
							snowVector.add(p);
						}
					}
					private void drawSnow(Graphics g) { // 패널에 눈을 그린다.
						g.setColor(Color.WHITE);			
						for(int i=0; i<snowVector.size(); i++) {
							Point p = snowVector.get(i);
							g.fillOval(p.x, p.y, SNOW_SIZE, SNOW_SIZE);			
						}
					}
					
					private void changeSnowPosition() { // 눈의 위치를 조정한다. 
						for(int i=0; i<SNOWS; i++) {
							Point p = snowVector.get(i);
							int xDir = Math.random() > 0.5 ? 1 : -1; // xDir이 1이면 오른쪽으로, 아니면 왼쪽으로 눈을 이동시킨다.
							int offsetX = (int)(Math.random()*3)*xDir; // x 축으로 이동하는 최대 거리는 3 픽셀이다.
							int offsetY = (int)(Math.random()*7); // y 축으로 이동하는 최대 거리는 7 픽셀이다.
							p.x += offsetX;
							if(p.x < 0) p.x = 0;
							p.y += offsetY;
							if(p.y > getHeight()) { // 눈이 떨어져서 패널을 벗어나게 되면 다시 패널의 위에서 시작하게 한다.
								p.x = (int)(Math.random()*getWidth());  // 다시 시작하는 x 위치는 패널 내의 랜덤한 위치
								p.y = 5; // 다시 시작하는 y 위치는 패널 내의 5 픽셀 위치
							}
						}		
					}
					class SnowThread extends Thread {
						@Override
						public void run() {
							while(true) {
								try {
									sleep(300); // 0.3초마다 눈이 내린다.
								} catch (InterruptedException e) { return; }
								changeSnowPosition(); // 눈의 위치를 재조정한다.
								SnowPanel.this.repaint(); // 조정된 위치에 눈이 그려지도록 패널을 다시 그린다.
							}
						}
					}
				}
				*/
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
						getWalletDao.getWalletData(new DBconnection(), userData , tp, graphPanel, listObjectData);
						getWalletDao.getwalletListDao(new DBconnection(), userData, tp, graphPanel, listObjectData);
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