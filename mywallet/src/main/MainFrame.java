package main;

import java.awt.*;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

    public MainFrame() {
        setTitle("팀 프로젝트(가계부)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2000, 2000);
        setVisible(true);
        Container c = getContentPane();

        // 배치 관리자
        c.setLayout(new BorderLayout());
        // panel 추가 부분 (예시)
//        add(menuPanel, BorderLayout.NORTH);

    }
    
	public static void main(String[] args) {
		new MainFrame();

	}

}
