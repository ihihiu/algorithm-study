import java.io.*;
import java.util.*;

class Info implements Comparable<Info> {
    int level;
    String nickName;

    public Info(int level, String nickName) {
        this.level = level;
        this.nickName = nickName;
    }

    public int compareTo(Info ob) {
        return this.nickName.compareTo(ob.nickName);
    }
}

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Info>> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            boolean flag = false;
            for (List<Info> room : rooms) {
                if (l - 10 <= room.get(0).level && room.get(0).level <= l + 10 && room.size() < m) {
                    room.add(new Info(l, n));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                List<Info> x = new ArrayList<>();
                x.add(new Info(l, n));
                rooms.add(x);
            }
        }

        for (List<Info> x : rooms) {
            if (x.size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            Collections.sort(x);
            for (Info y : x) {
                System.out.println(y.level + " " + y.nickName);

            }
        }

    }
}