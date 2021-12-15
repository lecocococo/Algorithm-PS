//알고스팟  트리 순회 순서 변경 (TRAVERSAL)
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static int C;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        for(int z = 0; z <C ;z++){
            int N  = Integer.parseInt(br.readLine());
            // mapToInt()의 결과는 Intstream, boxed()하면 int를 Integer로, collect(Collectors.toList()) 로 리스트 만듬
            List<Integer> pre = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            List<Integer> in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

            toPostOrder(pre, in);
        }
    }
    public static void toPostOrder(List<Integer> pre, List<Integer> in){
        int nodeCnt = pre.size();
        if (pre.isEmpty()){
            return;
        }
        int root = pre.get(0);
        int left = in.indexOf(root);
//        int right = nodeCnt - left - 1;
        // 2개의 서브트리로 나누어서 재귀
        toPostOrder(pre.subList(1,left + 1),in.subList(0,left));
        toPostOrder(pre.subList(left + 1,nodeCnt),in.subList(left + 1, nodeCnt));
        System.out.printf("%d ", root);

    }
}
