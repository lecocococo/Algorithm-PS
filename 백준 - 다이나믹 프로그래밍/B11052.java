import java.io.*;

//카드 구매하기
public class B11052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		String[] sarr = br.readLine().split(" ");
		int[] arr = new int[n+1];
		int[] dparr = new int[n+1];
		
		for(int i = 1;i<=n;i++) {
			arr[i] = Integer.valueOf(sarr[i-1]);
		}
		
		//10장 이라면 1+9, 2+8, 3+7 ... 1x10 의 경우 중 크게 나오는 값을 구하면 됨 
		for(int i=1;i<=n;i++) {
			if(i==1)
				dparr[i] = arr[i];
			else 
				dparr[i] = arr[i];
			for(int j=1;j<i;j++) {
				if(dparr[i]<dparr[j] + dparr[i-j])
					dparr[i] = dparr[j] + dparr[i-j];
			}
			//dparr[i] = Math.max(dparr[i], dparr[1]*n);
			
		}
		System.out.println(dparr[n]);
	}
}
