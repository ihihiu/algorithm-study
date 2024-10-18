import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int answer = 0;
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = kb.nextInt();
        }

        int lt = 0, sum = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += nums[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= nums[lt++];
                if (sum == m) answer++;
            }
        }
        
        System.out.println(answer);

    }
}