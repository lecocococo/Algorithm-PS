//백준 코딩용 java파일

import java.io.*;
import java.util.*;
import java.lang.*;

//백준 2798번 블랙잭
public class Main {

	public static int sum=0;
	public static void main(String args[]) throws IOException {
		
		int max=0;
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		//nextInt()사용후 nextLine()사용법
		sc.nextLine();  //바로 sc.nextLine()을 해버리면 개행문자가
						//읽혀서 저장된다 그래서 sc.nextLine();을 적어주어 개행 문자를 날리고 읽는다
		int[] card=new int[n];
		for(int i=0;i<n;i++) {
			card[i]=sc.nextInt();
		}
		//String secondLine=sc.nextLine();
		//String[] card=secondLine.split(" ");
		
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					
					sum=card[i]+card[j]+card[k];
					if(sum<=m) {
						if(sum>=max) {
							max=sum;
						}
					}
				
				}
			}
		
		}
		System.out.println(max);
	}
}
