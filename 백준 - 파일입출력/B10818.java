import java.io.*;
import java.util.*;

public class B10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int min = 1000000;
		int max = -1000000;
		
		for(int i = 0;i<n;i++) {
			int k = sc.nextInt();
			if(k>max)
				max=k;
			if(k<min)
				min=k;
		}
		System.out.print(min +" "+ max);
	}
}
