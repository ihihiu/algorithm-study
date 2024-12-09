import java.util.*;

class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] time = new int[n];
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = kb.nextInt();
            price[i] = kb.nextInt();
        }
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i + time[i] <= n) {
                dp[i + time[i]] = Math.max(dp[i] + price[i], dp[i + time[i]]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[n]);
    }
}