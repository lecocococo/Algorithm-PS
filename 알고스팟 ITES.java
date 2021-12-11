// 알고스팟 외계신호 분석 (ITES)
import java.io.*;
import java.util.*;

public class Main {
    public static int C;
    public static int K;
    public static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        C = Integer.parseInt(br.readLine());


        long MOD= (long)Math.pow(2,32);
        while((C--) != 0){
            long al = 1983;
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new LinkedList<>();
            int sum = 0;
            int cnt = 0;
            for(int i =0;i<N;i++){
                int num = (int)(al % 10000) + 1;  //al % 10000에 괄호 안쳐주고 (int)헤버리니 음수값나옴 조심....
                sum += num;
                q.offer(num);

                while(sum>K){
                    sum -=q.poll(); // poll 반환하면서 제거(peek() 이 첫번째값 보여줌)

                }
                if(sum == K){
                    cnt++;

                }
                al = (al * 214013 + 2531011)%MOD;
            }
            System.out.println(cnt);
        }
    }
}
