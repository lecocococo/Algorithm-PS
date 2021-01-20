import java.io.*;

public class B1699 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int dparr[] = new int [n+1];
		//제곱수의 항이 최소가 되게 하는 제곱수의 합(greedy 방식은 불가능)
		//1,2,3,4,... 의 제곱을 i에서 빼주면서 최소가 되는 하으이 개수를 찾아서 저장
		for(int i=1;i<=n;i++) {
			dparr[i] = i;
			for(int j=1;j*j<=i;j++){
				if(dparr[i]>dparr[i-j*j]+1)
					dparr[i] = dparr[i-j*j] + 1;
			}
		}
		System.out.println(dparr[n]);
	}
}

