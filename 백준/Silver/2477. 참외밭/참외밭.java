import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int unit = Integer.parseInt(br.readLine().trim());

        int largeSquare = 1;
        int smallSquare = 1;

        int[][] lines = new int[6][2];

        for (int i = 0; i < 6; i++) {
            String[] input = br.readLine().trim().split(" ");
            lines[i][0] = Integer.parseInt(input[0]);
            lines[i][1] = Integer.parseInt(input[1]);
        }

        // 동-서에서 가장 긴 변의 다음 방향 == 다다다음방향이면 긴변idx+2 값이 small sq변
        // 다음 방향 != 다다다음방향이면 긴변idx-2 값이 small sq 변
        // 남-북도 마찬가지
        int maxIdx = -1; // 가장 긴 변의 idx 저장
        for (int dir = 2; dir < 5; dir += 2) {    // 동,서 = 1,2 | 남,북 = 3,4
            for (int i = 0; i < 6; i++) {
                if ((lines[i][0] == dir || lines[i][0] == dir - 1) &&
                    (maxIdx == -1 || lines[maxIdx][1] < lines[i][1])) {
                    maxIdx = i;
                }

            }

            largeSquare *= lines[maxIdx][1];
            if (lines[(maxIdx + 1) % 6][0] == lines[(maxIdx + 3) % 6][0]) {
                smallSquare *= lines[(maxIdx + 2) % 6][1];
            } else {
                smallSquare *= lines[(maxIdx + 4) % 6][1];
            }

            maxIdx = -1;
        }

        System.out.println((largeSquare - smallSquare) * unit);
    }
}
