import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) arr[j] = sc.nextInt();
            int m = sc.nextInt();
            int[] dp = new int[m + 1];
            dp[0] = 1;
            for (int x : arr) {
                for (int j = x; j <= m; j++) {
                    dp[j] = dp[j] + dp[j - x];
                }
            }
            System.out.println(dp[m]);
        }
    }
}