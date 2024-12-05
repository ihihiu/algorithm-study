import java.util.*;

class Main {
    static int[] numbers;
    static int[] res;
    public static void dfs(int depth, int start) {
        if (depth == 6) {
            for (int x : res) System.out.print(x + " ");
            System.out.println();
            return;
        }
        else {
            for (int i = start; i < numbers.length; i++) {

                res[depth] = numbers[i];
                dfs(depth + 1, i + 1);

            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        while (true) {
            int n = kb.nextInt();
            if (n == 0) break;
            numbers = new int[n];
            res = new int[6];
            for (int i = 0; i < n; i++) numbers[i] = kb.nextInt();
            dfs(0, 0);
            System.out.println();
        }
    }
}