import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;
            char[][] board = new char[3][3];

            int cntX = 0, cntO = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = input.charAt(i * 3 + j);
                    if (board[i][j] == 'X') cntX++;
                    if (board[i][j] == 'O') cntO++;
                }
            }

            if (Math.abs(cntX - cntO) > 1 || cntO > cntX) {
                System.out.println("invalid");
                continue;
            }

            int bingoX = 0, bingoO = 0;
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                    if (board[i][0] == 'X') bingoX++;
                    if (board[i][0] == 'O') bingoO++;
                }
                if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                    if (board[0][i] == 'X') bingoX++;
                    if (board[0][i] == 'O') bingoO++;
                }
            }

            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                if (board[0][0] == 'X') bingoX++;
                if (board[0][0] == 'O') bingoO++;
            }

            if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                if (board[0][2] == 'X') bingoX++;
                if (board[0][2] == 'O') bingoO++;
            }

            String answer = "valid";
            if (bingoX == 0 && bingoO == 0 && cntX + cntO != 9) {
                answer = "invalid";
            }
            if (bingoX > 0 && bingoO > 0) {
                answer = "invalid";
            }
            if (bingoX > 0 && cntX != cntO + 1) {
                answer = "invalid";
            }
            if (bingoO > 0 && cntX != cntO) {
                answer = "invalid";
            }

            System.out.println(answer);
        }
    }
}

