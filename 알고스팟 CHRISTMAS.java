import java.io.*;
import java.util.*;

public class Main {
    public static int C;
    public static int N;
    public static int K;
    public static int[] arr;
    public static int[] parr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        for(int z = 0; z<C;z++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());  //선물 개수
            K = Integer.parseInt(st.nextToken()); //어린이수
            arr = new int[N+1];
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int l = 1;l<N;l++){
                arr[l] = Integer.parseInt(st2.nextToken());
//                System.out.print(arr[l]);
            }
//            System.out.println();
            parr = new int[N + 1];
            parr[0] = 0;
            parr[1] = arr[0];
            for(int l = 1;l<N;l++){
                parr[l] = parr[l-1] + arr[l];
//                System.out.print(parr[l]);
            }
//            int first_ans=0;
//            int[] cnt = new int[K];
//            for(int i =0; i<parr.length; i++){
//                cnt[parr[i]%K]++;
//            }
//            for(int i = 0;i<K;i++){
//                if(cnt[i]>=2){
//                    first_ans  = (first_ans + ((cnt[i]*(cnt[i] - 1))/2)) % 20091101; // 조합공식
//                }
//            }
            int first_ans = first(0);
//            System.out.println(first_ans);
            int second_ans = second(0);
            System.out.printf("%d %d",first_ans,second_ans);
        }
    }
    public static int first(int ans){
        int[] cnt = new int[K];
        for(int i =0; i<parr.length; i++){
            cnt[parr[i]%K]++;
        }
        for(int i = 0;i<K;i++){
            if(cnt[i]>=2){
                ans  = (ans + ((cnt[i]*(cnt[i] - 1))/2)) % 20091101; // 조합공식
            }
        }
        return ans;
    }
    public static int second(int ans){
//        int[] dp = new int[N+1];
//        dp[0] = 0;
//        dp[1] = 0;
//        for(int i = 1;i<=N;i++){
//            for(int j = i-1;j>=0;j--){
//                if(parr[i]%K == parr[j]%K){
//                    dp[i] = Math.max(dp[i],dp[j] + 1);
//                }
//                else{
//                    dp[i] =  Math.max(dp[i],dp[i-1]);
//                }
//                break;
//            }
//        }
//        ans = dp[N];
//        return ans;

        // 더 좋은 방법(for문 한번) - 이번 위치를 기억해두면 됨
        int[] dp = new int[N+1];
        int[] prev =new int[K];
        for(int k=0;k<K;k++){
            prev[k] = -1;
        }
//        dp[0] = 0;
//        dp[1] = 0;
        for(int i =0;i < N+1; i++){
            if(i>0){
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = 0;
            }
            //이전위치 가져옴
            int location = prev[parr[i]%K];
            if(location != -1){
                dp[i] = Math.max(dp[i],dp[location] + 1);
            }
            //현재 위치 기억시킴
            prev[parr[i]%K] = i;
        }
        ans = dp[N];
        return ans;
    }
}
