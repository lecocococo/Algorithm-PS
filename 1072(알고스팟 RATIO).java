import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


//        System.out.println(C);
        long L = 2000000000;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
//            System.out.println(N);
//            System.out.println(M);

        if (rate(N, M) == rate(N+L, M+L)){
            System.out.println(-1);
            return;
        }

        long low = 0; long high = L;

        while(low + 1 < high){
            long mid = (low + high)/2;
            if (rate(N, M) == rate(N+mid, M+mid)){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        System.out.println(high);
    }

    public static long rate(long a, long b){
        return (b*100) / a;
    }
}
