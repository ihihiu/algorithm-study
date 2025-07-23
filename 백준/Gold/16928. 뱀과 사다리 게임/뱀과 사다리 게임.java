import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[101];
        boolean[] visited = new boolean[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();

                if (now == 100) {
                    System.out.println(answer);
                    break;
                }

                for (int j = 1; j <= 6; j++) {
                    int next = now + j;
                    if (next > 100 || visited[next]) continue;
                    if (board[next] != 0) {
                        next = board[next];
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            answer++;
        }
    }

}