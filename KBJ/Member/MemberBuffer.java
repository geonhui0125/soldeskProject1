package Member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

//Car 폴더 MemberList 참조
public class MemberBuffer {

	public static String fileName = "회원목록.txt";
	static ArrayList<MemberInfo> memberList = new ArrayList<MemberInfo>();

	public ArrayList<MemberInfo> readFile(String fileName){
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));

			while(true) {
				String text = br.readLine(); // 텍스트 파일 내 데이터를 한 줄 씪 읽음
				
				// 텍스트 내 데이터가 없으면 끝내도록
				if (text == null) {
					break;
				}
				
				String[] strArray = text.split("/");
				memberList.add(new MemberInfo(strArray[0], strArray[1]));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		
	return memberList;
	}
}
