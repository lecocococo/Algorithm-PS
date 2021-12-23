import java.io.*;
import java.util.*;
class segmentTree{
    int n;
    int[] rangeMin;
    int intMax = Integer.MAX_VALUE;

    segmentTree(ArrayList<Integer> arr){
        this.n = arr.size();
        rangeMin = new int[4*n];
//        rangeMin[0] = intMax;
        init(arr,0,n-1,1);
    }

    public int init(ArrayList<Integer> arr, int left, int right, int node){
        if(left == right) return rangeMin[node]= arr.get(left);
        int mid = (left+right)/2;
        int leftMin = init(arr, left, mid, node*2);
        int rightMin = init(arr, mid + 1, right, node*2 + 1);
        return rangeMin[node]=Math.min(leftMin, rightMin);
    }

    public int query(int left, int right, int node, int nodeLeft, int nodeRight){
        if(right<nodeLeft || nodeRight<left){
            return intMax;
        }
        if(left<= nodeLeft && right >= nodeRight){
            return rangeMin[node];
        }
        int mid = (nodeLeft+nodeRight)/2;

        return Math.min(query(left, right, node*2, nodeLeft, mid),
                        query(left, right, node*2 + 1, mid + 1, nodeRight));
    }
    public int queryCall(int left, int right){
        return query(left,right,1,0,n-1);
    }


}
public class Main {
    public static int C;
    public static int N;
    public static int Q;
    public static ArrayList<Integer> parentNode;
    static int[][] parent;
    public static int MAXN = 100000;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        C = Integer.parseInt(br.readLine());
        for(int c = 0;c<C;c++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            child = new ArrayList[N];
            for(int j= 0;j<N;j++){
                child[j] = new ArrayList();
            }
//            int[] parentNode = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j<N;j++){
                int parent = Integer.parseInt(st.nextToken());
                child[parent].add(j);
            }

            segmentTree seg = prepare();

            for(int q = 0;q<Q;q++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                System.out.println(distance(seg, a, b));
            }



        }




    }
    public static ArrayList<Integer>[] child;
    //트리의 번호와 일렬 번호 사이의 대응 관계
    public static int no2serial[] = new int[MAXN];
    public static int serial2no[] = new int[MAXN];
    //각 노드가 trip에 처음 등장하는 위치, 그리고 각 노드의 깊이
    public static int locInTrip[] = new int[MAXN];
    public static int depth[] = new int[MAXN];
    //다음 일렬번호
    public static int nextSerial;
    public static void traverse(int here, int dep, ArrayList<Integer> trip){
        //traverse()가 처음 방문하자마자 일렬 번호를 부여
        //이렇게 하면 항상 부모는 자손보다 작은 일렬 번호를 갖게 된다
        no2serial[here] = nextSerial;
        serial2no[nextSerial] = here;
        ++nextSerial;
        //깊이 계산
        depth[here] = dep;
        //trip에 현재 노드의 일렬 번호를 추가
        locInTrip[here] = trip.size();
        trip.add(no2serial[here]);
        //모든 자식 노드를 방문
        for (int i = 0; i < child[here].size(); i++) {
            traverse(child[here].get(i), dep + 1, trip);
            //자식 노드를 방문하고 현재 노드로 들어올 때마다 다시 추가
            trip.add(no2serial[here]);

        }

    }

    public static segmentTree prepare(){
        nextSerial = 0;
        ArrayList<Integer> trip = new ArrayList<>();
        traverse(0,0, trip);
        return new segmentTree(trip);
    }

    public static int distance(segmentTree seg, int u, int v){
        int lu = locInTrip[u]; int lv = locInTrip[v];

        if(lu>lv){
            int temp = lu;
            lu = lv;
            lv = temp;
        }
        int lca = serial2no[seg.queryCall(lu, lv)];
        return depth[u] + depth[v] - 2*depth[lca];
    }
}
