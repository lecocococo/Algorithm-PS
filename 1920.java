import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] a;
    public static int[] m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        M = Integer.parseInt(br.readLine());
        m = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<M;i++){
            m[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0;i<M;i++){
            if(biSearch(m[i]) >=0){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }




    }
    public static int biSearch(int num){
        int first = 0;
        int last = a.length - 1;

        while(first<=last){
            int mid = (first + last) /2;
            if (num < a[mid]){
                last = mid -1;
            }
            else if(num> a[mid]){
                first = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;

    }
}
