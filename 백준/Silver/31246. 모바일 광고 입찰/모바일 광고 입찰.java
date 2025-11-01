import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int Ai = Integer.parseInt(st.nextToken());
            int Bi = Integer.parseInt(st.nextToken());

            if (Ai >= Bi) {
                K--;
            } else {
                arr.add(Bi - Ai);
            }
        }

        if (K <= 0) {
            System.out.println(0);
        } else {
            Collections.sort(arr);
            System.out.println(arr.get(K - 1));
        }


    }
}