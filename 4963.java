import java.io.*;
import java.util.*;

public class Main {
    public static int w;
    public static int h;
    public static int cnt;
    public static int[][] map;
    static int[] dx = {1, 0, -1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h==0){
                break;
            }
            cnt = 0;
            map = new int[h+1][w+1];

            for (int i = 1;i<=h;i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 1;j<=w;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 1;i<=h;i++){
                for (int j = 1;j<=w;j++){
                    if(map[i][j] == 1){
                        bfs(i,j);
                        cnt++;
                    }
                }

            }
            System.out.println(cnt);
        }
    }

    public static void bfs(int x, int y){
        Queue<Point> q = new LinkedList();
        q.add(new Point(x,y));
        map[x][y] = 0;
        while(!q.isEmpty()){
            x = q.peek().x;
            y = q.peek().y;
            q.poll();
            for(int i=0;i<8;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if((nx>0&&ny>0&&nx<=h&&ny<=w) && map[nx][ny] ==1 ){
                    q.add(new Point(nx, ny));
                    map[nx][ny] = 0;
                }

            }
        }

    }
}

class Point{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
