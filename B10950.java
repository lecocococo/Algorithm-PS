import java.io.*;
import java.util.*;

//백준으로 제출할때는 class명을 Main으로
public class B10950 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T=sc.nextInt();
		
		for(int i=0;i<T;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int result = A+B;
			
			//int형으로 담으니 출력이 제대로 안됨. string으로 바꿔서 출력하는방법
			bw.write(String.valueOf(result));
			bw.append("\n");
			
		}
		bw.flush();
	}
}
