import java.io.*;
import java.util.*;

public class B10799 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		Stack<String> stack = new Stack<>();
		int result = 0;
		
		for(int i=0;i<s.length();i++) {
			char st = s.charAt(i);
			
			if(st=='(')
				stack.push("(");
			else if(st==')') {
				if(s.charAt(i-1)=='(') {
					stack.pop();
					result += stack.size();
				}
				else {
					stack.pop();
					result += 1;
				}
			}
		}
		
		System.out.println(result);
	}
}

