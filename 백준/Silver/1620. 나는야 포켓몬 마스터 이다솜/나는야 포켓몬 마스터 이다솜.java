import java.util.*;

class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        HashMap<String, Integer> name = new HashMap<>();
        HashMap<Integer, String> number = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String s = kb.next();
            name.put(s, i);
            number.put(i, s);
        }
        for (int i = 0; i < m; i++) {
            String s = kb.next();
            if (Character.isDigit(s.charAt(0))) {
                int key = Integer.parseInt(s);
                System.out.println(number.get(key));
            }
            else System.out.println(name.get(s));
        }
    }
}