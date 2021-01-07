import java.io.*;

public class B2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int[] arr= new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		int dparr[] = new int [n];
		
		//포도주 먹는 경우를 따져보면 
		//oox
		//oxo
		//xoo
		//3가지의 경우가 있다 (oxx와 같은 경우는 최대로 먹는 것이 아니기때문에 제외)
		//oox는 dparr[i-1]인 경우이고
		//oxo는 dparr[i-2] + arr[i]인 경우이고
		//xoo는 dparr[i-3] + arr[i-1] + arr[i]인 경우이다.
		//3가지의 경우중 최대가 그 위치까지의 최대로 마시는 경우 이다.
		for(int i=0;i<n;i++) {
			if(i==0)
				dparr[i] = arr[0];
			else if(i==1)
				dparr[i] = arr[1] + dparr[0];
			else if(i==2)
				dparr[i] = Math.max(dparr[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));
			else {
				dparr[i] = Math.max(dparr[i-3] + arr[i-1] + arr[i], dparr[i-2] + arr[i]);
				dparr[i] = Math.max(dparr[i-1],dparr[i]);
			}
			
		}
		System.out.println(dparr[n-1]);
	}
}
