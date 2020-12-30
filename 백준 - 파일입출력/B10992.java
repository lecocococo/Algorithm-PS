import java.io.*;
import java.util.*;

public class B10992 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int l = n;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=(2*i-1);j++) {
				if(i==n) {
					sb.append('*');
				}
				else {
					if(j==1)
						sb.append('*');
					else if(j==(2*i-1))
						sb.append('*');
					else
						sb.append(' ');
				}
			}
			System.out.println(String.format("%"+l+"s", sb));
			l++;
			sb.setLength(0);
		}
	}
}
