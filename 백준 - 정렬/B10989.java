import java.io.*;
import java.util.*;

public class B10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		//List<Integer> list = new ArrayList<>();
		int[] list = new int[n];
		for(int i=0;i<n;i++)
			list[i] = Integer.valueOf(br.readLine());
		
		//Collections.sort(list);
		Arrays.sort(list);   //배열의 끝에 맞추는듯
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(list[i]);
			sb.append("\n");
		}
		
		System.out.println(sb);
			
			
	}
}
