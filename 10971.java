import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static int[][] arr;
    public static boolean[] visited;
    public static int mn;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        mn = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 각 도시를 시작점으로 해서 다 돌려 봐야함
        for(int k =0;k<N;k++){
            dfs(k,k,0,0);
        }
        System.out.println(mn);
    }

    public static void dfs(int start, int d, int depth, int sum){
        // 도시 수 만큼 돌았고 시작도시랑 끝도시랑 같을때만 값으 바꿔줌
        if(depth == N && start == d){
            if(sum<mn){
                mn = sum;
            }
            return;
        }
        for(int i = 0;i<N;i++){
            // 도시간의 연결 끊겻을때
            if (arr[d][i]==0) {continue;}

            if(!visited[i]){
                visited[i] = true;
                sum += arr[d][i];
                // 굳이 이미 sum값이 최소값보다 큰데 재귀에 들어갈 필요가 없으니 back tracking
                if (sum <= mn){
                    dfs(start, i, depth + 1, sum);
                }
                visited[i] = false;
                sum -= arr[d][i];
            }
        }
    }
}
