import java.io.*;
import java.util.*;

public class Main {
    public static int M;
    public static int[][] adj;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy= {0,1,0,-1};
    public static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());

        adj = new int[M][M];
        dp = new int[M][M];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j < M; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 0;
            }
        }

        int answer = dfsAll(0, 0);

//        for(int i = 0; i < M; i++) {
//            for(int j =0; j < M; j++) {
//                System.out.printf("%d ", dp[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println(answer);
    }

    public static boolean rangeCheck(int x, int y){
        if((x>=0&&x<M) &&(y>=0&&y<M)){
            return true;
        } else{
            return false;
        }
    }

    public static int dfs(int x,int y){
        if(dp[x][y]>0){
            return dp[x][y];
        }
        dp[x][y] = 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(rangeCheck(nx, ny) && adj[nx][ny]>adj[x][y]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }
        return dp[x][y];
    }

    public static int dfsAll(int x, int y){
        int answer = 0;
        for(int i = 0; i < M; i++) {
            for(int j =0; j < M; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }
        return answer;
    }

}
