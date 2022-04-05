// 백준 14502번
// bfs
// 벽세우는것을 브루트 포스로 다 해봐야함
import java.io.*;
import java.util.*;

public class Main {
    static int M,N;
    static int[][] lab;
    static int[][] wall;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = Integer.MIN_VALUE;

    public static int[][] copy(int[][] arr){
        int[][] n = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j =0;j<M;j++){
                n[i][j]=arr[i][j];
            }
        }
        return n;
    }

    public static void makeWall(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (wall[i][j] == 0) {
                    wall[i][j] = 1;
                    makeWall(depth + 1);
                    wall[i][j] = 0;
                }
            }
        }
    }

    public static int toInt(String s){
        return Integer.parseInt(s);
    }

    static void bfs(){
        int[][] newWall = copy(wall);
        Queue<Point> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j =0;j<M;j++){
                if(newWall[i][j]==2){
                    q.add(new Point(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            int r = q.peek().x;
            int c = q.peek().y;
            q.poll();

            for(int i=0;i<4;i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if ((nr>=0&&nc>=0&&nr<N&&nc<M) &&  newWall[nr][nc] ==0){
                    newWall[nr][nc] = 2;
                    q.add(new Point(nr,nc));
                }

            }
        }
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j =0;j<M;j++){
                if(newWall[i][j]==0){
                    cnt++;
                }
            }
        }
        result = Math.max(result,cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = toInt(st.nextToken());
        M = toInt(st.nextToken());

        lab = new int[N][M];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                lab[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        wall = copy(lab);
        makeWall(0);

        System.out.println(result);
    }
}
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
