import java.io.*;
import java.util.*;

//비교 결과 BufferedReader가 메모리도 덜 쓰고 빠르게 돌아간다. string을 char로 나눠서 처리하는 거 때문인가 scanner의 한계인가???
public class B11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next(); //enter를 무시하기 위해 nextLine대신 next사용
		int sum = 0; 
		for(int i=0;i<n;i++) {
			
			sum += str.charAt(i)-'0'; //String은 char의 배열 형태 char로 받으면 아스키코드값이라 -48이나 -'0'을 해줘서 숫지 아스키를 받아야함
			
		}
		System.out.println(sum);
	}
}
