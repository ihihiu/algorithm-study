import java.util.*;

class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int answer = -1;
        int n = kb.nextInt();
        int x = kb.nextInt();
        int y = kb.nextInt();
        int m = kb.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        int[] ch = new int[n + 1];
        ch[x] = 1;
        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            L++;
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                for (int q : graph.get(now)) {
                    if (ch[q] == 0) {
                        ch[q] = 1;
                        queue.offer(q);
                    }
                }
            }
            if (ch[y] == 1) {
                answer = L;
                break;
            }
        }
        System.out.println(answer);
    }
}