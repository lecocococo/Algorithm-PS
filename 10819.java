import java.io.*;
import java.util.*;

public class Main{
    public static int[] arr;
    public static int[] result;
    public static boolean[] visited;
    public static int mx;
    public static int sum;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        result = new int[N];
        visited = new boolean[N];
        mx = Integer.MIN_VALUE;
        sum = 0;
        dfs(N, 0, sum);
        System.out.println(mx);

    }
    public static void dfs(int N, int depth, int sum){
        if (depth == N){

            if (sum > mx){ mx = sum; }
            return;
        }

        for(int i =0; i<N;i++){
            if(!visited[i]){
                if (sum > mx){ mx = sum; }
                visited[i] = true;
                result[depth] = arr[i];
                if (depth != 0){
                    dfs(N, depth + 1, sum + Math.abs(result[depth-1] - result[depth]));
                }
                else {
                    sum = 0;
                    dfs(N, depth + 1, 0);
                }

                visited[i] = false;
            }
        }

    }

}
