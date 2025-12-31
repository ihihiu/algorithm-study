import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        HashMap<Character, Integer> sh = new HashMap<>();
        int max = 0;

        for (char c : input.toCharArray()) {
            char x = Character.toUpperCase(c);
            sh.put(x, sh.getOrDefault(x, 0) + 1);
            max = Math.max(max, sh.get(x));
        }

        boolean found = false;
        char answer = '?';
        for (char x : sh.keySet()) {
            if (sh.get(x) == max) {
                if (found) {
                    answer = '?';
                    break;
                } else {
                    found = true;
                    answer = x;
                }
            }
        }

        System.out.println(answer);



    }
}