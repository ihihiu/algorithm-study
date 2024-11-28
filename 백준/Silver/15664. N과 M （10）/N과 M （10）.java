import java.util.*;

class Main {
    static int n, m;
    static int[] arr;
    static int[] tmp;
    static LinkedHashSet<String> res = new LinkedHashSet<>();

    public static void dfs(int depth, int start) {
        if (depth == m) {
            res.add(Arrays.toString(tmp).replace("[", "").replace("]", "").replace(",", ""));
        }
        else {
            for (int i = start; i < n; i++) {
                tmp[depth] = arr[i];
                dfs(depth + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        Arrays.sort(arr);
        tmp = new int[m];
        dfs(0, 0);
        for (String x : res) {
            System.out.println(x);
        }
    }
}