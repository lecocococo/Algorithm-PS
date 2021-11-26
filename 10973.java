//import java.io.*;
//import java.util.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (nextPermutation()) {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
        } else {
            System.out.println("-1");
        }
    }

    private static boolean nextPermutation() {
        int i = nums.length - 1;
        while (i > 0 && nums[i-1] <= nums[i]) { i--; }
        if (i <= 0) return false;

        int j = nums.length - 1;
        while (nums[j] >= nums[i - 1]) { j--; }

        swap(i - 1, j);
        j = nums.length - 1;
        while (i < j) {
            swap(i, j);
            i++; j--;
        }
        return true;
    }

    private static void swap(int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
