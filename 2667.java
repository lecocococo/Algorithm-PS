import java.io.*;
import java.util.*;

public class Main{
    public static int[][] adj;
    public static int N;
    public static boolean[][] visited;
    public static int cnt;
    public static int aptCnt;
    public static ArrayList<Integer> result;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        visited = new boolean[N][N];
        cnt = 0;
        result = new ArrayList<>();

        for (int i = 0;i<N;i++){
            String str = br.readLine();
            adj[i] = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
        }

        dfsAll();

        System.out.println(cnt);
        Collections.sort(result);
        for(int j:result){
            System.out.println(j);
        }

    }

    public static boolean rangecheck(int x, int y){
        if((x>=0&&x<N) &&(y>=0&&y<N)){
            return true;
        } else{
            return false;
        }
    }

    public static void dfs(int x,int y){

        visited[x][y] = true;

        if(rangecheck(x,y+1) && (!visited[x][y+1] && adj[x][y+1]==1)){
            aptCnt++;
            dfs(x,y+1);
        }
        if(rangecheck(x+1,y) && (!visited[x+1][y] && adj[x+1][y]==1)){
            aptCnt++;
            dfs(x+1,y);
        }
        if(rangecheck(x,y-1) &&(!visited[x][y-1] && adj[x][y-1]==1)){
            aptCnt++;
            dfs(x,y-1);
        }
        if(rangecheck(x-1,y) && (!visited[x-1][y] && adj[x-1][y]==1)){
            aptCnt++;
            dfs(x-1,y);
        }
    }

    public static void dfsAll(){
        for(int i=0;i<N;i++){
            for(int j =0;j<N;j++) {
                if (visited[i][j]==false&&adj[i][j] == 1) {
                    aptCnt = 1;
                    dfs(i, j);
                    cnt++;
                    result.add(aptCnt);
                }
            }
        }
    }
}
