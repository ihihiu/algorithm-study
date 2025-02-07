import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int T = kb.nextInt();
        int n = kb.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = kb.nextInt();
        }

        HashMap<Long, Long> shA = new HashMap<>();
        HashMap<Long, Long> shB = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                shA.put(sum, shA.getOrDefault(sum, 0L) + 1);
            }
        }


        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                shB.put(sum, shB.getOrDefault(sum, 0L) + 1);
            }
        }

        long answer = 0;
        for (long key : shA.keySet()) {
            if (shB.containsKey(T - key)) {
                answer += shA.get(key) * shB.get(T - key);
            }
        }

        System.out.println(answer);
    }
}
