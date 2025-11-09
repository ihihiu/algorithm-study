import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}