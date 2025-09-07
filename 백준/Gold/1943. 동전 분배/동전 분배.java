import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = 0; T < 3; T++) {
            int N = Integer.parseInt(br.readLine());
            List<int[]> arr = new ArrayList<>();
            int total = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int money = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                arr.add(new int[]{money, cnt});
                total += money * cnt;
            }

            if (total % 2 != 0) {
                System.out.println(0);
                continue;
            }

            boolean[] dp = new boolean[total / 2 + 1];
            dp[0] = true;

            for (int[] coin : arr) {
                int m = coin[0];
                int cnt = coin[1];

                int k = 1;
                while (cnt > 0) {
                    int use = Math.min(k, cnt);
                    int value = use * m;

                    for (int i = total / 2; i >= value; i--) {
                        if (dp[i - value]) dp[i] = true;
                    }

                    cnt -= use;
                    k *= 2;
                }
            }
            System.out.println(dp[total / 2] ? 1 : 0);

        }
    }
}