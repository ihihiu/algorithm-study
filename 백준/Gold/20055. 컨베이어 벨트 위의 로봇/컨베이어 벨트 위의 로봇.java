import java.sql.ClientInfoStatus;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        LinkedList<Integer> conveyorBelt = new LinkedList<>();
        for (int i = 0; i < 2 * n; i++) conveyorBelt.add(scanner.nextInt());

        LinkedList<Integer> robots = new LinkedList<>();
        for (int i = 0; i < n; i++) robots.add(0);

        int answer = 0;
        while (true) {
            answer++;

            //벨트, 로봇 회전 + 내리기
            conveyorBelt.addFirst(conveyorBelt.pollLast());
            robots.addFirst(robots.pollLast());
            robots.set(n - 1, 0);

            //로봇 이동 시키기, 내리기 작업
            for (int i = n - 2; i >= 0; i--) {
                if (robots.get(i) == 1 && robots.get(i + 1) == 0 && conveyorBelt.get(i + 1) >= 1) {
                    robots.set(i, 0);
                    robots.set(i + 1, 1);
                    conveyorBelt.set(i + 1, conveyorBelt.get(i + 1) - 1);
                }
            }
            robots.set(n - 1, 0);

            //0자리 처리
            if (conveyorBelt.get(0) >= 1) {
                conveyorBelt.set(0, conveyorBelt.get(0) - 1);
                robots.set(0, 1);
            }

            //0개수 찾고 break
            int cnt = 0;
            for (int x : conveyorBelt) {
                if (x == 0) cnt++;
                if (cnt >= k) break;
            }
            if (cnt >= k) break;
        }
        System.out.println(answer);
    }
}