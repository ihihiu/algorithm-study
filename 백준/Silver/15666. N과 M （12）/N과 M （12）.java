import java.util.*;

class Main {
    static int n, m;
    static int[] nums;
    static int[] tmp;
    static StringBuilder sb = new StringBuilder();

    public void dfs(int depth, int start) {
        if (depth == m) {
            for (int x : tmp) sb.append(x).append(" ");
            sb.append("\n");
        }
        else {
            int pre = -1;
            for (int i = start; i < n; i++) {
                if (pre != nums[i]){
                    tmp[depth] = nums[i];
                    pre = nums[i];
                    dfs(depth + 1, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        nums = new int[n];
        tmp = new int[m];
        for (int i = 0; i < n; i++) nums[i] = kb.nextInt();
        Arrays.sort(nums);
        T.dfs(0, 0);
        System.out.println(sb);
    }
}