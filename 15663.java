import java.io.*;
import java.util.*;
//
public class Main {

    public static int[] arr;
    public static int[] l;
    public static boolean[] visited;
    private static HashSet<String> set = new HashSet<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i =0; i<N;i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);

        l = new int[M];
        visited = new boolean[N];
        dfs(N, M,0);
        System.out.println(sb);

    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            StringBuilder sb2 = new StringBuilder();
            for (int val : l) {
                sb2.append(val).append(' ');
            }
            if (!set.contains(sb2.toString())) {
                sb.append(sb2.toString()).append('\n');
                set.add(sb2.toString());
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                visited[i] = true;
                l[depth] = arr[i];
                dfs(N, M, depth + 1);
                visited[i] = false;
            }


        }
    }
}
