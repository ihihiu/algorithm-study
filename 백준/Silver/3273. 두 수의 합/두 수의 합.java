import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        HashSet<Integer> sh = new HashSet();
        for (int i = 0; i < n; i++) sh.add(kb.nextInt());
        int m = kb.nextInt();
        int answer = 0;
        for (int x : sh) {
            if (sh.contains(m - x)) answer++;
        }
        System.out.println(answer / 2);
    }
}