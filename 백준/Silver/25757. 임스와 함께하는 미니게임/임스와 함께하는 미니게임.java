import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        char type = input[1].charAt(0);

        HashSet<String> participants = new HashSet<>();

        for (int i = 0; i < N; i++) {
            participants.add(br.readLine());
        }

        if (type == 'Y') {
            System.out.println(participants.size());
        } else if (type == 'F') {
            System.out.println(participants.size() / 2);
        } else if (type == 'O') {
            System.out.println(participants.size() / 3);
        }


    }
}