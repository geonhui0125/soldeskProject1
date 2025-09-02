package FrameMember;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameLBase extends JFrame{

	private static FrameLBase instance;
	
	public FrameLBase(JPanel e) {
		
		//시스템 화면 정보
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		//기본 JFrame 구조
		setTitle("PC Builder");
		setLayout(null);
		setBounds(((int)tk.getScreenSize().getWidth())/2- 300,
				((int)tk.getScreenSize().getHeight())/2 -400,
				800,600);
		add(e);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void getInstance(JPanel e) {
		instance = new FrameLBase(e);
		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);
		instance.repaint();
		
	}
	
}
