import java.util.*;

class Main {
    static int n, m;
    static int[] arr;
    static int[] tmp;
    static StringBuilder sb = new StringBuilder();

    public void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
        } else {
            int pre = -1;
            for (int i = 0; i < n; i++) {
                if (pre != arr[i]) {
                    tmp[depth] = arr[i];
                    pre = arr[i];
                    dfs(depth + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n];
        tmp = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr);
        T.dfs(0);
        System.out.println(sb.toString());
    }
}