import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static boolean[] checked;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {

            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            checked = new boolean[n+1];
            count = 0;

            StringTokenizer st= new StringTokenizer(br.readLine());

            for(int i=1; i<n+1; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            dfsAll();

            System.out.println(n - count);
        }
    }

    static void dfs(int now) {
        if(visited[now])
            return;

        visited[now] = true;
        int next = arr[now];

        if(visited[next] != true)
            dfs(next);
        else {
            if(checked[next] != true) {
                // 노드가 끝나려면 싸이클을 지나가야함
                // 사이클 시작 정점부터 사이클 노드 갯수 셈
                count++;
                for(int i=next; i != now; i = arr[i])
                    count++;
            }
        }

        checked[now] = true;
    }

    static void dfsAll(){
        for(int i=1; i<n+1; i++)
            dfs(i);
    }
}
