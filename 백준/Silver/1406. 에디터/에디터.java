import java.util.*;
import java.io.*;

public class Main {

    static class Editor {

        static final char CURSOR = '|';

        Char cursor;

        public Editor() {
            // 미리 지정된 글자로 커서 초기화
            this.cursor = new Char(null, null, CURSOR);
        }

        public Editor(String initStr) {
            this();
            for (char c : initStr.toCharArray()) {
                this.commandP(c);
            }
        }

        /**
         * 커서를 좌측으로 이동
         *
         * @return 이미 가장 왼쪽인 경우 false 반환
         */
        boolean commandL() {
            if (this.cursor.bef != null) {
                this.cursor = this.cursor.bef;
                return true;
            }
            return false;
        }

        /**
         * 커서를 우측으로 이동
         *
         * @return 이미 가장 오른쪽인 경우 false 반환
         */
        boolean commandD() {
            if (this.cursor.nxt != null) {
                this.cursor = this.cursor.nxt;
                return true;
            }
            return false;
        }

        /**
         * 커서 좌측의 글자를 지움
         */
        void commandB() {
            if (this.cursor.bef != null) {
                // 커서 좌측의 글자를 지움
                this.cursor.bef = this.cursor.bef.bef;
                if (this.cursor.bef != null) {
                    // 새로운 커서 좌측 글자의 nxt를 커서로 설정
                    this.cursor.bef.nxt = this.cursor;
                }
            }
        }

        /**
         * 커서 좌측에 글자 삽입
         */
        void commandP(char c) {
            // cursor.bef와 cursor 사이에 위치할 newChar 생성
            Char newChar = new Char(this.cursor.bef, this.cursor, c);
            if (this.cursor.bef != null) {
                // cursor.bef의 nxt를 newChar로 설정
                this.cursor.bef.nxt = newChar;
            }
            // cursor.bef를 newChar로 설정
            this.cursor.bef = newChar;
        }

        String print() {
            while (this.commandL()) {
                // 더이상 왼쪽에 글자가 없을 때까지 왼쪽으로 이동
            }

            StringBuilder result = new StringBuilder();
            do {
                // 더이상 오른쪽에 글자가 없을 때까지 오른쪽으로 이동
                if (this.cursor.val != CURSOR) {
                    // 커서를 제외하여 result에 추가
                    result.append(this.cursor.val);
                }
            } while (this.commandD());
            return result.toString();
        }
    }

    static class Char {

        Char bef;
        Char nxt;
        char val;

        public Char() {

        }

        public Char(Char bef, Char nxt, char val) {
            this.bef = bef;
            this.nxt = nxt;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Editor editor = new Editor(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
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
                    char val = st.nextToken().charAt(0);
                    editor.commandP(val);
                    break;
                default:
                    System.out.println("잘못된 명령어");
            }
        }

        System.out.println(editor.print());
    }
}
