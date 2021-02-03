import java.io.*;
import java.util.*;

public class B9012 {

	static Stack<Character> stack;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		stack = new Stack<>();
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			sb.append(resolve(s)).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	public static String resolve(String s) {

		
		stack = new Stack<>();
		
		for(int j=0;j<s.length();j++) {
			char c = s.charAt(j);

			if(c=='(') {
				stack.push(c);
			}
			
			else if (stack.isEmpty()) 
				return "NO";
			
			else 
				stack.pop();
				
		}
		
		if(stack.isEmpty())
			return "YES";
		else
			return "NO";
	}
}
