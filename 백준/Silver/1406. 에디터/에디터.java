import java.io.*;
import java.util.*;

public class Main {

    static class Editor {

        Deque<Character> left;
        Deque<Character> right;

        public Editor() {
            this.left = new ArrayDeque<>();
            this.right = new ArrayDeque<>();
        }

        public Editor(String initStr) {
            this();
            for (char c : initStr.toCharArray()) {
                this.left.addLast(c);
            }
        }

        void commandL() {
            if (!this.left.isEmpty()) {
                this.right.addFirst(this.left.removeLast());
            }
        }

        void commandD() {
            if (!this.right.isEmpty()) {
                this.left.addLast(this.right.removeFirst());
            }
        }

        void commandB() {
            if (!this.left.isEmpty()) {
                this.left.removeLast();
            }
        }

        void commandP(char c) {
            this.left.addLast(c);
        }

        String print() {
            StringBuilder result = new StringBuilder();

            while (!this.left.isEmpty()) {
                result.append(this.left.removeFirst());
            }
            while (!this.right.isEmpty()) {
                result.append(this.right.removeFirst());
            }

            return result.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Editor editor = new Editor(br.readLine().trim());

        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            String input = br.readLine().trim();
            char cmd = input.charAt(0);
            switch (cmd) {
                case 'L':
                    editor.commandL();
                    break;
                case 'D':
                    editor.commandD();
                    break;
                case 'B':
                    editor.commandB();
                    break;
                case 'P':
                    char val = input.charAt(2);
                    editor.commandP(val);
                    break;
                default:
                    System.out.println("잘못된 명령어");
            }
        }

        System.out.println(editor.print());
    }
}
