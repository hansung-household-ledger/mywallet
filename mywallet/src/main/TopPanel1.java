package main;

import java.awt.*;
import javax.swing.*;

class TopPanel1 extends JPanel {
	private JLabel percent = new JLabel("5%");
	private JLabel balance = new JLabel("$950,000 남음");
	private JLabel perDay = new JLabel("$33,333");
	private JLabel date = new JLabel("2019년 12월 2일 월요일");
	private JLabel onToday = new JLabel("현재까지 $50,000");
	private JLabel yester = new JLabel("어제 $0");
	private JLabel currentMonth = new JLabel("이번달 현재까지 $50,000");
	private JLabel lastMonth = new JLabel("지난달 $0");

	public TopPanel1() {
		setLayout(null);
		//setBackground(Color.BLUE);
	
		percent.setSize(1000, 100);
		percent.setLocation(50, 50);
		percent.setOpaque(true);
		percent.setBackground(Color.BLUE);
		percent.setForeground(Color.WHITE);
		percent.setFont(new Font("���",Font.BOLD,50));
		add(percent);
	
		balance.setSize(1000,100);
		balance.setLocation(50,150);
		balance.setOpaque(true);
		balance.setBackground(Color.BLUE);
		balance.setForeground(Color.WHITE);
		balance.setFont(new Font("���",Font.BOLD,20));
		add(balance);
	
		perDay.setSize(1000, 100);
		perDay.setLocation(50,250);
		perDay.setOpaque(true);
		perDay.setBackground(Color.BLUE);
		perDay.setForeground(Color.WHITE);
		perDay.setFont(new Font("���",Font.BOLD,20));
		add(perDay);

		date.setSize(1000, 50);
		date.setLocation(50,350);
		date.setOpaque(true);
		date.setBackground(Color.GRAY);
		date.setForeground(Color.BLACK);
		date.setFont(new Font("���",Font.BOLD,40));
		add(date);
	
		onToday.setSize(1000, 100);
		onToday.setLocation(50,450);
		onToday.setOpaque(true);
		onToday.setBackground(Color.BLUE);
		onToday.setForeground(Color.WHITE);
		onToday.setFont(new Font("���",Font.BOLD,40));
		add(onToday);
		
		yester.setSize(1000, 80);
		yester.setLocation(50,550);
		yester.setOpaque(true);
		yester.setBackground(Color.BLUE);
		yester.setForeground(Color.WHITE);
		yester.setFont(new Font("���",Font.BOLD,40));
		add(yester);
		
		currentMonth.setSize(1000, 80);
		currentMonth.setLocation(50,630);
		currentMonth.setOpaque(true);
		currentMonth.setBackground(Color.BLUE);
		currentMonth.setForeground(Color.WHITE);
		currentMonth.setFont(new Font("���",Font.BOLD,40));
		add(currentMonth);
		
		lastMonth.setSize(1000, 80);
		lastMonth.setLocation(50,710);
		lastMonth.setOpaque(true);
		lastMonth.setBackground(Color.BLUE);
		lastMonth.setForeground(Color.WHITE);
		lastMonth.setFont(new Font("���",Font.BOLD,40));
		add(lastMonth);
	}
}