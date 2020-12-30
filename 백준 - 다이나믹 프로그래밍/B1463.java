import java.io.*;
import java.util.*;

//DP문제
public class B1463 {

	static int[] numarr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
//		방법 1 bottom-up
//		numarr = new int[n+1];
//		numarr[0]=numarr[1]=0;
//		for(int i=2;i<=n;i++) {
//			numarr[i]=numarr[i-1]+1;
//			if(i%2==0)
//				numarr[i] = Math.min(numarr[i], numarr[i/2]+1);
//			if(i%3==0)
//				numarr[i] = Math.min(numarr[i], numarr[i/3]+1);
//		}
//		System.out.println(numarr[n]);
		
		//System.out.println(minCalculator(n));
		
		System.out.println(cal(n,0));
	}
	//방법 3 
	static int cal(int n, int cnt) {
		if(n<=1) {
			return cnt;
		}
		return Math.min(cal(n/2,cnt+(n%2)+1), cal(n/3,cnt+(n%3)+1));
	}
//  재귀 방법 top-down
//	public static int minCalculator(int num){
//		if(num==1)
//			return 0;
//		if(numarr[num]>0)
//			return numarr[num];
//		
//		numarr[num]=minCalculator(num-1)+1;
//		
//		if(num%2==0) {
//			numarr[num] = Math.min(numarr[num], minCalculator(num/2)+1);
//		}
//		if(num%3==0) {
//			numarr[num] = Math.min(numarr[num], minCalculator(num/3)+1);
//		}
//		return numarr[num];
//	}
}


