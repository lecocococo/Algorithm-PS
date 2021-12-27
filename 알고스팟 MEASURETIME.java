import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

class FenwickTree{
    int[] tree;
    FenwickTree(int n){
        this.tree = new int[n+1];
    }

    int sum(int pos){
        pos++;
        int result = 0;
        while(pos>0){
            result += tree[pos];
            pos &= (pos-1);
        }
        return result;
    }

    void add(int pos, int val){
        pos++;
        while (pos< tree.length){
            tree[pos] += val;
            pos += (pos & -pos);
        }

    }
}

public class Main {
    public static int C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        C = Integer.parseInt(br.readLine());
        for(int c=0;c<C;c++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            bw.write(String.valueOf(countSwap(arr)));
            bw.flush();
        }
        br.close();
        bw.close();
    }

    public static Long countSwap(int[] arr){
        FenwickTree tree = new FenwickTree(1000000);
        Long result = 0L;
        for(int i=0;i< arr.length;i++){
            result += tree.sum(999999) - tree.sum(arr[i]);
//            System.out.println(result);
            tree.add(arr[i],1);
        }
        return result;
    }

}
