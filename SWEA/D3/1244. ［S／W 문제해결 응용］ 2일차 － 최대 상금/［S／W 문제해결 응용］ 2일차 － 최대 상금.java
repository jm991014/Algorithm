import java.io.*;

public class Solution {
    static int n;
    static char[] arr;
    static String ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[1]);
            arr = input[0].toCharArray();
            ans = "";
            dfs(0, 0);
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.close();
    }
    private static void dfs(int depth, int count) {
        if (count == n) {
            String cur = new String(arr);
            if (cur.compareTo(ans) > 0) {
                ans = cur;
            }
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(i, j);
                dfs(i, count + 1);
                swap(i, j);
            }
        }
    }

    private static void swap(int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
