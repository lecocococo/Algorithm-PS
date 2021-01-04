import java.io.*;

//DP 2차원 배열 사용하는 문제
public class B10844 {

	static int n;
	static Long[][] arr;
	static Long result = 0L;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//배열선언 1~n자리 에서 마지막 자리수가 0~9인것을 나타내는 2차원 배열
		arr = new Long[n+1][10];
		
		//1자리일때 1로 초기화
		for(int i=0;i<10;i++) 
			arr[1][i] = 1L;
		//마지막 자리수가 0~9인 것을 더함
		for(int i=1;i<10;i++)
			result +=recursive(n, i);
		
		System.out.println(result%1000000000);
		
	}
	//재귀 
	public static Long recursive(int n, int m) {
		//자리수가 1이면 나올수있는 쉬운수 가 1개 밖에 안됨 
		if(n == 1) {
			return arr[1][m];
		}
		//arr배열이 채워져 있지 않으면 재귀로 들어가야함 
		if(arr[n][m] == null) {
			//마지막 자리수가 0이라면 앞 자리수로 나올수있는것은 1밖에 없다 
			if(m == 0) 
				arr[n][m] = recursive(n-1,1);
			
			//마지막 자리수가 9라면 앞 자리수로 나올 수 있는 것은 8밖에 없다
			else if(m == 9) 
				arr[n][m] = recursive(n-1,8);
			
			//나머지의 경우에는 마지막 자리수의 +1, -1을 한 2가지의 경우 모두 가능하기 때문에 2가지의 경우의 수 모두 더해준다.
			else
				arr[n][m] = recursive(n-1,m-1) + recursive(n-1,m+1);
		}
		return arr[n][m]%1000000000;
	}
}
