//import java.io.*;
//import java.util.*;

public class Main{
    public static int N;
    public static int[] arr;
    public static int[] result;
    public static boolean[] visited;
    public static StringBuilder sb;
    public static StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        while (true){
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = arr[0];
            if (N==0){
                break;
            }
            arr = Arrays.copyOfRange(arr,1, arr.length);
            result = new int[6];
            visited = new boolean[N];
            sb = new StringBuilder();
            dfs(0);
//            System.out.println(sb);
            sb2.append(sb);
            sb2.append("\n");

        }
        System.out.println(sb2);
    }

    public static void dfs(int depth){
        if (depth == 6){

            for(int k = 0;k<result.length;k++){
                sb.append(result[k]).append(" ");
            }
            sb.append('\n');
//            System.out.println(sb);
            return;
        }

        for (int i =0; i<N;i++){
            if (!visited[i]){
                if (depth == 0 || (depth > 0 && arr[i]>result[depth - 1])){
                    visited[i] = true;
                    result[depth] = arr[i];
                    dfs(depth + 1);
                    visited[i] = false;
                }


            }
        }
    }
}
