import java.io.*;
import java.util.*;

public class B2439 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//StringBuilder를 사용하면 더 빠르게 돌아감!!!!!
		StringBuilder sb = new StringBuilder();
		 
		for (int i=1; i<=n;i++) {
			for (int j=0; j<i;j++) {
				sb.append('*');
			}
			System.out.println(String.format("%"+n+"s", sb));
			//StringBuider 초기화 방법 기억해두자
			sb.setLength(0);
		}
	}
}

