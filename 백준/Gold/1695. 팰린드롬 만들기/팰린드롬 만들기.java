import java.util.*;

public class Main {
    public int solution(int n, int[] nums) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (nums[j] == nums[j + i]) dp[j][j + i] = dp[j + 1][j + i - 1];
                else {
                    dp[j][j + i] = Math.min(dp[j + 1][j + i], dp[j][j + i - 1]) + 1;
                }

            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) nums[i] = kb.nextInt();
        System.out.println(T.solution(n, nums));
    }
}
