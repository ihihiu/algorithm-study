import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] heights = new int[N + 1];
        int[] cnt = new int[N + 1];
        int[] near = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽 탐색
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            cnt[i] = stack.size();
            if (!stack.isEmpty()) near[i] = stack.peek();
            stack.push(i);
        }

        //오른쪽
        stack.clear();
        for (int i = N; i >= 1; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            cnt[i] += stack.size();
            if (!stack.isEmpty()) {
                if (near[i] == 0) {
                    near[i] = stack.peek();
                } else {
                    if (stack.peek() - i < i - near[i]) {
                        near[i] = stack.peek();
                    }
                }
            }
            stack.push(i);
        }

        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0) System.out.println(0);
            else {
                System.out.println(cnt[i] + " " + near[i]);
            }
        }
    }
}

