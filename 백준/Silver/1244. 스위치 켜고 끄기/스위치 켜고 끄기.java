import java.io.*;
import java.util.*;

public class Main {
    static int[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = nextInt(st);
        switches = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            switches[i] = nextInt(st);
        }

        st = new StringTokenizer(br.readLine());
        int m = nextInt(st);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = nextInt(st);
            switch (gender) {
                case 1:
                    boy(nextInt(st));
                    break;
                case 2:
                    girl(nextInt(st)-1);
                    break;
            }
        }

        print();

    }

    public static void print() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < switches.length; i++) {
            if (i != 0 && i % 20 == 0) {
                out.append("\n");
            }
            out.append(switches[i]).append(" ");
        }
        System.out.println(out);
    }

    public static void toggle(int idx) {
        switches[idx] = switches[idx] == 0 ? 1 : 0;
    }

    public static void boy(int idx) {
        for (int i = idx; i <= switches.length; i += idx) {
            toggle(i - 1);
        }
    }

    public static void girl(int idx) {
        toggle(idx);
        for (int j = 1; j < switches.length; j++) {
            try {

                if (switches[idx - j] != switches[idx + j])
                    break;
                toggle(idx - j);
                toggle(idx + j);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
    }

    public static int nextInt(StringTokenizer st) throws IOException {
        return (Integer.parseInt(st.nextToken()));
    }
}