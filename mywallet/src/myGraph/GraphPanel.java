package myGraph;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.MainFrame;

public class GraphPanel extends JPanel{
	
	
	private int[] outcome = {30, 40, 50, 60, 70, 80, 90, 100}; // 총 지출 
	private int[] income = {10, 20, 30, 40, 50, 60, 70, 80}; // 총 지출 
	
	int[] data = {10,20,30,40,50,60,70,80,90,20}; // 차트의 값 저장배열
	int[] arcAngle = new int[10];
	
	Color[] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE,Color.black, Color.cyan, Color.green,
			Color.pink, Color.white, Color.yellow};
	String[] itemName = {"교통비", "식비", "문화생활", "쇼핑", "커피", "의류", "경조사", "자기계발", "운동", "데이트"};
	
	private JLabel label = new JLabel("월별 내역");
	private JLabel label2 = new JLabel(new ImageIcon("./image/stats.png"));
	private JLabel label3 = new JLabel("지출 유형별 내역");
	private JRadioButton radiobutton1 = new JRadioButton("지출"); // 
	private JRadioButton radiobutton2 = new JRadioButton("수입");
	private JLabel totalMoney = new JLabel("지출합계 : ₩30,000 수입합계 : ₩50,000 남은 자산 ₩20,000");
	
	private JButton backButton = new JButton(new ImageIcon("./image/back.png"));

	public void setTotalMoney (int data1, int data2, int data3) {
		totalMoney.setText("지출합계 : ₩"+data1 +" 수입합계 : ₩"+data2 +" 남은 자산 ₩"+data3);
	}
	
	ChartPanel chartPanel = new ChartPanel(); // 원 차트패널
	DrawingPanel drawingPanel = new DrawingPanel(outcome, income);
		
	public GraphPanel (MainFrame mainframe) {
        setLayout(null);
        this.setBackground(new Color(250,255,184));
        backButton.setSize(134,30);
        backButton.setLocation(20, 10);
        add(backButton);
        
        label.setSize(120,30);
        label.setLocation(400, 100);
        label.setFont(label.getFont().deriveFont(20.0f));
        add(label);
        
        label2.setSize(562,142);
        label2.setLocation(620, 10);
        add(label2);
        
        label3.setSize(200,50);
        label3.setLocation(1200, 100);
        label3.setFont(label3.getFont().deriveFont(20.0f));
        add(label3);
        
        radiobutton1.setSize(60,30);
        radiobutton1.setLocation(600, 180);
        radiobutton1.setFont(radiobutton1.getFont().deriveFont(12.0f));
        add(radiobutton1);
        radiobutton1.setSelected(true);
        
        radiobutton2.setSize(60,30);
        radiobutton2.setLocation(700, 180);
        radiobutton2.setFont(radiobutton2.getFont().deriveFont(12.0f));
        add(radiobutton2);
        
        
        totalMoney.setSize(800,50);
        totalMoney.setLocation(600, 800);
        totalMoney.setFont(totalMoney.getFont().deriveFont(20.0f));
        add(totalMoney);

        chartPanel.setSize(700,250);
        chartPanel.setLocation(1000, 350);
        chartPanel.setBackground(new Color(0,189,255));
        add(chartPanel);
        
        drawingPanel.setSize(800,300);
        drawingPanel.setLocation(100,350);
        drawingPanel.setBackground(null);
        add(drawingPanel);
        
        drawChart(); // 차트 메소드 호출
        
        //radioButton1 actionListener
        radiobutton1.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {	
				radiobutton2.setSelected(false);
				drawingPanel.repaint(); // 차트패널의 PAINT호출
			}     
        });
        
      //radiobutton2 actionListener
        radiobutton2.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				radiobutton1.setSelected(false);
				drawingPanel.repaint(); // 차트패널의 PAINT호출
				
			}     
        });
        
        backButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {	
				mainframe.change("");
			}     
        });
        
	}
	
	
	
	void drawChart(){ // 차트를 그린다
		int sum=0; // 초기값 0
		for(int i=0;i<data.length;i++){ // 데이터 값만큼 루프
			sum+=data[i];
		}
		if(sum == 0) 
			return;
 
		for(int i=0;i<data.length;i++){ 
			arcAngle[i] = (int)Math.round((double)data[i]/(double)sum*360);
			chartPanel.repaint(); // 차트패널의 PAINT호출
		}
	}
	
	private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
	
	class ChartPanel extends JPanel{ // 차트 표시 패널
		 
		public void paintComponent(Graphics g){
 
			super.paintComponent(g);//부모 패인트호출
			int startAngle = 0;
			int z=0;
			for(int i=0;i<data.length;i++){
				if(i > 4) {
					g.setColor(color[i]);
					g.setFont(new Font("궁서", Font.BOLD, 15));
					drawString(g, itemName[i]+""+Math.round(arcAngle[i]*100/360)+"%\n", 50+z*100, 30);
					z++;
				} else {
					g.setColor(color[i]);
					g.setFont(new Font("궁서", Font.BOLD, 15));
					g.drawString(itemName[i]+""+Math.round(arcAngle[i]*100/360)+"%", 50+i*100, 20);
				}
			}
 
			for(int i=0;i<data.length;i++){
				g.setColor(color[i]);
				g.fillArc(150,50,200,200,startAngle,arcAngle[i]);
				startAngle = startAngle + arcAngle[i];
			}
		}
	}
	
	class DrawingPanel extends JPanel {
		
		private int[] outcome; // 총 지출 
		private int[] income;
		
		
		 public void paint(Graphics g) {
			 boolean check1 = radiobutton1.isSelected();
			 boolean check2 = radiobutton2.isSelected();
			 
			 g.clearRect(0,0,getWidth(),getHeight());
			 g.drawLine(50,250,750,250);
		 
			 for(int cnt = 1 ;cnt<11;cnt++) {
				 g.drawString(cnt *10 +"",25,255-20*cnt);
				 g.drawLine(50, 250-20*cnt, 750,250-20*cnt);
			 }
			 	if(check1 == true) {
			 		g.drawLine(50,20,50,250);
					 g.drawString("Mon",100,270);
					 g.drawString("Tue",200,270);
					 g.drawString("Wed",300,270);
					 g.drawString("Thu",400,270);
					 g.drawString("Fri",500,270);
					 g.drawString("Sat",600,270);
					 g.drawString("Sun",700,270);
					 g.setColor(Color.RED);
					 for(int i=0; i<outcome.length; i++) {
						 if(outcome[i] > 0)
							 g.fillRect(110+(100*i), 250-outcome[i]*2, 10, outcome[i]*2);
					 }
			 	} else if (check2 == true) {
			 		g.drawLine(50,20,50,250);
					 g.drawString("Mon",100,270);
					 g.drawString("Tue",200,270);
					 g.drawString("Wed",300,270);
					 g.drawString("Thu",400,270);
					 g.drawString("Fri",500,270);
					 g.drawString("Sat",600,270);
					 g.drawString("Sun",700,270);
					 g.setColor(Color.BLUE);
					 for(int i=0; i<income.length; i++) {
						 if(income[i] > 0)
							 g.fillRect(110+(100*i), 250-income[i]*2, 10, income[i]*2);
					 }
			 	}
		 }
		 
		 public DrawingPanel (int[] outcome, int[] income) {
			 this.outcome = outcome;
			 this.income = income;
		 }
		 
	}
	
	
}
