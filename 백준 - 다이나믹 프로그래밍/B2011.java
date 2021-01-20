import java.io.*;
//암호코드 문제
public class B2011 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sarr = br.readLine().split("");
		
		int[] arr = new int [sarr.length+1];
		int[] dparr = new int[sarr.length+1];
		arr[0] = 0;
		dparr[0] = 1;
		
		for(int i=1;i<=sarr.length;i++)
			arr[i] = Integer.valueOf(sarr[i-1]);
		
		//1자리 수 일때 와 2자리 수일때 의 경우의 수를 더해야함 이떄 0처리 조심해야함
		//10, 20 은 되는데 0자체는 안됨
		for(int i=1;i<arr.length;i++) {
			int num = arr[i-1]*10 + arr[i];
			if(i==1 && arr[i]==0)
				dparr[i] = 0;
			
			if(1<=arr[i] && arr[i]<=9)
				dparr[i] += (dparr[i-1])%1000000;
			
			if(10<=num && num<=26)
				dparr[i] += (dparr[i-2])%1000000;

		}
		System.out.println(dparr[sarr.length]%1000000);
	}
}
