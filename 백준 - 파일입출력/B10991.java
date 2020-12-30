import java.io.*;
import java.util.*;

public class B10991 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int l = n+1;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				sb.append('*');
				sb.append(' ');
			}
			System.out.println(String.format("%"+l+"s", sb));
			l++;
			sb.setLength(0);
		}
	}
}
