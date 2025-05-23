import java.io.*;

public class Solution {
    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            String[] size = br.readLine().split(" ");
            N = Integer.parseInt(size[0]);
            M = Integer.parseInt(size[1]);

            arr = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 1; j <= N; j++) {
                    int num = Integer.parseInt(input[j - 1]);
                    arr[i][j] = num + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
                }
            }
            bw.write("#" + t + " " + getMaxSize() + "\n");
        }
        bw.close();
    }

    public static int getMaxSize() {
        int localMax = 0;
        for (int i = M; i <= N; i++) {
            for (int j = M; j <= N; j++) {
                int sum = arr[i][j] - arr[i - M][j] - arr[i][j - M] + arr[i - M][j - M];
                localMax = Math.max(localMax, sum);
            }
        }
        return localMax;
    }
}
