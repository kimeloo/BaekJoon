import java.io.*;
import java.util.*;

public class Main {
    enum COMMAND {
        push_front, push_back, pop_front, pop_back, size, empty, front, back;

        static COMMAND of(String cmd) {
            return valueOf(cmd);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            COMMAND cmd = COMMAND.of(st.nextToken());

            switch (cmd) {
                case push_front:
                    deque.offerFirst(nextInt(st));
                    break;
                case push_back:
                    deque.offerLast(nextInt(st));
                    break;
                case pop_front:
                    out.append(deque.isEmpty() ? -1 : deque.pollFirst());
                    out.append("\n");
                    break;
                case pop_back:
                    out.append(deque.isEmpty() ? -1 : deque.pollLast());
                    out.append("\n");
                    break;
                case size:
                    out.append(deque.size());
                    out.append("\n");
                    break;
                case empty:
                    out.append(deque.isEmpty() ? 1 : 0);
                    out.append("\n");
                    break;
                case front:
                    out.append(deque.isEmpty() ? -1 : deque.peekFirst());
                    out.append("\n");
                    break;
                case back:
                    out.append(deque.isEmpty() ? -1 : deque.peekLast());
                    out.append("\n");
                    break;
            }
        }
        System.out.print(out);

        br.close();
    }

    public static int nextInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}