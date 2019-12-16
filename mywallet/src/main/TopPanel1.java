package main;

import javax.swing.*;

import model.UserData;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TopPanel1 extends JPanel {
   //날짜
   SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일");
   Date time = new Date();
   String time1 = format1.format(time); 

   ImageIcon icon;
   public JLabel percent = new JLabel("5%");
   public JLabel balance = new JLabel("$950,000 남음");
   public JLabel perDay = new JLabel("$33,333");
   public JLabel date = new JLabel(time1);
   public JLabel onToday = new JLabel("잔액 $50,000");
   public JLabel yester = new JLabel("지출 누적 금액 $0");
   public JLabel currentMonth = new JLabel("수입 누적 금액 $50,000");
   public JLabel lastMonth = new JLabel("지난달 $0");
   
   public TopPanel1(UserData userData) {
      setLayout(null);
      icon = new ImageIcon("./image/bgImg.png");
      
      
      percent.setSize(600, 100);
      percent.setLocation(50, 50);
      perDay.setOpaque(false);
      percent.setForeground(Color.WHITE);
      percent.setFont(new Font("고딕",Font.BOLD,50));
      add(percent);
   
      balance.setText("$"+Integer.toString(userData.getTotalMoney())+"남음");
      balance.setSize(600,100);
      balance.setLocation(50,150);
      perDay.setOpaque(false);
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
      perDay.setOpaque(false);
      onToday.setForeground(Color.WHITE);
      onToday.setFont(new Font("고딕",Font.BOLD,40));
      add(onToday);
      
      yester.setText("지출 누적 금액 $"+userData.getOutcomeMoney());
      yester.setSize(600, 80);
      yester.setLocation(50,550);
      perDay.setOpaque(false);
      yester.setForeground(Color.WHITE);
      yester.setFont(new Font("고딕",Font.BOLD,40));
      add(yester);
      
      currentMonth.setText("수입 누적 금액 $"+userData.getIncomeMoney());
      currentMonth.setSize(600, 80);
      currentMonth.setLocation(50,630);
      perDay.setOpaque(false);
      currentMonth.setForeground(Color.WHITE);
      currentMonth.setFont(new Font("고딕",Font.BOLD,40));
      add(currentMonth);
      
      lastMonth.setSize(600, 80);
      lastMonth.setLocation(50,710);
      perDay.setOpaque(false);
      lastMonth.setForeground(Color.WHITE);
      lastMonth.setFont(new Font("고딕",Font.BOLD,40));
      add(lastMonth);
      
   }
   public void paintComponent(Graphics g) {
      g.drawImage(icon.getImage(),0,0,null);
      setOpaque(false);
      super.paintComponent(g);
   }
   
   
}