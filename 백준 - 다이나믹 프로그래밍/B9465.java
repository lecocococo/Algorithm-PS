import java.io.*;
import java.util.*;

public class B9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int k = 0;
		String[] sarr;
		int[][] arr;
		int[][] arr2;
		
		for(int i=0;i<n;i++) {
			k = Integer.valueOf(br.readLine());
			arr = new int[2][k+1];
			for(int m = 0;m<2;m++) {
				sarr = br.readLine().split(" ");
				for(int q = 1;q<=k;q++)
					arr[m][q] = Integer.valueOf(sarr[q-1]);
			}
			//string배열을 int형 배열로 만드는 방법 - stream활용, 여기는 공부 더해야 하는 부분
			//arr[0] = Arrays.stream(sarr).mapToInt(Integer::parseInt).toArray();
			//sarr = br.readLine().split(" ");
			//arr[1] = Arrays.stream(sarr).mapToInt(Integer::parseInt).toArray();
			
			
			arr2 = new int[2][k+1];
			
			//첫번째 줄 스티커 때는 경우를 적어줌 
			arr2[0][0] = 0;
			arr2[1][0] = 0;
			arr2[0][1] = arr[0][1];
			arr2[1][1] = arr[1][1];
			
			//첫번째 라인에서 땔때는 두번째 라인에서 자신 바로 뒤에 것괴 자신의 2번째 뒤에것만 생각하면 된다.(점수를 최대로 얻는 경우)
			//두번째라인에서 땔때는 첫번째 라인에서 자신 바로 뒤에 것괴 자신의 2번째 뒤에것만 생각하면 된다.
			for(int j = 2;j<=k;j++) {
				arr2[0][j] = Math.max(arr2[1][j-1], arr2[1][j-2]) + arr[0][j];
				arr2[1][j] = Math.max(arr2[0][j-1], arr2[0][j-2]) + arr[1][j];
			}
			System.out.println(Math.max(arr2[0][k], arr2[1][k]));
		}
	}
}
