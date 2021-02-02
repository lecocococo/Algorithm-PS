import java.io.*;
import java.util.*;

public class B11004 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sarr = br.readLine().split(" ");
		String[] sarr2 = br.readLine().split(" ");
		int n = Integer.valueOf(sarr[0]);
		int a = Integer.valueOf(sarr[1]);
		
		List<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++)
			arr.add(Integer.valueOf(sarr2[i]));
		
		Collections.sort(arr);
		
		System.out.println(arr.get(a-1));
	}
}
