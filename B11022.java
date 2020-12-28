import java.io.*;
import java.util.*;

public class B11022 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = sc.nextInt();
		
		for(int i = 0; i<T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int result = A+B;
			
			bw.write("Case #"+(i+1)+": " + A + " + " + B + " = "+result+"\n");
			
		}
		bw.flush();
	}
}
