import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int maxHeight = Math.max(a, b);
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < a; i++) {
            deque.add(i);
        }
        deque.add(maxHeight);
        for (int i = b - 1; i > 0; i--) {
            deque.add(i);
        }
        if (deque.size() > N) {
            System.out.println(-1);
            return;
        }

        int first = deque.pollFirst();
        int size = deque.size();
        for (int i = 1; i <= N - size - 1; i++) {
            deque.addFirst(1);
        }
        deque.addFirst(first);
        for (int i = 1; i <= N; i++) {
            System.out.print(deque.pollFirst() + " ");
        }
    }
}