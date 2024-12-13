import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        HashMap<String, String> sh = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sh.put(kb.next(), kb.next());
        }
        for (int i = 0; i < m; i++) {
            System.out.println(sh.get(kb.next()));
        }
    }
}