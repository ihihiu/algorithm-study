import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x == 0) {
                if (pQ.isEmpty()) System.out.println(0);
                else System.out.println(pQ.poll());
            } else {
                pQ.offer(x);
            }
        }
    }
}