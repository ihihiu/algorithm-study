import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //카드 i개 포함된 카드팩의 가격이 x원
            int p = scanner.nextInt();
            for (int j = i; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - i] + p);
            }
        }
        System.out.println(dp[n]);
    }
}