import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                cnt++;
            }

            if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }

            if (y != 0) {
                stack.push(y);
            }            
        }
        cnt += stack.size();
        
        System.out.println(cnt);    
    }
}

