import java.io.*;

public class B11057 {

	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1][10];
		
		int result = 0;
		
		for(int i=0;i<10;i++) 
			arr[1][i] = 1;
		
		for(int j =2;j<=n;j++) {
			for(int i=0;i<10;i++) {
				if(i==0)
					arr[j][i] = 1;
				else
					arr[j][i] = (arr[j][i-1] + arr[j-1][i])%10007;
			}
		}
		for(int i=0;i<10;i++)
			result +=arr[n][i];
		System.out.println(result%10007);
	}
}
