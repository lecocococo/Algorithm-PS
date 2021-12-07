import java.io.*;
import java.util.*;
public class Main {
    public static int INF = 987654321;
    public static int N, K, M, L;
    // prerequisite[i] = i번째 과목의 선수과목의 집합
    public static int[] prerequisite;
    // classes[i] = i번째 학기에 개설되는 과목의 집합
    public static int[] classes;
    public static int[][] cache;
    public static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        prerequisite = new int[N];
        for(int i =0;i<N;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st2.nextToken());
            for(int k=0;k<num;k++){
                prerequisite[i] |= (1<<Integer.parseInt(st2.nextToken()));
            }
        }

        classes = new int[M];
        for(int i =0;i<M;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st3.nextToken());
            for(int k=0;k<num;k++){
                classes[i] |= (1<<Integer.parseInt(st3.nextToken()));
            }
        }
        // 예를들어 taken이 최대 4개 가능=> 4개로 조합가능한 부분집합의 공간 최소 15개 필요(따라서 1<<N)임
        cache = new int[M][1<<N];

        graduate(0,0);

        if (result<INF){
            System.out.println(result);
        }
        else{
            System.out.println("IMPOSSIBLE");
        }

    }

    // 이번 학기가 semester이고, 지금까지 들은 과목의 집합이 taken일 때
    // k개 이상의 과목을 모두 들으려면 몇 학기나 더 있어야 하는가?
    // 불가능한 경우 Integer.MAX_VALUE를 반환한다.
    public static int graduate(int semester, int taken) {
        // 기저 사례: k개 이상의 과목을 이미 들은 경우
        if (Integer.bitCount(taken) >= K) return 0;
        // 기저 사례: m 학기가 전부 지난 경우
        if (semester == M) return INF;
        // 메모이제이션
        if (cache[semester][taken] != 0)
            return cache[semester][taken];
        else{
            cache[semester][taken] = semester;
        }
        result = INF;
        // 이번 학기에 들을 수 있는 과목 중 아직 듣지 않은 과목들을 찾는다.
        int canTake = (classes[semester] & ~taken);
        // 선수 과목을 다 듣지 않은 과목들을 걸러낸다.
        for (int i = 0; i < N; i++)
            if ((canTake & (1 << i)) > 0 && (taken & prerequisite[i]) != prerequisite[i])
                canTake &= ~(1 << i);
        // 이 집합의 모든 부분집합을 순회한다.
        for (int take = canTake; take > 0; take = ((take - 1) & canTake)) {
            // 한 학기에 L 과목까지만 들을 수 있다.
            if (Integer.bitCount(take) > L) continue;
            result = Math.min(result, graduate(semester + 1, taken | take) + 1);
        }
        // 이번 학기에 아무 것도 듣지 않을 경우
        result = Math.min(result, graduate(semester + 1, taken));
        return result;
    }
}
