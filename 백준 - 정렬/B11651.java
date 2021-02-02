import java.io.*;
import java.util.*;

//좌표 class
class Points{
	int x;
	int y;
	
	Points(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
        return this.x;
    }
	
	public int getY() {
        return this.y;
    }
}

public class B11651 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());	
		List<Points> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			
			String[] sarr = br.readLine().split(" ");
			list.add(new Points(Integer.valueOf(sarr[0]), Integer.valueOf(sarr[1])));
		}
		
		//Comparator로 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서
		Collections.sort(list, new Comparator<Points>() {

			@Override
			public int compare(Points p1, Points p2) {
				if(p1.y<p2.y) {
					return -1;
				}
				else if(p1.y>p2.y) {
					return 1;
				}
				else if(p1.y==p2.y) {
					if(p1.x<p2.x) {
						return -1;
					}
					else if(p1.x>p2.x) {
						return 1;
					}
				}
				return 0;
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(list.get(i).getX());
			sb.append(" ");
			sb.append(list.get(i).getY());
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
