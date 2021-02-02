import java.io.*;
import java.util.*;

public class B11652 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		long[] list = new long[n];
		for(int i=0;i<n;i++) {
			long a = Long.parseLong(br.readLine());
			list[i]= a;
		}
		
		Arrays.sort(list);  
		
		int count = 1;
		int maxCount_Num = 0;
		long result = list[0];
		
		//가장 많이 가지고 있는 정수를 구하는 부분
		for(int i=1;i<n;i++) {
			if(list[i] == list[i-1])
				count++;	//이전과 같다면 1증가 시킴
			else if(list[i] != list[i-1])
				count=1;	//이전과 다르면 리셋
			
			if(maxCount_Num<count) {
				maxCount_Num = count;	//최대 카운트 바꿔줌
				result = list[i-1];		//결과를 담아둠
			}
				
		}
		System.out.println(result);
	}
}
