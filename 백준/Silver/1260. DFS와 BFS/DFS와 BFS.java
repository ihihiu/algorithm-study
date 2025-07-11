import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) Collections.sort(graph.get(i));

        dfs(graph, visited, V);
        System.out.println();

        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int x : graph.get(now)) {
                if (visited[x]) continue;
                visited[x] = true;
                queue.add(x);
            }
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int V) {
        visited[V] = true;
        System.out.print(V + " ");
        for (int x : graph.get(V)) {
            if (visited[x]) continue;
            dfs(graph, visited, x);
        }
    }
}