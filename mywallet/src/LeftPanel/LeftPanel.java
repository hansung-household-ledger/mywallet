package LeftPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ListData;
import model.UserData;

public class LeftPanel extends JPanel {
   //날짜
   SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일");
   Date time = new Date();
   String time1 = format1.format(time); 
   
   static String ddaycount="처음만난 날 입력해주세요";
   
   String columnNames[] =
		{ "지출/수입", "유형", "금액" };

   public ListData rowData[] = new ListData[10];
  

   public DefaultTableModel defaultTableModel = new DefaultTableModel(new String[] { "요일", "지출/수입", "유형", "금액" }, 0) {
		@Override
		public boolean isCellEditable(int row, int column)
		{
			return false;
		}
		
	};
	
   ImageIcon icon;
   public JLabel percent = new JLabel("5%");
   public JLabel balance = new JLabel("$950,000 남음");
   public JLabel perDay = new JLabel("$33,333");
   public JLabel date = new JLabel(time1);
   public JLabel onToday = new JLabel("잔액 $50,000");
   public JLabel yester = new JLabel("지출 누적 금액 $0");
   public JLabel currentMonth = new JLabel("수입 누적 금액 $50,000");
   public JLabel lastMonth = new JLabel("지난달 $0");
   public JTable jTable = new JTable(defaultTableModel);
   JScrollPane jScollPane = new JScrollPane(jTable);
   private JButton ddayIn = new JButton(new ImageIcon("./image/dday.png"));
   private static JLabel dday = new JLabel();
   private JLabel love = new JLabel(new ImageIcon("./image/love.png"));
   public LeftPanel(UserData userData) {
      setLayout(null);
      icon = new ImageIcon("./image/bgImg.png");
      

      love.setLocation(475, 25);
      love.setSize(300,300);
      add(love);
      
      ddayIn.setSize(250,52);
      ddayIn.setLocation(0, 900);
      ddayIn.setFont(new Font("맑은고딕", Font.BOLD, 25));
      add(ddayIn);
      
      dday.setText(ddaycount);
	  dday.setSize(600, 100);
	  dday.setLocation(250,370);
	  dday.setOpaque(false);
	  dday.setForeground(Color.GRAY);
	  dday.setFont(new Font("고딕",Font.BOLD,20));
	  add(dday);
	  
	  percent.setSize(600, 100);
      percent.setLocation(50, 50);
      percent.setOpaque(false);
      percent.setForeground(Color.WHITE);
      percent.setFont(new Font("고딕",Font.BOLD,50));
      add(percent);
   
      balance.setText("$"+Integer.toString(userData.getTotalMoney())+"남음");
      balance.setSize(600,100);
      balance.setLocation(50,150);
      balance.setOpaque(false);
      balance.setForeground(Color.WHITE);
      balance.setFont(new Font("고딕",Font.BOLD,20));
      add(balance);
   
      perDay.setSize(600, 100);
      perDay.setLocation(50,250);
      perDay.setOpaque(false);
      perDay.setForeground(Color.WHITE);
      perDay.setFont(new Font("고딕",Font.BOLD,20));
      add(perDay);

      date.setSize(600, 50);
      date.setLocation(200,350);
      date.setOpaque(false);
      date.setBackground(Color.GRAY);
      date.setForeground(Color.BLACK);
      date.setFont(new Font("고딕",Font.BOLD,40));
      add(date);
   
      onToday.setText("잔액 $"+userData.getTotalMoney());
      onToday.setSize(600, 100);
      onToday.setLocation(50,450);
      onToday.setOpaque(false);
      onToday.setForeground(Color.WHITE);
      onToday.setFont(new Font("고딕",Font.BOLD,40));
      add(onToday);
      
      yester.setText("지출 누적 금액 $"+userData.getOutcomeMoney());
      yester.setSize(600, 80);
      yester.setLocation(50,550);
      yester.setOpaque(false);
      yester.setForeground(Color.WHITE);
      yester.setFont(new Font("고딕",Font.BOLD,40));
      add(yester);
      
      currentMonth.setText("수입 누적 금액 $"+userData.getIncomeMoney());
      currentMonth.setSize(600, 80);
      currentMonth.setLocation(50,630);
      currentMonth.setOpaque(false);
      currentMonth.setForeground(Color.WHITE);
      currentMonth.setFont(new Font("고딕",Font.BOLD,40));
      add(currentMonth);
      
      lastMonth.setSize(600, 80);
      lastMonth.setLocation(50,710);
      lastMonth.setOpaque(false);
      lastMonth.setForeground(Color.WHITE);
      lastMonth.setFont(new Font("고딕",Font.BOLD,40));
      add(lastMonth);
      

      ddayIn.addActionListener(new ActionListener() {
   	   @Override
   	   public void actionPerformed(ActionEvent e) {
   		   Object obj = e.getSource();
   		   if((JButton) obj ==ddayIn) {
   			   final Frame fs =new DDayFrame();
   			   /*fs.addWindowListener(new WindowAdapter() {
   				   public void windowClosing(WindowEvent e) {
   					   fs.dispose();
   			   	   }
   			   });*/
   			   fs.setLocation(500, 500);
   		   }
   	   	}
      });

      jScollPane.setSize(300, 200);
      jScollPane.setLocation(350,710);
      add(jScollPane);
   }
   
   public void paintComponent(Graphics g) {
      g.drawImage(icon.getImage(),0,0,null);
      setOpaque(false);
      super.paintComponent(g);
   }
   
   public static void getDday(int count) {
	   ddaycount = Integer.toString(count);
	   if(count<=0) {
		   ddaycount = "틀린 날짜입니다. 다시 입력해주세요";
		   dday.setText(ddaycount);
	   }
	   else {
		   ddaycount = Integer.toString(count); 
		   dday.setForeground(Color.RED);
		   dday.setFont(new Font("고딕",Font.BOLD,40));
		   dday.setLocation(150,380);
		   dday.setText("♥ ♥ "+ddaycount +"일째 연애중"+ " ♥ ♥");
	   }
   }
}