import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = kb.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = scores[0];
        if (n > 1) dp[2] = scores[0] + scores[1];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + scores[i - 1], dp[i - 3] + scores[i - 2] + scores[i - 1]);
        }
        System.out.println(dp[n]);
    }
}
