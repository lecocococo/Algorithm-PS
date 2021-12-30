import java.io.*;
import java.util.*;

class DisjointSet{
    int[] parent ;
    int[] rank;
    int[] enemy;
    int[] size;

    DisjointSet(int n){
        this.parent = new int[n];
        this.rank = new int[n];
        this.enemy = new int[n];
        this.size = new int[n];
        for(int i =0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
            enemy[i] = -1;
            size[i] = 1;
        }
    }
    public int find(int u){
        // 루트반환
        if(parent[u] == u){
            return u;
        }
        // 경로상의 모든 노드들의 부모노들 루트노드로 바꿔 경로 최적화
        return parent[u] = find(parent[u]);
    }

    public int union(int u, int v){
        // u 나 v가 하나라도 공집합이라면 나머지 하나 반환
        if(u== -1 || v ==-1){
            return Math.max(u,v);
        }
        u = find(u); v = find(v);
        if (u==v){
            return u;
        }
        if(rank[u]>rank[v]){
            int temp = rank[u];
            rank[u] = rank[v];
            rank[v] = temp;
        }
        parent[u] = v;
        if(rank[u] == rank[v]) ++rank[v];
        size[v] += size[u];
        return v;
    }
    public boolean ack(int u, int v){
        u = find(u); v = find(v);
        if(enemy[u]==v){
            return false;
        }
        int a = union(u,v);
        int b = union(enemy[u], enemy[v]);

        enemy[a] = b;
        // 두 집합이 다 적대하는 집합이 없다면 b는 -1(공집합) 일수도 있다.
        if(b != -1){
            enemy[b] = a;
        }

        return true;
    }

    public boolean dis(int u, int v) {
        u = find(u); v = find(v);
        if (u == v){
            return false;
        }
        int a = union(u, enemy[v]);
        int b = union(v, enemy[u]);

        enemy[a] = b;
        enemy[b] = a;
        return true;
    }
}
public class Main {
    public static int C;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        C = Integer.parseInt(br.readLine());
        for(int c=0;c<C;c++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            DisjointSet ds = new DisjointSet(N);
            for (int i = 0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                if( st.nextToken().equals("ACK") ){
                    if(!ds.ack(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))){
                        System.out.println("CONTRADICTION AT" + (i+1));
                        return;
                    }
                }else{
                    if(!ds.dis(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))){
                        System.out.println("CONTRADICTION AT" + (i+1));
                        return;
                    }
                }
            }
            int result = maxSetSize(ds);
            System.out.println("MAX PARTY SIZE " + result);
        }
    }

    public static int maxSetSize(DisjointSet ds){
        int result = 0;
        for (int node = 0;node < N; node++){
            if(ds.parent[node] == node) {
                int enemy = ds.enemy[node];
                // 같은 모임 쌍을 2번 세지 않기위해 node> enemy인 경우만 세줌
                // enemy == -1 도 정확히 한번만 계산한다.
                if (enemy > node) {
                    continue;
                }
                int size = ds.size[node];
                int enemySize = (enemy == -1 ? 0 : ds.size[enemy]);

                result += Math.max(size, enemySize);

            }
        }
        return result;
    }
}
