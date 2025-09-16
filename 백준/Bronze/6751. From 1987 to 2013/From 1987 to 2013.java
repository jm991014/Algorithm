import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int year = Integer.parseInt(st.nextToken()) + 1;

        while (true) {
            String yearStr = String.valueOf(year);
            long digitCount = yearStr.chars().distinct().count();

            if (digitCount == yearStr.length()) {
                bw.write(yearStr);
                break;
            }
            year++;
        }
        bw.close();
    }
}
