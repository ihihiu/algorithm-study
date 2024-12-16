import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{a, 0});
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[a] = 0;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                if (now[1] > dist[now[0]]) continue;
                for (int[] x : graph.get(now[0])) {
                    if (dist[x[0]] > now[1] + x[1]) {
                        dist[x[0]] = now[1] + x[1];
                        queue.offer(new int[]{x[0], dist[x[0]]});
                    }
                }
            }
            System.out.println(dist[b]);
        }
    }
}