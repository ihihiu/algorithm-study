import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] dp = new int[n + 1];
        int[] ch = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                if (dp[i] > dp[i / 2] + 1) {
                    dp[i] = dp[i / 2] + 1;
                    ch[i] = 2;
                }
            }
            if (i % 3 == 0) {
                if (dp[i] > dp[i / 3] + 1) {
                    dp[i] = dp[i / 3] + 1;
                    ch[i] = 3;
                }
            }
        }
        System.out.println(dp[n]);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(n);
        while (n != 1) {
            if (ch[n] == 3) {
                n /= 3;
            } else if (ch[n] == 2) {
                n /= 2;
            } else {
                n -= 1;
            }
            res.add(n);
        }
        for (int x : res) System.out.print(x + " ");
    }
}
