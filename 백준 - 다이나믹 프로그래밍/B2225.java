import java.io.*;
//합 분해
public class B2225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sarr = br.readLine().split(" ");
		
		int n = Integer.valueOf(sarr[0]);
		int k = Integer.valueOf(sarr[1]);
		
		int[][] dparr=new int[201][201];
		
		for(int i=1;i<=k;i++)
			dparr[0][i] = 1;
		//0~20까지의 숫자르 3개를 더해서 합이 20이 되는 경우를 예로 들자면
		//2개의 숫자를 더해서 20이 되는 경우와 3개의 숫자를 더해서 19가 되는 경우를 더하면 된다.
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++)
				dparr[i][j] = (dparr[i-1][j] + dparr[i][j-1])%1000000000;
				
		}
		System.out.println(dparr[n][k]%1000000000);
	}
}
