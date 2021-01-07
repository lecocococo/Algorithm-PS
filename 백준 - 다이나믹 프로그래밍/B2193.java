import java.io.*;

public class B2193 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		//int형 범위를 벗어나기 때문에 Long으로 설정
		Long[][] arr = new Long[n+1][2];
		Long result = 0L;
		
		//한자리 일때 0으로 끝나는 경우의 개수는 0개, 1로 끝나는 경우 1개이다
		arr[1][0] = 0L; 
		arr[1][1] = 1L;
		
		//다이나믹 프로그래밍 부분
		//0으로 끝나는 경우 - 자기 바로 이전 자리수들의 0과 1로 끝나느 경우의 합
		//1로 끝나는 경우 - 자기 바로 이전 자리수중 0으로 끝나는경우가 1로 끝나는 경우가 됨(0으로 끝나느경우에 뒤쪽에 1밖에 못붙혀주기 떄문)
		for(int i = 2;i<=n;i++) {
			for(int j = 0;j<2;j++) {
				if(j==0)
					arr[i][j] = arr[i-1][j] + arr[i-1][j+1];
				if(j==1)
					arr[i][j] = arr[i-1][j-1];
			}
		}
		for(int i=0;i<2;i++)
			result +=arr[n][i];
		System.out.println(result);
	}
}
