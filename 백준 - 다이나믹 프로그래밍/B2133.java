import java.io.*;

//3xN 크기의 벽을 타일 채우기 
public class B2133 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int[] dparr = new int[n+1];
		dparr[0] = 1;
		//n은 짝수일 경우에만 타일을 채울 수 있다
		//점화식: dp[n] = dp[n-2]*3 + dp[n-4]*2 + dp[n-6]*2 ... dp[0]*2 ;
		for(int i=2;i<=n;i+=2) {
			dparr[i] += dparr[i-2]*3;
			for(int j=4;j<=i;j+=2)
				dparr[i] += dparr[i-j]*2;
		}
		System.out.println(dparr[n]);

		
	}
}
