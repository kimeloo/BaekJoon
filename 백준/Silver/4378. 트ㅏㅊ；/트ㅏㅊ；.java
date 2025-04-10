import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String shift = "1234567890-=WERTYUIOP[]\\SDFGHJKL;'XCVBNM,./ ";
        String original = "`1234567890-QWERTYUIOP[]ASDFGHJKL;ZXCVBNM,. ";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String inp = br.readLine();
            if (inp==null){
                break;
            }
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < inp.length(); i++) {
                out.append(original.charAt(shift.indexOf(inp.charAt(i))));
            }
            System.out.println(out);
        }
    }
}
