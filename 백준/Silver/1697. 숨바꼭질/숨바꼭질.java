import com.sun.source.tree.BinaryTree;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] ch = new int[100001];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if (now == k) {
                    System.out.println(L);
                    break;
                }
                for (int nx : new int[]{now - 1, now + 1, now * 2}) {
                    if (nx < 0 || nx > 100000) continue;
                    if (ch[nx] == 0) {
                        queue.offer(nx);
                        ch[nx] = 1;
                    }
                }
            }
            L++;
        }
    }
}