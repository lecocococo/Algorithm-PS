//백준 7576번
// bfs
// bfs다중시작은 큐에 전부 집어넣고 시작

import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] tomato;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];

        int count = 0;
        Queue<int []> numOne = new LinkedList<>();

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                tomato[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        cnt = bfs();
        System.out.println(cnt);
    }

    public static int bfs(){
        int c = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if(tomato[i][j]==1){
                    q.add(new int[] {i, j, 0});
                }
            }
        }

        while(!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            c = q.peek()[2];

            q.poll();

            for (int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(tomato[nx][ny] == 0){
                        tomato[nx][ny] = 1;
                        q.add(new int[] {nx, ny , c+1});
                    }
                }
            }
        }

        for (int i =0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(tomato[i][j]==0){
                    c = -1;
                }
            }
        }
        return c;
    }
}
