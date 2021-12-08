import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int m;
    static int[][] paper;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        paper = new int[n][m];


        for(int i=0; i < n; i++){
            String str = br.readLine();
            for(int j=0; j < m; j++){
                paper[i][j] = str.charAt(j) - '0';
            }
        }

        // 가로로 이어지면 0, 세로로 이어지면 1이라고 가정하자.
        // n*m이 주어지므로 n*m-1번 << 연산을 하면 모든 비트가 1이 되는 경우를 찾을 수 있다.
        // i = 0이면 모두 가로로만 찢는 경우이며, 모두 1이면 세로로만 찢는 경우이다.
        // i가 1씩증가하면서 비트값도 게속 바뀐다 마지막까지 돌면 완전탐색이다.
        for(int i=0; i < (1 << n*m); i++){
            int sum = 0;

            // 현재 가로로 찢는 경우의 합을 구한다.
            for(int j=0; j < n; j++){
                int cur = 0;
                for(int k=0; k < m; k++){

                    // 현재 체크하고자 하는 위치를 l에 저장
                    int l = j*m+k;

                    // 비트를 통해 현재 위치가 0이면 가로로 찢는 부분임을 확인
                    // 가로로 찢는 것이 이어지는 동안 한 자리수씩 더 커지므로 10을 곱하고
                    // 현재 값을 더한다.
                    if((i & (1 << l)) == 0){
                        cur = cur * 10 + paper[j][k];
                        // 그 외의 경우에는 세로로 이어지는 것이므로 그냥 더하고 현재 값은 0으로 초기화
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }

                // 세로로 찢는 경우를 만나지 못한 경우 마지막에 더해주어야 한다.
                sum += cur;
            }

            // 동일하게 이번에는 세로로 찢는 경우를 모두 찾아서 더한다.
            for(int j=0; j < m; j++){
                int cur = 0;
                for(int k=0; k < n; k++){
                    // 비트 위치 확인
                    int l = k*m+j;

                    // 현재 위치가 0이 아니라면 세로로 찢긴 부분임.
                    if((i & (1 << l)) != 0){
                        cur = cur * 10 + paper[k][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }

                // 가로로 찢는 경우를 만나지 못한 경우 마지막에 더해주어야 한다.
                sum += cur;
            }
            ans = Math.max(ans, sum);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
    }
}
