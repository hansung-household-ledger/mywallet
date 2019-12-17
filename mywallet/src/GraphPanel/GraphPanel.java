package GraphPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import main.MainFrame;
import model.ListData;
import model.ListObjectdata;

public class GraphPanel extends JPanel{
	
	
	public int[] outcome = new int[1]; // 총 지출 
	public int[] income = new int[1]; // 총 지출 
	
	
	int[] arcAngle = new int[10];
	
	Color[] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE,Color.black, Color.cyan, Color.green, Color.pink, Color.white, Color.yellow};
	String[] itemName = {"식비", "문화생활", "쇼핑", "기타"};
	
	private JLabel label = new JLabel(new ImageIcon("./image/month.png")); //월별내역
	private JLabel label2 = new JLabel(new ImageIcon("./image/stats.png")); //통계확인
	private JLabel label3 = new JLabel(new ImageIcon("./image/type.png")); //유형별내역
	private JRadioButton radiobutton1 = new JRadioButton("지출");
	private JRadioButton radiobutton2 = new JRadioButton("수입");
	private JLabel totalMoney = new JLabel("지출합계 : ₩30,000 수입합계 : ₩50,000 남은 자산 ₩20,000");
	
	private JButton backButton = new JButton(new ImageIcon("./image/back.png"));
	
	int[] data;
	
	public void setTotalMoney (int data1, int data2, int data3) {
		totalMoney.setText("지출합계 : ₩"+data1 +" 수입합계 : ₩"+data2 +" 남은 자산 ₩"+data3);
	}
	
	public ChartPanel chartPanel = new ChartPanel(); // 원 차트패널
	
	public GraphPanel (MainFrame mainframe, ListObjectdata listObjectData) {
		
        data = new int[]{listObjectData.food, listObjectData.culture, listObjectData.shopping, listObjectData.ect };
        outcome = new int[] {listObjectData.outweek[0],listObjectData.outweek[1],listObjectData.outweek[2],listObjectData.outweek[3],listObjectData.outweek[4],listObjectData.outweek[5],listObjectData.outweek[6]};
        income = new int[] {listObjectData.inweek[0], listObjectData.inweek[1], listObjectData.inweek[2], listObjectData.inweek[3], listObjectData.inweek[4], listObjectData.inweek[5], listObjectData.inweek[6]};
        DrawingPanel drawingPanel = new DrawingPanel(outcome, income);
        
        setLayout(null);
        this.setBackground(new Color(250,255,184));
        backButton.setSize(134,31);
        backButton.setLocation(20, 10);
        add(backButton);
        
        label.setSize(237,50);
        label.setLocation(400, 240);
        
        add(label);
        
        label2.setSize(562,164);
        label2.setLocation(620, 10);
        add(label2);
        
        label3.setSize(341,50);
        label3.setLocation(1150, 240);
        
        add(label3);
        
        radiobutton1.setSize(60,30);
        radiobutton1.setLocation(600, 300);
        radiobutton1.setBackground(new Color(250,255,184));

        add(radiobutton1);
        radiobutton1.setSelected(true);
        
        radiobutton2.setSize(60,30);
        radiobutton2.setLocation(700, 300);
        radiobutton2.setBackground(new Color(250,255,184));

        add(radiobutton2);
        
        
        totalMoney.setSize(800,50);
        totalMoney.setLocation(600, 800);
        totalMoney.setFont(new Font("바탕", Font.BOLD, 20));
        add(totalMoney);

        chartPanel.setSize(700,250);
        chartPanel.setLocation(1000, 350);
        chartPanel.setBackground(new Color(250,255,184));
        add(chartPanel);
        
        drawingPanel.setSize(800,300);
        drawingPanel.setLocation(100,350);
        drawingPanel.setBackground(new Color(250,255,184));
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
	
	
	
	
	public void drawChart(){ // 차트를 그린다
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
	
	public class ChartPanel extends JPanel{ // 차트 표시 패널
		 
		public void paintComponent(Graphics g){
 
			super.paintComponent(g);//부모 패인트호출
			int startAngle = 0;
			int z=0;
			for(int i=0;i<4;i++){
				if(i > 4) {
					g.setColor(color[i]);
					g.setFont(new Font("바탕", Font.BOLD, 15));
					drawString(g, itemName[i]+""+Math.round(arcAngle[i]*100/360)+"%\n", 50+z*100, 30);
					z++;
				} else {
					g.setColor(color[i]);
					g.setFont(new Font("바탕", Font.BOLD, 15));
					g.drawString(itemName[i]+""+Math.round(arcAngle[i]*100/360)+"%", 50+i*100, 20);
				}
			}
 
			for(int i=0;i<4;i++){
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
					 double total = 0;
					 for(int j=0; j<outcome.length; j++) {
						 total += outcome[j];
					 }
					 for(int i=0; i<outcome.length; i++) {
						 //Math.round(arcAngle[i]*100/360)
						 //일부값 ÷ 전체값 X 100
//						 outcome[i] / total*100
						 if(outcome[i] > 0) {
						 	 int percent = (int)((double)outcome[i] / (double)total * 100.0);
							 g.fillRect(110+(100*i), 250-percent, 10, (int)((double)outcome[i] / (double)total * 100.0));
						 }
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
					 double total2 = 0;
					 for(int j=0; j<income.length; j++) {
						 total2 += income[j];
					 }
					 for(int i=0; i<income.length; i++) {
						 if(income[i] > 0)
							 System.out.println((int)((double)income[i] / (double)total2 * 100.0));
							 g.fillRect(110+(100*i), 250-(int)((double)income[i] / (double)total2 * 100.0), 10, (int)((double)income[i] / (double)total2 * 100.0));
					 }
			 	}
		 }
		 
		 public DrawingPanel (int[] outcome, int[] income) {
			 this.outcome = outcome;
			 this.income = income;
		 }
		 
	}
	
	
}
