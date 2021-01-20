import java.io.*;

public class B11055 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		String[] sarr = br.readLine().split(" ");
		int[] arr = new int[n+1];
		int[] dparr = new int[n+1];
		
		for(int i = 1;i<=n;i++) {
			arr[i] = Integer.valueOf(sarr[i-1]);
		}
		//i라는 위치에서 i위치 이전에 arr배열을 다 확인하고 i위치가 더 크면 그 위치에 적혀있던 dparr값에서 
		//arr[i]의 값을 더 한다. 만약에 더했을때 값이 현재 dparr[i]값보다 커진다면 daprr[i]에 기록 한다   
		for(int i=1;i<=n;i++) {
			dparr[i] = arr[i];
			for(int j = 1;j<i;j++) {
				if(arr[j]<arr[i]&&dparr[i]<dparr[j]+arr[i])
					dparr[i] = dparr[j] + arr[i];
			}
			//System.out.println(dparr[i]);
		}
		//System.out.println();
		int max = 0;
		for(int i=1;i<=n;i++)
			max= Math.max(max, dparr[i]);
		
		System.out.println(max);
	}
}
