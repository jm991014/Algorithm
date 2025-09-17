import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] board = br.lines()
                .limit(8)
                .map(String::toCharArray)
                .toArray(char[][]::new);
        int cnt = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0 && board[i][j] == 'F') {
                        cnt++;
                    }
                } else {
                    if (j % 2 == 1 && board[i][j] == 'F') {
                        cnt++;
                    }
                }
            }
        }
        bw.write(cnt + "");
        bw.close();
    }
}