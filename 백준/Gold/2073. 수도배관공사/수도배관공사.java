import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int d = kb.nextInt();
        int p = kb.nextInt();
        int[] dp = new int[d + 1];
        for (int i = 0; i < p; i++) {
            int l = kb.nextInt();
            int c = kb.nextInt();
            for (int j = d; j > l; j--) {
                if (dp[j - l] == 0) continue;
                dp[j] = Math.max(dp[j], Math.min(dp[j - l], c));
            }
            dp[l] = Math.max(dp[l], c);
        }
        System.out.print(dp[d]);
    }
}