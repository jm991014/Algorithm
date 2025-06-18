import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    private static int bell;
    private static int mix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc =  Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            String[] input = br.readLine().split(" ");
            bell = input[0].indexOf('o');
            mix = Integer.parseInt(input[1]);

            if (mix < 1) bw.write("#" + i + " " + bell + "\n");
            else {
                mixCup();
                bw.write("#" + i + " " + bell + "\n");
            }
        }
        bw.close();
    }

    private static void mixCup() {
        while(mix > 0) {
            switch (bell) {
                case 0:
                    bell = 1;
                    break;
                case 1:
                    bell = 0;
                    break;
                case 2:
                    bell = 1;
                    break;
            }
            mix--;
        }
    }
}
