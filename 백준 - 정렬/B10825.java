import java.io.*;
import java.util.*;

class Student{
	String name;
	int a;
	int b;
	int c;
	
	Student(String name, int a, int b, int c){
		this.name = name;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public String getName() {
        return this.name;
    }
	
	public int getA() {
        return this.a;
    }
	
	public int getB() {
        return this.b;
    }
	
	public int getC() {
        return this.c;
    }
}

public class B10825 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		List<Student> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String[] sarr = br.readLine().split(" ");
			list.add(new Student(sarr[0], Integer.valueOf(sarr[1]),
					Integer.valueOf(sarr[2]), Integer.valueOf(sarr[3])));
		}
		
		//a는 국어, b는 영어, c는 수학
		//국어 점수가 감소하는 순서로
		//국어 점수가 같으면 영어 점수가 증가하는 순서로
		//국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
		//모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
		//이름 비교를 위해 s1.name.compareTo(s2.name) 사용
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				if(s1.a>s2.a)
					return -1;
				else if(s1.a<s2.a)
					return 1;
				else if(s1.a==s2.a) {
					if(s1.b>s2.b)
						return 1;
					else if(s1.b<s2.b)
						return -1;
					else if(s1.b==s2.b) {
						if(s1.c>s2.c)
							return -1;
						else if(s1.c<s2.c)
							return 1;
						else if(s1.c==s2.c) {
							if(s1.name.compareTo(s2.name)>0)
								return 1;
							else if(s1.name.compareTo(s2.name)<0)
								return -1;
								
						}
							
					}
				}
				return 0;
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(list.get(i).getName());
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
