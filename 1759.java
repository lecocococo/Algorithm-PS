import java.io.*;
import java.util.*;

public class Main{
    public static int L;
    public static int C;
    public static String[] arr;
    public static String[] result;
    public static boolean[] visited;
    public static StringBuilder sb;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = br.readLine().split(" ");
        Arrays.sort(arr);
        result = new String[L];
        visited = new boolean[C];
        sb = new StringBuilder();

        dfs(0, 0);
        System.out.println(sb);

    }

    public static void dfs(int start, int depth){
        // "(.*)a(.*)|(.*)i(.*)|(.*)e(.*)|(.*)o(.*)|(.*)u(.*)"
        // String.valueOf(result).matches(".*[a,i,e,o,u].*")
        if(depth == L ){
            int a = 0; int b = 0; String res = "";
            for (int i =0;i<L;i++){
                res += result[i];
                if (result[i].equals("a")||result[i].equals("i")||result[i].equals("e")||result[i].equals("o")||result[i].equals("u")){
                    a++;    //자음수 카운트
                }
                else{
                    b++;  //
                }
            }
            if (a>=1 && b>=2){
                sb.append(res).append('\n');
            }
            return;
        }

        for (int i = start; i<C;i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth] = arr[i];
//                    if(depth == L-1 && String.valueOf(result).matches("(.*)a(.*)|(.*)i(.*)|(.*)e(.*)|(.*)o(.*)|(.*)u(.*)")){
//                        dfs(depth + 1);
//                    }
                dfs(i + 1,depth + 1);
                visited[i] = false;

            }
        }
    }
}
