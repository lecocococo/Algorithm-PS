import java.io.*;
import java.util.*;

public class B2442 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//StringBuilder를 사용하면 더 빠르게 돌아감!!!!!
		StringBuilder sb = new StringBuilder();
		int l = n;
		for (int i=1; i<=n;i++) {
			for (int j=0; j<(i*2-1);j++) {
				sb.append('*');
			}
			
			//%10s라고하면 10자리를 잡고 오른쪽정렬 해서 출력하는것
			System.out.println(String.format("%"+ l +"s", sb));
			l++;
			sb.setLength(0);
		}
	}
}

