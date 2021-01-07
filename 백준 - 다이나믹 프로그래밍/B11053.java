import java.io.*;

public class B11053 {

	static int val = 0 ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int[] arr = new int[n+1];
		String[] sarr = br.readLine().split(" ");
		
		
		for(int i =1;i<=n;i++) {
			arr[i] = Integer.valueOf(sarr[i-1]);
		}
		
		
		int dparr[] = new int[n+1];
		//초기화
		for(int i=0;i<=n;i++)
			dparr[i] = 1;
		
		//가장 긴 증가하는 부분 수열 구하는 부분
		//i까지 dparr[]를 쭉 훓으면서 arr[]값을 비교했을 때 i의 값이j보다 크다면 dparr+1을 해주면 됨
		//dparr[i]<=dparr[j]이조건 같은경우는 최대의 값이 먼저 나온 상황에서 나머지의 경우를 무시해주기 위한 조건이다.
		//https://developer-mac.tistory.com/71 참조
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				if(arr[j]<arr[i]&&dparr[i]<=dparr[j])
					dparr[i]= dparr[j] + 1;
			}
		}
		
		//최대 길이 뽑아내는 과정
		int max=0;
		for(int i=1;i<=n;i++)
			max = Math.max(max,dparr[i]);
		System.out.println(max);
	}
}
