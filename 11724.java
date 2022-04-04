// 백준 11724
// 아무것도 연결 안된 노드도 연결요소로 포함
import java.io.*;
import java.util.*;

public class Main {
    static int M,N;
    static int[][] adj;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N+1][N+1];
        visit = new boolean[N+1];
        for (int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[r][c] = 1;
            adj[c][r] = 1;
        }

        int cnt = 0;
        for(int i=1;i<=N;i++){
            for(int j =1;j<=N;j++){
                if (adj[i][j]==1 && !visit[j]){
                    bfs(j);
                    cnt++;
                }
            }
        }
        for(int i =1;i<=N;i++){
            if(visit[i] == false){
                cnt++;
            }
        }
        
        System.out.println(cnt);

    }

    static void bfs(int r){
        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        visit[r] = true;

        while (!q.isEmpty()){
            int node = q.poll();

            for(int i = 1;i<=N;i++){
                if(adj[node][i] == 1 && !visit[i]){
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
