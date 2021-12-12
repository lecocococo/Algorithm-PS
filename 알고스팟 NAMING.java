import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split("");
        int k = a.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] pi = getPartialMatch(a);
        while(k>0){
            ans.add(k);
            k = pi[k-1];
        }
        for(int i:ans){
            System.out.println(i);
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
}
