package LeftPanel;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

class DDayFrame extends JFrame{
	String yyyy,mm,dd;
	JComboBox<String> year;
	JComboBox<String> month;
	JComboBox<String> date;
	String yearList[] = {"연","2010","2011","2012","2013","2014","2015",
			"2016","2017","2018","2019","2020","2021"};
	String monthList[]= {"월","1","2","3","4","5","6","7","8","9","10","11","12"};
	String dateList[] = {"일","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	JButton okey = new JButton("확인");
	
	public DDayFrame() {
		
		setSize(200,200);
		setVisible(true);
		setTitle("Dday 입력해주세요");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		year = new JComboBox(yearList);
		month = new JComboBox(monthList);
		date = new JComboBox(dateList);
		c.add(year);
		c.add(month);
		c.add(date);
		c.add(okey);
		
		year.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yyyy = year.getSelectedItem().toString();
			}
		});
		month.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mm = month.getSelectedItem().toString();
			}
		});
		date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dd = date.getSelectedItem().toString();
			}
		});
		okey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    int a = caldate(yyyy,mm,dd);
			    LeftPanel.getDday(a);
		   		dispose();
		   	}
		});
	}
	public int caldate(String myear,String mmonth, String mday) {
		int y = Integer.parseInt(myear);
		int m = Integer.parseInt(mmonth)-1;
		int d = Integer.parseInt(mday);
		try {
			Calendar today = Calendar.getInstance();
			Calendar dday = Calendar.getInstance();
			dday.set(y,m,d);
			
			long day =dday.getTimeInMillis()/86400000;
			long tday = today.getTimeInMillis()/86400000;
			long count = tday-day;
			
			return (int)count+1;
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
}