import java.io.*;

//Kadane(카데인) 알고리즘,O(n)에 됨
//연속하는 최대 합
public class B1912 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		String[] sarr = br.readLine().split(" ");
		int[] arr = new int[n+1];
		int[] dparr = new int[n+1];
		
		arr[0] = dparr[0] = 0;
		
		for(int i = 1;i<=n;i++) {
			arr[i] = Integer.valueOf(sarr[i-1]);
		}
		
		int max = arr[1];
		
		//현재 위치의 배열 값, 이전위치까지의 최대 연속합 + 현재 위치의 배열값중에 큰값을 그 위치 까지의 최대 값으로 저장
		//이제까지 읽은 것중 최대 값과 비교한후 max에 저장
		//3개중 제일 큰값을 max에 저장
		for(int i=1;i<=n;i++) {
			dparr[i] = Math.max(arr[i]+dparr[i-1],arr[i]);
			max = Math.max(max,dparr[i]);
		}
		
		System.out.println(max);
	}
}
