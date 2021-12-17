import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < C; tc++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;

            // tree는 현재 nerd의 모음
            TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();

            for (int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int pi = Integer.parseInt(st.nextToken());
                int qi = Integer.parseInt(st.nextToken());

                // pi 가 큰 놈들을 가져와서, qi도 큰지 확인, qi도 큰게 있으면, 새로들어오는 값은 너드가 아님
                Entry<Integer, Integer> higherEntry = tree.higherEntry(pi);

                if (higherEntry == null || (higherEntry != null && higherEntry.getValue() < qi)) {
                    // qi도 큰게 없으면, 일단 새로들어오는 값은 너드임
                    tree.put(pi, qi);

                    // 새로 너드가 들어왔으니, 기존 너드중, 새로들어온 값때문에 너드에서 제외되는거 확인 필요
                    // 너드 제외는, pi 가 작은 놈들을 가져와서, qi도 작은지 확인, qi도 작으면 tree에서 제거
                    Entry<Integer, Integer> lowerEntry = tree.lowerEntry(pi);
                    while (lowerEntry != null) {
                        if (lowerEntry.getValue() < qi) {
                            tree.remove(lowerEntry.getKey());
                        } else {
                            break;
                        }
                        lowerEntry = tree.lowerEntry(pi);
                    }
                }

                // 문제에서 입력이 들어올때마다 동적으로 너드 sum을 계산하라고 했음.
                sum += tree.size();

            }

            bw.write(Integer.toString(sum));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
