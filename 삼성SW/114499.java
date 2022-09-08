import java.util.*;
import java.io.*;

public class Main {

    static int N = 0;
    static int M = 0;
    static int x = 0;
    static int y = 0;
    static int K = 0;

    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        ArrayList<Integer> answer = new ArrayList<>();

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        x = Integer.parseInt(str[2]);
        y = Integer.parseInt(str[3]);
        K = Integer.parseInt(str[4]);
        int[][] map = new int[N][M];

        String[] st;
        for (int i = 0; i < N; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st[j]);
            }
        }

        String[] command = br.readLine().split(" ");

        int nx = x;
        int ny = y;
        Dice dice = new Dice(0, 0, 0, 0, 0, 0);
        for (int i = 0; i < command.length; i++) {
            int loc = Integer.parseInt(command[i]);

            nx += dx[loc];
            ny += dy[loc];

            if (!rangeCheck(nx, ny)){
                nx -= dx[loc];
                ny -= dy[loc];
                continue;
            }

            int temp;
            switch (loc){
                case 1:
                    temp = dice.left;
                    dice.left = dice.bottom;
                    dice.bottom = dice.right;
                    dice.right = dice.top;
                    dice.top = temp;
                    break;
                case 2:
                    temp = dice.left;
                    dice.left = dice.top;
                    dice.top = dice.right;
                    dice.right = dice.bottom;
                    dice.bottom = temp;
                    break;
                case 3:
                    temp = dice.top;
                    dice.top = dice.up;
                    dice.up = dice.bottom;
                    dice.bottom = dice.down;
                    dice.down = temp;
                    break;
                case 4:
                    temp = dice.top;
                    dice.top = dice.down;
                    dice.down = dice.bottom;
                    dice.bottom = dice.up;
                    dice.up = temp;
                    break;
            }

            if (map[nx][ny]==0){
                map[nx][ny] = dice.bottom;
            }
            else{
                dice.bottom = map[nx][ny];
                map[nx][ny] = 0;
            }

            answer.add(dice.top);

        }

        for (Integer val : answer) {
            System.out.println(val);
        }


    }

    public static Boolean rangeCheck(int x, int y){
        return 0 <= x && x< N && 0<=y && y < M;
    }

    static class Dice {
        int top, up, down, left, right, bottom;

        public Dice(int top, int up, int down, int left, int right, int bottom) {
            this.top = top;
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            this.bottom = bottom;
        }
    }
}
