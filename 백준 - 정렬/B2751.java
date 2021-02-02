import java.io.*;
import java.util.*;

public class B2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());	
		
//		Collection.sort를 이용하는 방법, 좀더 공부해야할 부분 
//		Collections.sort() 은 Timsort이다. Timsort는 반복 합병 및 삽입정렬 알고리즘을 사용한다.
//		합병정렬의 경우 최선, 최악  O(nlogn)을 보장하고.(하지만 문제는 메모리 공간을 더 잡기 때문에 메모리를 신경써야함) 
//		삽입정렬의 경우 최선 O(n), 최악O(n2)이다.		
		List<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++)
			arr.add(Integer.valueOf(br.readLine()));
		
		Collections.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(arr.get(i));
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
//		힙정렬 이용방법 , 백준에서 시간초과뜸
//		int[] arr = new int[n];
//		
//		for(int i=0;i<n;i++)
//			arr[i] = Integer.valueOf(br.readLine());
//		
//		for(int j=n-1;j>0;j--) {
//			int temp = arr[0];
//			arr[0] = arr[j];
//			arr[j] = temp;
//			for(int i=1;i<j;i++) {
//				int child = i;
//				while(child>0) {
//					int parent = (child-1)/2;
//					if(arr[child]>arr[parent]) {
//						int t = arr[child];
//						arr[child] = arr[parent];
//						arr[parent] = t;
//					}
//					child = parent;
//				}
//				
//			}
//		}
//		StringBuilder sb = new StringBuilder();
//		for(int i=0;i<n;i++) {
//			sb.append(arr[i]);
//			sb.append("\n");
//		}
//		System.out.println(sb.toString());
	}
}
