import java.io.*;
import java.util.*;

public class B10828 {

	public static int size =0;
	public static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		arr = new int [n];
		
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			switch(st.nextToken()) {
				
				case "push": 
					push(Integer.valueOf(st.nextToken()));
					break;
				case "pop":
					sb.append(pop());
					sb.append('\n');
					break;
					
				case "size":
					sb.append(size());
					sb.append('\n');
					break;
					
				case "empty":
					sb.append(empty());
					sb.append('\n');
					break;
					
				case "top":
					sb.append(top());
					sb.append('\n');
					break;
				}
			}
		System.out.println(sb);
		}
		
		public static void push(int x) {
			arr[size] = x;
			size++;
		}
		
		public static int pop() {
			if(size==0)
				return -1;
			else {
				int result = arr[size-1];
				arr[size-1] = -1;
				size--;
				return result;
			}
		}
		
		public static int size() {
			return size;
		}
		
		public static int empty() {
			if(size==0)
				return 1;
			else
				return 0;
		}
		
		public static int top() {
			if(size==0)
				return -1;
			else
				return arr[size-1];
		}
	}

