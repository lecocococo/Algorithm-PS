import java.io.*;

public class B11054 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		String[] sarr = br.readLine().split(" ");
		int[] arr = new int[n+1];
		int[] dparr = new int[n+1];
		int[] dparr2 = new int[n+1];
		//dparr[0] = dparr2[0] = 0;
		
		for(int i = 1;i<=n;i++) {
			arr[i] = Integer.valueOf(sarr[i-1]);
		}
		
		//B11055에서 한 방식으로 그 위치에서 가장 긴 증가하는 수열의 길이를 구함 
		for(int i=1;i<=n;i++) {
			dparr[i] = 1;
			for(int j=1;j<=i;j++) {
				if(arr[j]<arr[i]&&dparr[i]<=dparr[j]) {
					dparr[i] = dparr[j] + 1;
				}
			}
			//System.out.print(dparr[i] + " ");
		}
		
		//System.out.println();
		
		//B11722에서 처럼 가장 긴 감소하는 수열을 구함
		for(int i=n;i>0;i--) {
			dparr2[i] = 1;
			for(int j=n;j>i;j--) {
				if(arr[j]<arr[i]&&dparr2[i]<=dparr2[j]) {
					dparr2[i] = dparr2[j] + 1;
				}
			}
			//System.out.print(dparr2[i] + " ");
		}
		

		int result = 0;
		
		//중요한 아이디어!!
		//그 위치의 가장 긴 증가 수열의 길이와 가장 긴 감소수열 길이의 합에서 
		//같은 위치가 2번 포함되므로 -1을 해준다.
		//최대값을 찾으면 됨 
		for(int i=1;i<=n;i++)
			result = Math.max(result, dparr[i] + dparr2[i]);
		System.out.println(result-1);
	}
}
