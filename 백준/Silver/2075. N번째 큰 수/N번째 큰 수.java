import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int ord = 0;
        int answer = 0;
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) pQ.offer(new int[]{board[n - 1][i], n - 1, i});
        while (!pQ.isEmpty()) {
            int[] now = pQ.poll();
            ord++;
            answer = now[0];
            if (ord == n) break;
            if (now[1] - 1 >= 0) {
                pQ.offer(new int[]{board[now[1] - 1][now[2]], now[1] - 1, now[2]});
            }
        }
        System.out.println(answer);
    }
}