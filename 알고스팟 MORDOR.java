// 알고스팟 등산로(MORDOR)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
        C = Integer.parseInt(br.readLine());
        for(int c=0;c<C;c++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int temp[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> array = (ArrayList<Integer>) Arrays.stream(temp).boxed().collect(Collectors.toList());
            ArrayList<Integer> minusArray = new ArrayList<>();
            for(int a = 0; a<array.size();a++){
                minusArray.add((-1) * array.get(a));
            }
            segmentTree mx = new segmentTree(array);
            segmentTree mn = new segmentTree(minusArray);

            while(q!=0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int low = mx.queryCall(a,b);
                int high = Math.abs(mn.queryCall(a,b));
                bw.write(String.valueOf(high - low));
                bw.newLine();
                q--;
            }
            bw.flush();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
