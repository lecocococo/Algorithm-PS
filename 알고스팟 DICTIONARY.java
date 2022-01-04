import java.io.*;
import java.util.*;

public class Main {
    public static int C;
    public static boolean[] visit;
    public static List<Integer> order;
    public static int[][] adjacent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C=Integer.parseInt(br.readLine());
        for(int c=0;c<C;c++){
            int n = Integer.parseInt(br.readLine());

            String[] arr = new String[n];
            for(int i=0;i<n;i++){
                arr[i] = br.readLine().trim();
            }


            makeGraph(arr);
            List<Integer> sort = topologicalSort();

            if (sort.isEmpty()){
                System.out.println("INVALID HYPOTHESIS");
            }else{
                for(int i=0;i<sort.size();i++){
                    System.out.print((char) (order.get(i) + 'a'));
                }
            }

        }
    }
    // 간선 (i,j)는 알파벳i가 j보다 앞에 와야함을 나타냄
    public static void makeGraph(String[] arr){
        adjacent = new int[26][26];

        for(int j = 1;j< arr.length;j++){
            int i = j-1;
            int len = Math.min(arr[i].length(), arr[j].length());
            for(int k = 0; k<len;k++){
                if ( arr[i].charAt(k) != arr[j].charAt(k) ){
                    int a = arr[i].charAt(k) - 'a';
                    int b = arr[j].charAt(k) - 'a';
                    adjacent[a][b] = 1;
                    break;
                }

            }
        }
    }
    public static void dfs(int here){
        visit[here] = true;
        for(int there = 0 ; there< adjacent.length;there++){
            if(adjacent[here][there]==1 && !visit[there]){
                dfs(there);
            }
        }
        order.add(here);
    }

    public static List<Integer> topologicalSort(){
        int n = adjacent.length;
        visit = new boolean[n];
        order = new ArrayList<Integer>();

        for(int k=0;k< n;k++){
            if(!visit[k]){
                dfs(k);
            }
        }
        Collections.reverse(order);

        for(int i =0; i< n;i++){
            for(int j=i+1;j< n;j++){
                // 사이클생겨버리면
                if(adjacent[order.get(j)][order.get(i)] == 1){
                    return new ArrayList<Integer>();
                }
            }
        }
        return order;

    }

}
