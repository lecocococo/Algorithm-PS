import java.io.*;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime(num)) count++;
        }

        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i <= sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
