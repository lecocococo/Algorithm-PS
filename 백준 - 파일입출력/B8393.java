import java.io.*;

public class B8393 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		
		System.out.println(sum);
	}
}
