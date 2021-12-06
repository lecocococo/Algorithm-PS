import java.io.*;
import java.util.*;
// 매우느린방법 좀더 빠르게 구현하기위해선 종만북 1권 504 페이지 보기
//public class Main {
//    public static final int num = 10000000;
//    public static int C;
//    public static int[] prime;
//    public static int low;
//    public static int high;
//    public static int res;
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int tc = Integer.parseInt(br.readLine());
//        for(int i =0;i<tc;i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            C = Integer.parseInt(st.nextToken());
//            low = Integer.parseInt(st.nextToken());
//            high = Integer.parseInt(st.nextToken());
//
//            res = 0;
//            erathos();
//            for(int j = low; j<=high;j++){
//                countDivisor(factor(j));
//            }
//            System.out.println(res);
//        }
//
//
//    }
//    public static void erathos(){
//        prime = new int[num + 1];
//        prime[0] = -1; prime[1] = -1;
//        for (int i=2;i<=num;i++){
//            prime[i]= i;
//        }
//
//        for (int i =2;i<=Math.sqrt(num);i++){
//            // sqrt(num)을 돌면서 소수 아닌 것 다 찾아냄
//            if(prime[i] == i){
//                for(int j=i*i;j<=num;j+=i){
//                    // 이미 최소약수가 적혀있는 건 그냥 넘긴다.
//                    if(prime[j]==j){
//                        prime[j] = i;
//                    }
//                }
//            }
//        }
//    }
//
//    public static ArrayList<Integer> factor(int n){
//        ArrayList<Integer> result= new ArrayList<>();
//        while(n>1){
//            result.add(prime[n]);
//            n/=prime[n];
//        }
//        return result;
//    }
//
//    public static void countDivisor(ArrayList<Integer> result){
//        result.sort(Comparator.naturalOrder());
////        for(int i = 0;i< result.size();i++)
////            System.out.println(result.get(i));
//        int cnt = 1;
//        int ans = 1;
//        for(int i = 1;i< result.size();i++){
//            if(result.get(i-1)!= result.get(i)){
//                ans *= cnt + 1;
////                System.out.println(cnt);
//                cnt = 1;
//            }
//            else{
//                cnt++;
//            }
//            if(ans>C){
//                break;
//            }
//
//        }
//        ans *= cnt + 1;
////        System.out.println(ans);
//        if (ans == C){
//            res += 1;
//        }
//    }
//}
public class Main {
    public static final int num = 10000000;
    public static int C;
    public static int[] prime;
    public static int low;
    public static int high;
    public static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        prime = new int[num+1];
        int tc = Integer.parseInt(br.readLine());
        // 그냥 개수르 ㄹ구하는 방법은 개수가 무한해지더라도 logn에 수렴하게되서 5초안에 돌아갈수도있다
        for (int j = 1; j <= num; j++) {
            for (int k = j; k <= num; k += j) {
                prime[k] += 1;
            }
        }
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            low = Integer.parseInt(st.nextToken());
            high = Integer.parseInt(st.nextToken());

            res = 0;

            for (int j = low; j <= high; j++) {
                if (prime[j] == C) {
                    res += 1;
                }
            }
            System.out.println(res);
        }


    }
}
