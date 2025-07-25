import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dp[kb.nextInt()]);
        }
    }
}
