import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] inputs = br.readLine().split(" ");
            double d = Double.parseDouble(inputs[0]);
            if (d == 0.0) break;
            
            double rh = Double.parseDouble(inputs[1]);
            double rv = Double.parseDouble(inputs[2]);

            double ratioConstant = Math.sqrt(16.0 * 16.0 + 9.0 * 9.0);

            double w = (16.0 * d) / ratioConstant;
            double h = (9.0 * d) / ratioConstant;

            double dpiH = rh / w;
            double dpiV = rv / h;

            sb.append(String.format("Horizontal DPI: %.2f\n", dpiH));
            sb.append(String.format("Vertical DPI: %.2f\n", dpiV));
        }
        
        System.out.print(sb);
    }
}
