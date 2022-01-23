import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int V;

    public static ArrayList<Integer>[] adj;
    public static boolean[] visited;
    public static ArrayList<Integer> result;

    public static Queue<Integer> q;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        //dfs
        visited = new boolean[N+1];
        adj = new ArrayList[N+1];
        result = new ArrayList<>();

        for(int k=1;k<N+1;k++){
            adj[k] = new ArrayList<>();
        }

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start].add(end);
            adj[end].add(start);
        }

        // 작은 정점 번호 부터 방문하기 위해
        for(int j = 0;j<N+1;j++){
            if(adj[j]!=null)
                Collections.sort(adj[j]);
        }
        
        //dfs
        result.add(V);
        dfs(V);
        for(int i:result){
            System.out.printf("%d ",i);
        }
        
        //bfs
        System.out.println();
        for(int j:bfs(V)){
            System.out.printf("%d ", j);
        }
    }

    public static void dfs(int here){
        visited[here] = true;
        for(int i = 0;i<adj[here].size();i++){
            int there = adj[here].get(i);
            if(!visited[there]){
                result.add(there);
                dfs(there);
            }
        }
    }

    public static ArrayList<Integer> bfs(int start){
        q = new LinkedList<>();
        ArrayList<Integer> bfsResult= new ArrayList<>();
        boolean[] visit = new boolean[N+1];

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int here = q.poll();
            visit[here] = true;

            bfsResult.add(here);

            for(int i =0;i<adj[here].size();i++){
                int there = adj[here].get(i);
                if(!visit[there]){
                    q.add(adj[here].get(i));
                    visit[there] = true;
                }
            }
        }
        return bfsResult;
    }
}
