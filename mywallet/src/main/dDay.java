package main;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class dDay extends JFrame {
	JTextField yyyy;
	JTextField mm;
	JTextField dd;
	JButton okey = new JButton("확인");
	public dDay() {
		setTitle("Dday 입력해주세요");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("연도"));
		yyyy=new JTextField(5);
		c.add(yyyy);
		
		c.add(new JLabel("월"));
		mm=new JTextField(5);
		c.add(mm);
		
		c.add(new JLabel("일"));
		dd=new JTextField(5);
		c.add(dd);
		

		c.add(okey);
		setSize(300,150);
		setVisible(true);
		
		okey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String myear = yyyy.getText();	
		   		String mmonth = mm.getText();
			    String mday = dd.getText();
			    int a = caldate(myear,mmonth,mday);
			    TopPanel1.getDday(a);
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
