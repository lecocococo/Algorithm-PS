import java.io.*;
import java.util.*;

public class B2522 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				sb.append('*');
			}
			System.out.println(String.format("%"+n+"s", sb));
			sb.setLength(0);
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=n-1;j>=i;j--) {
				sb.append('*');
			}
			System.out.println(String.format("%"+n+"s", sb));
			sb.setLength(0);
		}
	}
}