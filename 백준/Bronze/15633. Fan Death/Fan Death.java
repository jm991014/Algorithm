import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long result = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                long j = n / i;
                if (i == j) result += i;
                else result += i + j;
            }
        }
        System.out.println((result * 5) - 24);
    }
}
