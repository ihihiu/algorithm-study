import java.util.*;

class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int w = kb.nextInt();
        int l = kb.nextInt();
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) queue.offer(kb.nextInt());
        //bridge -> (건너는 시간, 무게)
        Queue<int[]> bridge = new ArrayDeque<>();

        int currentWeight = 0;
        for (int i = 1; i <= n * w + 1; i++) {
            if (!bridge.isEmpty() && bridge.peek()[0] == i) {
                int[] x = bridge.poll();
                currentWeight -= x[1];
            }
            if (!queue.isEmpty() && bridge.size() < w && queue.peek() + currentWeight <= l) {
                int now = queue.poll();
                currentWeight += now;
                bridge.offer(new int[]{i + w, now});
            }

            if (bridge.isEmpty() && queue.isEmpty()) {
                System.out.println(i);
                break;
            }

        }


    }
}