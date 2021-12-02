import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] day;
    public static int[] benefit;
    public static int[][] dp;
    public static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        day = new int[N + 1]; day[0] = 0;
        benefit = new int[N + 1]; benefit[0] = 0;
        dp = new int[2][N + 2]; dp[0][0] = 0; dp[1][0] = 0;

        min = Integer.MAX_VALUE;
        for(int i = 1; i <= N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            benefit[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for(int k = 1 ;k <= N; k++){
            
            // 진짜 점화식을 세운 dp풀이
            if(k + day[k]<=N+1){
                // (현재 날짜 + 상담 완료)날짜에 저장된 최대 수입과 와 (오늘 이전까지 최대 수입 + 오늘 버는 수입) 중 최대값을 저장
                dp[1][k + day[k]] = Math.max(dp[1][k + day[k]], dp[1][k] + benefit[k]);
            }
            // 0인 경우 이전의 최대 값 넣음
            dp[1][k+1] = Math.max(dp[1][k + 1], dp[1][k]);

            // 원래 푼방식
//            int max = Integer.MIN_VALUE;
//            dp[0][k] = k + day[k];
//            dp[1][k] = benefit[k];
//            if(dp[0][k]>N+1){
//                dp[1][k] = 0;
//                continue;
//            }
//            for( int m = k;m > 0;m--){
//                if(dp[0][m] <= k){
//                    if(dp[1][m]>max){
//                        dp[1][k] = dp[1][m] + benefit[k];
//                        max = dp[1][m];
////                        System.out.println(max);
//                    }
//                }
//            }
//
//            if(dp[1][k] > result){
//                result = dp[1][k];
//            }
        }
        System.out.println(dp[1][N+1]);
//        System.out.println(result);
    }
}
