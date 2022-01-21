import java.io.*;
import java.util.*;

public class Main {
    
    public static int C;
    public static int N;
    public static Vector<Integer> num;
    public static Map<ArrayList<Integer>, Integer> toSort = new HashMap<>(); // 1~n-1의 모든 순열에 대해toSort[]를 께산해서 저장
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        for(int i =0;i<9;i++){
            preCalc(i);
        }
        for(int c =0;c<C;c++){
            N = Integer.parseInt(br.readLine());
            num = new Vector<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                num.add(Integer.parseInt(st.nextToken()));
            }
            
            System.out.println(solver());
        }
    }

    public static void preCalc(int preCalcNum) {
        // 어차피 비율로 계산되니, 이미 정렬된 형태의 루트 노드를 하나 만듬
        ArrayList<Integer> perm = new ArrayList<Integer>();
        for (int i = 0; i < preCalcNum; i++) {
            perm.add(i);
        }

        // bfs형태로 그래프를 생성하면서 동시에 거리 기록
        Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
        
        toSort.put(perm, 0);
        q.add(perm);

        while (!q.isEmpty()) {
            // 큐에서 하나 꺼냄
            ArrayList<Integer> here = q.poll();

            // 현재 위치까지의 거리
            int cost = toSort.get(here);

            // 실제로 뒤집기를 해본다
            for (int i = 0; i < preCalcNum; i++) {
                for (int j = i + 2; j <= preCalcNum; j++) {
                    // 뒤집어져서 나온 값은 그래프에서 새로운 노드와 같다
                    ArrayList<Integer> clone = (ArrayList<Integer>) here.clone();
                    Collections.reverse(clone.subList(i, j));

                    if (toSort.get(clone) == null) {
                        toSort.put(clone, cost + 1);
                        q.add(clone);
                    }
                }
            }
        }
    }
    
    public static int solver(){
        Vector<Integer> changed = new Vector<Integer>(N);
        for(int i=0;i<N;i++){
            int small = 0;
            for (int j=0;j<N;j++){
                if(num.get(j) < num.get(i)){
                    ++small;
                }

            }
            changed.add(i, small);
        }
        return toSort.get(changed);
    }
}
