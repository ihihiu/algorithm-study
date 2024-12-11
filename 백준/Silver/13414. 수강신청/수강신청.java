import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        int l = kb.nextInt();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String x = kb.next();
            if (set.contains(x)) set.remove(x);
            set.add(x);
        }
        int cnt = 0;
        for (String x : set) {
            System.out.println(x);
            cnt++;
            if (cnt == k) break;
        }
    }
}