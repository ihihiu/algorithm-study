import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> belt = new LinkedList<>();
        for (int i = 0; i < 2 * N; i++) {
            belt.add(Integer.parseInt(st.nextToken()));
        }
        LinkedList<Integer> robot = new LinkedList<>();
        for (int i = 0; i < N; i++) robot.add(0);

        int answer = 0;
        while (true) {
            answer++;
            belt.addFirst(belt.pollLast());
            robot.addFirst(robot.pollLast());
            robot.set(N - 1, 0);

            for (int i = N - 2; i >= 0; i--) {
                if (robot.get(i) == 1 && robot.get(i + 1) == 0 && belt.get(i + 1) >= 1) {
                    robot.set(i, 0);
                    robot.set(i + 1, 1);
                    belt.set(i + 1, belt.get(i + 1) - 1);
                }
            }
            robot.set(N - 1, 0);

            if (belt.get(0) >= 1) {
                belt.set(0, belt.get(0) - 1);
                robot.set(0, 1);
            }

            int cnt = 0;
            for (int x : belt) {
                if (x == 0) cnt++;
            }
            if (cnt >= K) break;
        }

        System.out.println(answer);
    }


}