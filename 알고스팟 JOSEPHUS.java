// 알고스팟 조세푸스 문제(JOSEPHUS)
// 백준 1158번과 비슷한 문제이다
import java.io.*;
import java.util.*;

public class Main {
    public static int C;
    public static int N;
    public static int K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        for(int i = 0;i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            LinkedList<Integer> link = new LinkedList<>();
            for(int j = 0;j < N;j++){
                link.add(j+1);
            }
            for(int k:link){
                System.out.println(k);
            }
            int idx = 0;
            while(link.size()>2){
                link.remove(idx);
                // 원형연결 리스트 처럼 하기위해 끝에 도달하면 index를 맨앞으로 바꿔줌
                if(idx == link.size()){
                    idx = 0;
                }
                // K-1번 뒤가 죽는 사람
                for(int m=0;m<K-1;m++){
                    idx++;
                    // 원형연결 리스트 처럼 하기위해 끝에 도달하면 index를 맨앞으로 바꿔줌
                    if(idx == link.size()){
                        idx = 0;
                    }
                }
            }
            System.out.println(link.getFirst() +" " + link.getLast());
        }

    }
}
