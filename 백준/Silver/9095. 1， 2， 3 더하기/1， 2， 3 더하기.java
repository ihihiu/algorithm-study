import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            if (N <= 3) {
                if (N == 1) System.out.println(1);
                else if (N == 2) System.out.println(2);
                else System.out.println(4);
                continue;
            }
            int[] dp = new int[N + 1];
            dp[1] = 1;
            dp[2] = 2; // 1 + 1, 2
            dp[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3

            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            System.out.println(dp[N]);
        }
    }
}