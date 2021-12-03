import java.io.*;
import java.util.*;
public class Main {
    private static int k;
    private static boolean[] isVisited = new boolean[10];
    private static char[] signs;
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        signs = new char[k];
        for (int i = 0; i < k; i++) {
            signs[i] = sc.next().charAt(0);
        }
        dfs("", 0);
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }

    public static boolean compare(int a, int b, char c) {
        if (c == '<') return a < b;
        else return a > b;
    }
    public static void dfs(String num, int depth) {
        if (depth == k + 1) {
            result.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (depth == 0 || !isVisited[i] && compare(num.charAt(num.length() - 1) - '0', i, signs[depth - 1])) {
                isVisited[i] = true;
                dfs(num + i, depth + 1);
                isVisited[i] = false;
            }
        }
    }

}
