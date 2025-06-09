import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});

        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]] = true;
            if (now[0] == K) answer = Math.min(answer, now[1]);
            if (now[0] * 2 <= 100000 && visited[now[0] * 2] == false) queue.offer(new int[]{now[0] * 2, now[1]});
            if (now[0] + 1 <= 100000 && visited[now[0] + 1] == false) queue.offer(new int[]{now[0] + 1, now[1] + 1});
            if (now[0] - 1 >= 0 && visited[now[0] - 1] == false) queue.offer(new int[]{now[0] - 1, now[1] + 1});

        }
        System.out.println(answer);
    }
}