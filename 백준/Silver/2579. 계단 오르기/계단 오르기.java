import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = kb.nextInt();   
        }
        int[] dp = new int[n + 1];
        dp[1] = score[1];
        if (n > 1) dp[2] = score[1] + score[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }
        System.out.print(dp[n]);
    }
}