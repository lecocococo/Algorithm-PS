import java.io.*;
import java.util.*;

//좌표 class
class Point{
	int x;
	int y;
	
	Point(int x, int y){
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
public class B11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());	
		
		//ArrayList생성
		List<Point> list = new ArrayList<>();
		
		//한줄에 있는 걸 split해서 ArrayList에
		for(int i=0;i<n;i++) {
			
			String[] sarr = br.readLine().split(" ");
			list.add(new Point(Integer.valueOf(sarr[0]), Integer.valueOf(sarr[1])));
		}
		
		//정렬,Comparator를 설정해줘서 x좌표를 비교하여 증가하는 순으로, x좌표가 같다면 y좌표를 증가하는 순으로 해줌 
		Collections.sort(list, new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				if(p1.x<p2.x) {
					return -1;
				}
				else if(p1.x>p2.x) {
					return 1;
				}
				else if(p1.x==p2.x) {
					if(p1.y<p2.y) {
						return -1;
					}
					else if(p1.y>p2.y) {
						return 1;
					}
				}
				return 0;
			}
			
		});
		
		//System.out.println() 으로 한줄씩 출력하면 매우 느림
		//StringBuiler를 애용하자
		//아니면 BufferedWriter를 써도 됨
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
