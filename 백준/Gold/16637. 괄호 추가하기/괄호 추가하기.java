import java.io.*;
import java.util.*;

class Main {
    static int answer;
    static int[] nums;
    static char[] ops;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        nums = new int[N / 2 + 1];
        ops = new char[N / 2];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) nums[i / 2] = input.charAt(i) - '0';
            else ops[i / 2] = input.charAt(i);
        }

        answer = Integer.MIN_VALUE;
        
        dfs(0, nums[0]);
        System.out.println(answer);

    }

    static void dfs(int idx, int tmp) {
        if (idx >= ops.length) {
            answer = Math.max(answer, tmp);
            return;
        }

        // 괄호 없는 경우
        dfs(idx + 1, cal(tmp, nums[idx + 1], ops[idx]));

        // 괄호 있는 경우
        if (idx + 1 < ops.length) {
            int res = cal(nums[idx + 1], nums[idx + 2], ops[idx + 1]);
            dfs(idx + 2, cal(tmp, res, ops[idx]));
        }
    }

    static int cal(int a, int b, char op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else return a * b;
    }
}