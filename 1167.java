// 트리의 특성을 생각해 보면 모든 정점은 사이클이 없이 연결이 되어 있고
// 한 정점에서 다른 정점으로 가는 경로는 유일하다.
// 그래서 가장 멀리있는 두 정점의 경로는 항상 유일하다.
// 한 정점에서 가장 먼 정점으로 가는 경로와 가장 먼 정점 사이의 경로는 항상 일부가 겹친다
import java.io.*;
import java.util.*;

class Node{
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
public class Main {
    public static int V;
    public static ArrayList<Node>[] arr;
    public static boolean visited[];
    static int node;
    static int max = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.valueOf(br.readLine());
        arr = new ArrayList[V+1];
        visited = new boolean[V+1];

        for(int i = 1;i<V+1;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=1;i<V+1;i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            while(true){
                int vertex = Integer.parseInt(st.nextToken());
                if(vertex == -1){
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                arr[idx].add(new Node(vertex, weight));
            }
        }

        // 임의의 노드에서 부터 가장 먼거리의 노드를 node에 저장
        dfs(1,0);

        // node에서 부터 가장 먼 노드까지의 거리 얻음
        visited = new boolean[V+1];
        dfs(node, 0);


        System.out.println(max);

    }

    public static void dfs(int x, int len){
        if(len>max){
            max = len;
            node = x;
        }
        visited[x] = true;

        for(int i=0;i<arr[x].size();i++){
            Node n = arr[x].get(i);
            if(!visited[n.vertex]){
                visited[n.vertex] =true;
                dfs(n.vertex, n.weight + len);

            }
        }
    }
}
