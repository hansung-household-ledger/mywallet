package RightFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SnowPanel extends JPanel {
	private final int SNOWS = 60;
	private final int SNOW_SIZE = 10;
	private Vector<Point> snowVector = new Vector<Point>();
	ImageIcon icon;
	public SnowPanel() {
		icon = new ImageIcon("./image/merry.png");

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				addSnow();
				new SnowThread().start();
				SnowPanel.this.removeComponentListener(this);
			}				
		});
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(icon.getImage(),0,0,null);
		drawSnow(g); 

	}
	
	private void addSnow() {
		for(int i=0; i<SNOWS; i++) {
			Point p = new Point((int)(Math.random()*getWidth()), 
					(int)(Math.random()*getHeight()));
			snowVector.add(p);
		}
	}
	private void drawSnow(Graphics g) { 
		g.setColor(Color.WHITE);			
		for(int i=0; i<snowVector.size(); i++) {
			Point p = snowVector.get(i);
			g.fillOval(p.x, p.y, SNOW_SIZE, SNOW_SIZE);			
		}
	}
	
	private void changeSnowPosition() {
		for(int i=0; i<SNOWS; i++) {
			Point p = snowVector.get(i);
			int xDir = Math.random() > 0.5 ? 1 : -1;
			int offsetX = (int)(Math.random()*3)*xDir;
			int offsetY = (int)(Math.random()*7); 
			p.x += offsetX;
			if(p.x < 0) p.x = 0;
			p.y += offsetY;
			if(p.y > getHeight()) {
				p.x = (int)(Math.random()*getWidth());
				p.y = 5;
			}
		}		
	}
	class SnowThread extends Thread {
		@Override
		public void run() {
			while(true) {
				try {
					sleep(100);
				} catch (InterruptedException e) { return; }
				changeSnowPosition(); 
				SnowPanel.this.repaint(); 
			}
		}
	}
	
}