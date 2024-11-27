import java.util.*;

class Main {
    static int n, m;
    static int[] nums;
    static int[] ch, tmp;
    static LinkedHashSet<String> res;

    public void dfs(int depth){
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int x : tmp)
                sb.append(x).append(' ');
            res.add(sb.toString());
        }
        else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    tmp[depth] = nums[i];
                    dfs(depth + 1);
                    ch[i] = 0;
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
        for (int i = 0; i < n; i++) nums[i] = kb.nextInt();
        Arrays.sort(nums);
        ch = new int[n];
        tmp = new int[m];
        res = new LinkedHashSet<>();
        T.dfs(0);
        for (String x : res) {
            System.out.println(x);
        }
    }
}