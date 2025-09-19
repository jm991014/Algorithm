import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(".  .   .\n" + "|  | _ | _. _ ._ _  _\n" + "|/\\|(/.|(_.(_)[ | )(/.");
        bw.close();
    }
}
