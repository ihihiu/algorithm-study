import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int[] ch = new int[n + 1];
        ch[1] = 1;
        int L = 0;
        while (!queue.isEmpty()) {
            L++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                for (int x : graph.get(now)) {
                    if (ch[x] == 0) {
                        answer++;
                        ch[x] = 1;
                        queue.offer(x);
                    }
                }
            }
            if (L == 2) break;
        }
        System.out.println(answer);
    }
}