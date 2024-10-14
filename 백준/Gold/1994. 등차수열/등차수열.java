import java.util.*;

class Main {
    public int solution(int n, int[] nums) {
        int answer = 0;
        if (n == 1) return 1;
        int[][] dp = new int[n + 1][n + 1];
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = 2;
                int pre = nums[i] - (nums[j] - nums[i]);
                int k = 0;
                for (k = i - 1; k >= 1; k--) {
                    if (nums[k] == pre) break;
                }
                dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    } 
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) nums[i] = kb.nextInt();
        System.out.print(T.solution(n, nums));
    }

}