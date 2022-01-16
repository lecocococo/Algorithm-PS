import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static int numberCnt;
    public static Vector<Integer> num;
    public static Map<ArrayList<Integer>, Integer> memo = new HashMap<ArrayList<Integer>, Integer>();
    
    public static void preCalc(int preCalcNum) {
        // 어차피 비율로 계산되니, 이미 정렬된 형태의 루트 노드를 하나 만듬
        ArrayList<Integer> perm = new ArrayList<Integer>();
        for (int i = 0; i < preCalcNum; i++) {
            perm.add(i);
        }

        // bfs형태로 그래프를 생성하면서 동시에 dist을 기록(memo)해둔다
        Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();

        // 큐의 시작은 위에서 만든 루트 노드
        memo.put(perm, 0);
        q.add(perm);

        while (!q.isEmpty()) {
            // 큐에서 하나 꺼네욤
            ArrayList<Integer> here = q.poll();

            // 현재 위치까지의 거리
            int cost = memo.get(here);

            // 실제로 뒤집기를 해본다
            for (int i = 0; i < preCalcNum; i++) {
                for (int j = i + 2; j <= preCalcNum; j++) {
                    // 사실상 뒤집어져서 나온 값은, 그래프에서 새로운 노드와 마찬가지임
                    // 우리 그래프의 하나의 노드는 vector니깐!
                    ArrayList<Integer> clone = (ArrayList<Integer>) here.clone();
                    Collections.reverse(clone.subList(i, j));

                    if (memo.get(clone) == null) {
                        memo.put(clone, cost + 1);
                        q.add(clone);
                    }
                }
            }
        }

        return;
    }

    public static String getSolution() {
        // 문제로 주어지는 수열을, 0 ~ n 형태의 수열로 치환한다.
        Vector<Integer> newVector = new Vector<Integer>(numberCnt);
        for (int i = 0; i < numberCnt; i++) {
            int smaller = 0;
            for (int j = 0; j < numberCnt; j++) {
                if (num.get(j) < num.get(i)) {
                    smaller++;
                }
            }
            newVector.add(i, smaller);
        }

        return String.valueOf(memo.get(newVector));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i < 9; i++) {
            preCalc(i);
        }

        for (int c = 0; c < tc; c++) {
            numberCnt = Integer.parseInt(br.readLine());
            num = new Vector<Integer>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n < numberCnt; n++) {
                int val = Integer.parseInt(st.nextToken());
                num.add(val);
            }

            bw.write(getSolution());
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
