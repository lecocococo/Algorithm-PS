import java.io.*;

public class B9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[11];
		arr[0] = 1;
		arr[1] = 1;
		//arr[2] = 2;
		//arr[3] = 4;
		//arr[4] = 7;
		
		for(int i=2;i<11;i++) {
			if(i==2)
				arr[i]=2;
			else
				arr[i]=arr[i-3] + arr[i-2] + arr[i-1];
		}
		for(int j=0;j<n;j++) {
			System.out.println(arr[Integer.parseInt(br.readLine())]);
		}
	}
}
