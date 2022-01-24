import java.io.*;
import java.util.*;

public class Main {
    public static int R;
    public static int C;
    public static char[][] adj;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy= {0,-1,0,1};
    public static int cnt;
    public static int result;
    public static ArrayList<Character> check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        adj = new char[R][C];
        cnt = 1;
        result = 0;
        check = new ArrayList<>();

        // stream API가 가독성은 좋으나 느림 그래서 시간초과에 계속 걸렸다
//        for (int i = 0;i<R;i++){
//            String str = br.readLine();
//            adj[i] = Arrays.stream(str.split("")).toArray(String[]::new);
//        }
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j =0; j < C; j++) {
                adj[i][j] = str.charAt(j);
            }
        }


        check.add(adj[0][0]);
        dfs(0,0);

        if(result==0){
            result = 1;
        }
        System.out.println(result);




    }

    public static boolean rangeCheck(int x, int y){
        if((x>=0&&x<R) &&(y>=0&&y<C)){
            return true;
        } else{
            return false;
        }
    }

    public static void dfs(int x,int y){
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(rangeCheck(nx, ny) && !check.contains(adj[nx][ny])) {

                check.add(adj[nx][ny]);
                cnt++;
                dfs(nx,ny);
                result = Math.max(cnt, result);
                cnt--;
                check.remove(check.size()-1);

            }
        }
    }
}
