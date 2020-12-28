import java.io.*;
import java.util.*;

public class B11721 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char a;
		String str=br.readLine();
		
		//초기화 활때 null이라고 하니  출력시 null이 나온다. 그러니 ""로 초기화하자!!!
		String str2 = "";
		int len = str.length();
		for(int i=1;i<=len;i++) {
			
			str2 += str.charAt(i-1);
			//10개가 되면 출력하고 초기화
			if(i%10 == 0) {
				System.out.println(str2);
				str2 = "";
			}
			//마지막에 10개가 안남고 i가 입력받은 값의 끝에 도달했을때 나머지 출력하는 부분 
			else if(len-i<10 && i==len) {
				System.out.println(str2);
			}
		}
	}
}
