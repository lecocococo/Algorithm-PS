import java.io.*;
import java.util.*;

public class Main {
    static int T = 0;
    static int M = 0;
    static int N = 0;
    static int K = 0;
    static int cnt = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] land;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0;t<T;t++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            land = new boolean[M][N];
            visit = new boolean[M][N];
            cnt = 0;

            for (int k = 0; k<K;k++) {
                st = new StringTokenizer(br.readLine());
                int i=Integer.parseInt(st.nextToken());
                int j=Integer.parseInt(st.nextToken());
                land[i][j] = true;
            }
            // System.out.println(Arrays.deepToString(land));
            for (int i =0;i<M;i++) {
                for (int j = 0;j<N;j++) {
                    if(land[i][j] == true && !visit[i][j]){
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    public static void bfs(int start, int end){
        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {start, end});

        while (!q.isEmpty()){
            start = q.peek()[0];
            end = q.peek()[1];
            visit[start][end] = true;
            q.poll();
            for(int i= 0; i<4;i++){
                int x = start + dx[i];
                int y = end + dy[i];

                if(x>=0 && y>=0 && x<M &&y<N){
                    if(land[x][y]== true
                            && !visit[x][y]){
                        q.add(new int[] {x, y});
                        visit[x][y] = true;
                    }
                }

            }
        }
    }
}
