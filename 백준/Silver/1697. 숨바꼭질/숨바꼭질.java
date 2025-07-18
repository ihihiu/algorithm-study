import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        boolean[] visited = new boolean[100001];
        visited[N] = true;

        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                if (x == K) {
                    System.out.println(L);
                    return;
                }
                if (x - 1 >= 0 && !visited[x - 1]) {
                    queue.offer(x - 1);
                    visited[x - 1] = true;
                }
                if (x + 1 <= 100000 && !visited[x + 1]) {
                    queue.offer(x + 1);
                    visited[x + 1] = true;
                }
                if (x * 2 <= 100000 && !visited[x * 2]) {
                    queue.offer(x * 2);
                    visited[x * 2] = true;
                }
            }
            L++;
        }

        System.out.println(L);
    }
}