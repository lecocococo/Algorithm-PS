import java.io.*;
import java.util.*;

public class Main {
    public static int M;
    public static int N;
    public static int[][] adj;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy= {0,1,0,-1};
    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        adj = new int[M][N];
        dp = new int[M][N];



        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }


        int answer = dfs(0, 0);
//        for(int i = 0; i < M; i++) {
//            for(int j =0; j < N; j++) {
//                System.out.printf("%d ", dp[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(answer);
    }

    public static boolean rangeCheck(int x, int y){
        if((x>=0&&x<M) &&(y>=0&&y<N)){
            return true;
        } else{
            return false;
        }
    }

    public static int dfs(int x,int y){
        if (x == M-1 && y==N-1){
            return 1;
        }
        if (dp[x][y]!=-1){
            return dp[x][y];
        }
        dp[x][y] = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(rangeCheck(nx, ny) && adj[nx][ny]<adj[x][y]) {
                dp[x][y] += dfs(nx,ny);
            }
        }
        return dp[x][y];
    }
}
