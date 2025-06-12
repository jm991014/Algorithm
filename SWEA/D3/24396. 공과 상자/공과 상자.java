
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int B = arr[0], W = arr[1], X = arr[2], Y = arr[3], Z = arr[4];
            int max = Integer.MIN_VALUE;

            if (B > W) {
                max = Math.max(max, Z * W * 2 + X * (B - W));
            } else {
                max = Math.max(max, Z * B * 2 + Y * (W - B));
            }

            max = Math.max(max, B * X + W * Y);
            bw.write(max + "\n");
        }
        bw.close();
    }
}
