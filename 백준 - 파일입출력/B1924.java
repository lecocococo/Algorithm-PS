import java.io.*;
import java.util.*;

public class B1924 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		
		//string의 split자체가 string배열을 반환
		String[] narr = n.split(" ");
		
		int month = Integer.parseInt(narr[0]);
		int day = Integer.parseInt(narr[1]);
		
		int i = (month-1) * 31;
		
		if(month>2)
			i-=3;
		//좀더 효율적인 방법을 찾자
		if(month>4) {
			i-=1;
			if(month>6) {
				i-=1;
				if(month>9) {
					i-=1;
					if(month>11) {
						i-=1;
					}
				}
			}
		}
		i+=day;
		
		switch(i%7) {
		
		case 1:
			System.out.println("MON");
			break;
		case 2:
			System.out.println("TUE");
			break;
		case 3:
			System.out.println("WED");
			break;
		case 4:
			System.out.println("THU");
			break;
		case 5:
			System.out.println("FRI");
			break;
		case 6:
			System.out.println("SAT");
			break;
		case 0:
			System.out.println("SUN");
		}
	}
}
