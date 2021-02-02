import java.io.*;
import java.util.*;

class Member{
	int age;
	String name;
	int count;
	
	Member(int age, String name, int count){
		this.age = age;
		this.name = name;
		this.count = count;
	}
	
	public int getAge() {
        return this.age;
    }
	
	public String getName() {
        return this.name;
    }
	
	public int getCount() {
        return this.count;
    }
}

public class B10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int count = 1;
		List<Member> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String[] sarr = br.readLine().split(" ");
			list.add(new Member(Integer.valueOf(sarr[0]), sarr[1],count));
			count++;
		}
		
		//나이순 정렬을 위한 Comparator, 나이가 같다면 먼저 온 사람이 먼저 나오도록 하기위헤 count비교
		Collections.sort(list, new Comparator<Member>() {

			@Override
			public int compare(Member m1, Member m2) {
				if(m1.age>m2.age)
					return 1;
				else if(m1.age<m2.age)
					return -1;
				else if(m1.age==m2.age) {
					if(m1.count>m2.count)
						return 1;
					else if(m1.count<m2.count)
						return -1;
				}
				return 0;
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(list.get(i).getAge());
			sb.append(" ");
			sb.append(list.get(i).getName());
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
