import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int answer = 0;
        int n = kb.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = kb.nextInt();
        }
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int target = nums[i];
            int lt = 0, rt = n - 1;
            while (lt < rt) {
                if (lt == i) {
                    lt++;
                    continue;
                }
                if (rt == i) {
                    rt--;
                    continue;
                }
                int sum = nums[lt] + nums[rt];
                if (sum == target) {
                    answer++;
                    break;
                } else if (sum < target) {
                    lt++;
                } else {
                    rt--;
                }
            }
        }

        System.out.println(answer);

    }
}