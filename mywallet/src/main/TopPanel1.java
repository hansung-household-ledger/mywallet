package main;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class TopPanel1 extends JPanel {
   //날짜
   SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일");
   Date time = new Date();
   String time1 = format1.format(time); 

   ImageIcon icon;
   private JLabel percent = new JLabel("5%");
   private JLabel balance = new JLabel("$950,000 남음");
   private JLabel perDay = new JLabel("$33,333");
   private JLabel date = new JLabel(time1);
   private JLabel onToday = new JLabel("현재까지 $50,000");
   private JLabel yester = new JLabel("어제 $0");
   private JLabel currentMonth = new JLabel("이번달 현재까지 $50,000");
   private JLabel lastMonth = new JLabel("지난달 $0");
   
   public TopPanel1() {
      setLayout(null);
      icon = new ImageIcon("./image/bgImg.png");
      
      percent.setSize(600, 100);
      percent.setLocation(50, 50);
      perDay.setOpaque(false);
      percent.setForeground(Color.WHITE);
      percent.setFont(new Font("고딕",Font.BOLD,50));
      add(percent);
   
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

      date.setSize(750, 50);
      date.setLocation(200,350);
      date.setOpaque(false);
      date.setBackground(Color.GRAY);
      date.setForeground(Color.BLACK);
      date.setFont(new Font("고딕",Font.BOLD,40));
      add(date);
   
      onToday.setSize(600, 100);
      onToday.setLocation(50,450);
      perDay.setOpaque(false);
      onToday.setForeground(Color.WHITE);
      onToday.setFont(new Font("고딕",Font.BOLD,40));
      add(onToday);
      
      yester.setSize(600, 80);
      yester.setLocation(50,550);
      perDay.setOpaque(false);
      yester.setForeground(Color.WHITE);
      yester.setFont(new Font("고딕",Font.BOLD,40));
      add(yester);
      
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