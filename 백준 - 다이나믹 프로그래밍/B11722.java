import java.io.*;

//B11053에서 배열만 뒤집어서 증가하는 길이를 구함
//다른방식으로 다이나믹 프로그래밍 해볼것
public class B11722 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int[] arr = new int[n+1];
		String[] sarr = br.readLine().split(" ");
		
		
		for(int i =1;i<=n;i++) {
			arr[i] = Integer.valueOf(sarr[n-i]);
		}
		
		
		int dparr[] = new int[n+1];
		//초기화
		for(int i=0;i<=n;i++)
			dparr[i] = 1;
		//증가하는 수열에서 배열만 거꾸로 뒤집어서 증가하는 수열로 찾음 
		//다른방법으론 배열의 맨 끝 부터 시작하여 첫번째 위치까지 로 설정하면 됨
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				if(arr[j]<arr[i]&&dparr[i]<=dparr[j])
					dparr[i]= dparr[j] + 1;
			}
		}
		
		//최대 길이 뽑아내는 과정
		int max=0;
		for(int i=1;i<=n;i++)
			max = Math.max(max,dparr[i]);
		System.out.println(max);
	}
}
