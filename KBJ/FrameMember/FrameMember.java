package FrameMember;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameMember extends JFrame{

	public FrameMember(){
		
		setBackground(Color.gray);
		setTitle("PCBuilder");
		setSize(800,600);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLogin = new JButton("로그인");
		JButton btnJoin = new JButton("회원가입");
		
		btnLogin.setBackground(Color.blue);
		btnJoin.setBackground(Color.blue);
		
		btnLogin.setSize(200,100);
		btnLogin.setLocation(((int)btnLogin.getSize().getWidth() /2),
							(int)btnLogin.getSize().getHeight() /2 + 100);
		btnLogin.setFont(new Font("굴림",Font.BOLD,26));
		
		btnJoin.setSize(200,100);
		btnJoin.setLocation(((int)btnLogin.getSize().getWidth() /2),
				(int)btnLogin.getSize().getHeight() /2 + 200);
		btnJoin.setFont(new Font("굴림",Font.BOLD,26));
		
		add(btnLogin);
		add(btnJoin);
		
		setVisible(true);
				
		/*btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//로그인 성공 후 메인페이지로 이동
				//FrameLBase.getInstance(new FrameLogin);
				
			}
		});
		
		btnJoin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//회원가입 페이지로 이동
				//FrameLBase.getInstance(new FrameJoin);
				
			}
		});		
		
	}*/
		
	}
	
	public static void main(String[] args) {
		new FrameMember();
	}
}
