package Member;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberJoin {

	//맴버 저장 리스트
	private ArrayList<MemberInfo> memberList;
	
	public MemberJoin() {
		memberList = new ArrayList<MemberInfo>();
	}
	
	//맴버 추가 메소드
	public void addMember(MemberInfo member) {
		memberList.add(member);
	}
	
	//로그인 메서드
	public String loginMember(String id) {
		
		Iterator<MemberInfo> ir = memberList.iterator();
		while(ir.hasNext()) {
			MemberInfo member = ir.next();
			String tempId = member.getId();
			if(tempId.equals(id)) {
				return member.getPw();
			}
		}
		return "";
	}
	
	//중복검사 메서드
	public String joinMember(String id) {
		
		Iterator<MemberInfo> ir = memberList.iterator();
		while(ir.hasNext()) {
			MemberInfo member = ir.next();
			String tempId = member.getId();
			if(tempId.equals(id)) {
				return "존재하는 아이디 입니다.";
			}
		}
		return "";
	}
	
}

