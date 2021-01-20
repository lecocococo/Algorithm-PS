import java.io.*;

public class B9461 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		Long[] dparr;
		//현 위치에서 2개전의 값과 3개 전의 값을 더하면 된다
		for(int i=1;i<=n;i++) {
			int k = Integer.parseInt(br.readLine());
			dparr = new Long [k+1];
			for(int j=1;j<=k;j++) {
				if(j==1||j==2||j==3)
					dparr[j] = 1L;
				else
					dparr[j] = dparr[j-2] + dparr[j-3];
			}
			System.out.println(dparr[k]);
		}
	}
}
