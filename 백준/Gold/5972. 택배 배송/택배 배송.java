import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;

        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pQ.offer(new int[]{1, 0});

        while (!pQ.isEmpty()) {
            int[] now = pQ.poll();
            for (int[] next : graph.get(now[0])){
                if (cost[next[0]] <= now[1]) continue;
                if (now[1] + next[1] < cost[next[0]]) {
                    cost[next[0]] = now[1] + next[1];
                    pQ.add(new int[]{next[0], now[1] + next[1]});
                }
            }
        }

        System.out.println(cost[N]);
    }
}