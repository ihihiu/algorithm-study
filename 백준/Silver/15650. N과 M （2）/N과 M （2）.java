import java.util.*;
class Main {
    static int n, m;
    static void dfs(int depth, int start, int[] tmp) {
        if (depth == m) {
            for (int x : tmp) System.out.print(x + " ");
            System.out.println();
        }
        else {
            for (int i = start; i < n; i++) {
                tmp[depth] = i + 1;
                dfs(depth + 1, i + 1, tmp);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        int[] tmp = new int[m];
        dfs(0, 0, tmp);

    }
}