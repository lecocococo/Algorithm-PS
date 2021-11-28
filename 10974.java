import java.io.*;
import java.util.*;

public class Main{

    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        visited = new boolean[N];
        dfs(N, 0);
        System.out.println(sb);
    }

    public static void dfs(int N, int depth){
        if (depth == N){
            for(int num:arr){
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i =0; i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, depth + 1);
                visited[i] = false;
            }
        }
    }
}
