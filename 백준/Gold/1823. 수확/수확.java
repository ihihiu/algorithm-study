import java.util.*;

public class Main {
    public int solution(int n, int[] v) {
        int answer = 0;
        int lt = 0, rt = n - 1;
        int[] sum = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1] + v[i];
            dp[i][i] = v[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                dp[j][j + i] = Math.max(dp[j][j + i - 1], dp[j + 1][j + i]) + sum[j + i] - sum[j - 1];
            }
        }

        return dp[1][n];
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) v[i] = kb.nextInt();
        System.out.println(T.solution(n, v));
    }
}
