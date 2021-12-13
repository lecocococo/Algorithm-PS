import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static int C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());

        for(int z= 0;z<C;z++){
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            String[] original = br.readLine().split("");
            for(int x = 0;x<N; x++){
                String[] next = br.readLine().split("");
                if(x%2==1){
                    sum += shift(original,next);
                    original = next;
                }else{
                    sum += shift(next, original);
                    original = next;
                }
            }
            System.out.println(sum);
        }

    }
    public static int[] getPartialMatch(String[] n){
        int m = n.length;
        int[] arr = new int[m];
        int begin = 1; int matched = 0;
        while(begin + matched<m){
            if(n[begin + matched].equals(n[matched])){
                ++matched;
                arr[begin + matched - 1] = matched;
            }
            else{
                if(matched == 0){
                    begin++;
                }
                else{
                    begin += matched - arr[matched - 1];
                    matched = arr[matched - 1];
                }
            }
        }
        return arr;
    }

    public static ArrayList<Integer> kmpSearch(String[] h, String[] n){
        int k = h.length;
        int m = n.length;
        ArrayList<Integer> arr = new ArrayList<>();
        int[] pi = getPartialMatch(n);
        int begin = 0; int matched = 0;
        while(begin <k-m){
            if(matched<m && h[begin + matched].equals(n[matched])){
                ++matched;
                if(matched == m){
                    arr.add(begin);
                }
            }
            else{
                if(matched == 0){
                    begin++;
                }
                else{
                    begin += matched - pi[matched - 1];
                    matched = pi[matched - 1];
                }
            }
        }
        return arr;
    }

    public static int shift(String[] a, String[] b){
        return kmpSearch(Stream.concat(Arrays.stream(a), Arrays.stream(a)).toArray(String[]::new),b).get(0);
    }
}
