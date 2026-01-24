import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {

    static char[] inputStr;
    static char[] pattern;

    public static void main(String[] args) throws IOException {
        input();
        String answer = solve();
        output(answer);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputStr = br.readLine().trim().toCharArray();

        char[] temp = br.readLine().trim().toCharArray();
        pattern = new char[temp.length];
        for (int i = 0; i < temp.length; i++) {
            pattern[i] = temp[temp.length - i - 1];
        }
    }

    static String solve() {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : inputStr) {
            deque.addLast(c);
            while (checkPattern(deque)) {
                // Do Nothing
            }
        }
        StringBuilder string = new StringBuilder();
        while (!deque.isEmpty()) {
            string.append(deque.removeFirst());
        }

        return string.toString();
    }

    static boolean checkPattern(Deque<Character> deque) {
        Deque<Character> temp = new ArrayDeque<>();
        for (int i = 0; i < pattern.length; i++) {
            if (deque.isEmpty() || deque.peekLast() != pattern[i]) {
                rollback(deque, temp);
                return false;
            }
            temp.addLast(deque.removeLast());
        }
        return true;
    }

    static void rollback(Deque<Character> deque, Deque<Character> temp) {
        while (!temp.isEmpty()) {
            deque.addLast(temp.removeLast());
        }
    }

    static void output(String string) {
        System.out.println(string.isEmpty() ? "FRULA" : string);

    }
}
