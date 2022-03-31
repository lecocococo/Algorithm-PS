//백준 1697번
//bfs
// visit 배열을 통해 시간초 적어둠과 동시에 0이 아니면 방문함을 체크
// 무조건 K에 먼저 도착한게 빠름(큐의 선입선출 구조 때문)
import java.io.*;
import java.util.*;

public class Main {
    static int N = 0;
    static int K = 0;
    static int cnt = Integer.MAX_VALUE;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit= new int[150000];
        int result;
        if (N==K){
            result = 0;
        }else{
            result = bfs(N);
        }

        System.out.println(result);
    }

    public static int bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while (!q.isEmpty()){
            int n = q.peek();
            q.poll();

            for(int i =0;i<3;i++){
                int nextPoint;

                if(i == 0){
                    nextPoint = n - 1;
                }else if (i==1){
                    nextPoint = n + 1;
                }else {
                    nextPoint = 2 * n;
                }

                if(n==K){
                    return visit[n];
                }

                if(0<=nextPoint && nextPoint<=100000){
                    if(visit[nextPoint] == 0){
                        q.add(nextPoint);
                        visit[nextPoint] = visit[n] + 1;
                    }
                }
            }
        }
        return 0;
    }
}
