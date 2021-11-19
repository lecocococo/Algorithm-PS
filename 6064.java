import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i<T; i++){
            int tc[]= new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j<4;j++) {
                tc[j] = Integer.parseInt(st.nextToken());
            }
            // -1 해준 이유는 나머지연산시 0이 나오지 않게 하기위해
            tc[2] = tc[2] - 1;
            tc[3] = tc[3] - 1;
            boolean flag = false;
            for (int k = tc[2]; k < (tc[0] * tc[1]); k += tc[0]) {
                if (k % tc[1] == tc[3]) {
                    System.out.println(k + 1);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println(-1);

            }


        }


    }

}
