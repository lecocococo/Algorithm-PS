import java.io.*;

//포도주 마시기와 비슷한 문제이나 조금더 생각해야하는 문제
public class B2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n+1];
		int[] dparr = new int[n+1];
		dparr[0] = arr[0] = 0;
		
		for(int i=1;i<=n;i++)
			arr[i] = Integer.valueOf(br.readLine());
		
		//3가지의 경우가 있다. oox / oxo / xoo 3가지인데 
		//주의할점은 계단 개수가 3개 이하일때와 마지막 계단은 항상 밟아야한다는 점이다.
		if(n==1)
			dparr[n] = arr[1];
		else if(n==2)
			dparr[n] = Math.max(arr[2],arr[1] +arr[2]);
		else if(n==3)
			dparr[n] =Math.max(arr[2]+arr[3], arr[1]+arr[3]);
		else {
			for(int i=1;i<=n;i++) {
				if(i==1)
					dparr[i] = arr[1];
				else if(i==2)
					dparr[i] = dparr[1] + arr[2];
				else {
					if(i==n)
						dparr[i] = Math.max(arr[i-1]+arr[i]+dparr[i-3], dparr[i-2] + arr[i]);
					else
						dparr[i] = Math.max(dparr[i-2] + arr[i], arr[i-1]+arr[i]+dparr[i-3]);
				}
			
			}
		}
		System.out.println(dparr[n]);
	}
		
	
}
