import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static int S;
    public static int[] set;
    public static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        set = new int[N];
        cnt = 0;
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N;i++){
            set[i] = Integer.parseInt(st.nextToken());
        }

        //비트마스크
        int a = (1<<N) - 1;

        // 부분집합 전부 순회(공집합 제외)
        for(int i = a;i>0;i = ((i-1) & a)){
            check(i);
        }
        System.out.println(cnt);
    }

    //합을 확인하는 함수
    public static void check(int bit){
        int sum = 0;
        for(int i = 0;i<N;i++){
            if((bit & (1<<i)) > 0){
                sum += set[i];
            }
        }
        if(sum == S){
            cnt += 1;
        }
    }
}
