//백준 코딩용 java파일

import java.io.*;
import java.util.*;


public class Main {

	public static int sum=1;
	public static void main(String args[]) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		System.out.println(fac(a));
	}
	public static int fac(int a) {
			if(a<2) return 1;
			return a*fac(a-1);
	}
}

