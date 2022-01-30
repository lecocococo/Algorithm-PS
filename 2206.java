import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[][] map;
    private static int[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    static class Point {
        int x, y, distance;
        int drill; 

        public Point(int x, int y, int distance, int drill) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.drill = drill;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        int ans = bfs(0, 0);
        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 1, 0)); // (1, 1)에서 시작
        visited[y][x] = 0; // 처음 공사 횟수

        while (!q.isEmpty()) {
            Point point = q.poll();

            // 도착지점을 만났다면 종료한다.
            if (point.x == M - 1 && point.y == N - 1)
                return point.distance;

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (visited[ny][nx] > point.drill) {
                        if (map[ny][nx] == 0) { // 벽이 아닐 때
                            q.add(new Point(nx, ny, point.distance + 1, point.drill));
                            visited[ny][nx] = point.drill;
                        } else { // 벽일 때
                            if (point.drill == 0) { 
                                q.add(new Point(nx, ny, point.distance + 1, point.drill + 1));
                                visited[ny][nx] = point.drill + 1;
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
}
