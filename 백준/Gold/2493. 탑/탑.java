import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek()[0] < height) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                arr[i] = 0;
            } else {
                arr[i] = stack.peek()[1];
            }

            stack.push(new int[]{height, i + 1});

        }
        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x + " ");
        System.out.println(sb);
    }
}