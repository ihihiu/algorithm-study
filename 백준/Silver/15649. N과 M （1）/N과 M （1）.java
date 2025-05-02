import java.util.*;
class Main {
    static int n, m;
    static boolean[] ch;
    static void dfs(int depth, int[] tmp) {
        if (depth == m) {
            for (int x : tmp) System.out.print(x + " ");
            System.out.println();
        }
        else {
            for (int i = 0; i < n; i++) {
                if(!ch[i]) {
                    ch[i] = true;
                    tmp[depth] = i + 1;
                    dfs(depth + 1, tmp);
                    ch[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ch = new boolean[n];
        int[] tmp = new int[m];
        dfs(0, tmp);

    }
}