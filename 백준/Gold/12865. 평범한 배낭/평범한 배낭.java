import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] dp = new int[k + 1];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int w = kb.nextInt();
            int v = kb.nextInt();
            for (int j = k; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        System.out.println(dp[k]);
    }
}