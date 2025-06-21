import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            HashMap<Integer, Integer> cnt = new HashMap<>();


            for (int j = 0; j < N; j++) {
                int team = Integer.parseInt(st.nextToken());
                arr[j] = team;
                cnt.put(team, cnt.getOrDefault(team, 0) + 1);
            }

            HashMap<Integer, Integer> score = new HashMap<>();
            HashMap<Integer, Integer> size = new HashMap<>();

            int rank = 1;
            List<int[]> list = new ArrayList<>();
            for (int team : arr) {
                if (cnt.get(team) != 6) continue;
                size.put(team, size.getOrDefault(team, 0) + 1);
                if (size.get(team) <= 4) score.put(team, score.getOrDefault(team, 0) + rank);
                if (size.get(team) == 5) {
                    list.add(new int[]{team, score.get(team), rank});
                }
                rank++;
            }

            Collections.sort(list, (a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

            System.out.println(list.get(0)[0]);


        }
    }

}