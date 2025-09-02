package FrameMember;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Member.MemberBuffer;
import Member.MemberInfo;
import Member.MemberJoin;
import TestRun.MainTest;

//Car 폴더 FrameJoin 참조
public class FrameJoin extends JPanel{
	
	static String fileName = "회원목록.txt";
	JPanel joinPanel;
	
	public FrameJoin(JPanel homePanel) {
		this.joinPanel = homePanel;
		
		//JPanel 구조
		setBackground(Color.gray);
		setLayout(null);
		setSize(900,600);
		
		//회원가입창
		JLabel lJoin = new JLabel("PC Builder");
		
		JTextField tfId = new JTextField(20);
		JPasswordField tfPw = new JPasswordField(20);
		JPasswordField tfPc = new JPasswordField(20);
	
		lJoin.setSize(300,40);
		lJoin.setLocation(getWidth() / 2 - 50, 60);
		lJoin.setFont(new Font("맑은고딕", Font.BOLD, 25));
		
		tfId.setSize(300,40);
		tfId.setLocation(300,150);
		tfId.setFont(new Font("맑은고딕", Font.BOLD, 18));
		tfId.setText("아이디를 입력하세요.");
		
		tfPw.setSize(300,40);
		tfPw.setLocation(300,250);
		tfPw.setFont(new Font("맑은고딕", Font.BOLD, 18));
		
		tfPc.setSize(300,40);
		tfPc.setLocation(300,350);
		tfPc.setFont(new Font("맑은고딕", Font.BOLD, 18));
			
		add(lJoin);
		add(tfId);
		add(tfPw);
		add(tfPc);
		
		//하단 버튼 설정
		JButton btnJoin = new JButton("회 원 가 입");
		
		btnJoin.setSize(300, 40);
		btnJoin.setLocation(300,450);
		btnJoin.setFont(new Font("맑은고딕", Font.BOLD, 18));
		
		add(btnJoin);
		
		//버튼 이벤트
		
		btnJoin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				String inputId = tfId.getText();
				String inputPw = new String(tfPw.getPassword());
				String inputPc = new String(tfPc.getPassword());
				
				if(inputId.isEmpty() || (inputPw.isEmpty()) || (inputPc.isEmpty())) {
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호를 입력하세요");;
				}else if(!inputPw.equals(inputPc)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
					return;
				}else {
					MemberBuffer mb = new MemberBuffer();
					ArrayList<MemberInfo> arr = mb.readFile(fileName);
					MemberJoin memberList = new MemberJoin();
					
					for(int i=0; i<arr.size(); i++) {
						memberList.addMember(arr.get(i));
					}
					
					try (BufferedWriter br = new BufferedWriter(new FileWriter("회원목록",true))) {
						
						br.write(inputId + "/");
						br.write(inputPw + "/");
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다.");
					}
					
					JOptionPane.showMessageDialog(null, "회원가입에 성공했습니다.");
					//new MainTest(); //메인화면으로
				}
				
			}
		});
		
	}

}
