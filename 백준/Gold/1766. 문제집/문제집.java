import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        int[] indegree = new int[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
            indegree[b]++;
        }
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pQ.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pQ.isEmpty()) {
            int now = pQ.poll();
            sb.append(now + " ");
            for (int x : graph.get(now)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    pQ.offer(x);
                }
            }
        }
        System.out.println(sb);
    }
}