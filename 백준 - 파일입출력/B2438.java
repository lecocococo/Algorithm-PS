import java.io.*;
import java.util.*;

public class B2438 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//아래 방법이 백준에선 틀리다고 나옴 2중 for문 사용해서 해야할듯
		//string은 안됨! char형을 사용해야 *이 그대로 나오게 된다
//		char[] str = new char[n];
//		for(int i=0; i<n;i++) {
//			
//			str[i]='*';
//			System.out.println(str);
//		}
		
		//StringBuilder를 사용하면 더 빠르게 돌아감!!!!!
		StringBuilder sb = new StringBuilder();
		 
		for (int i=1; i<=n;i++) {
			for (int j=0; j<i;j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
