import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] list = input();
        int result = simulate(list);
        System.out.println(result);
    }

    static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] list = new int[1001];
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int pos = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            list[pos] = height;
        }
        br.close();

        return list;
    }

    static int simulate(int[] list) {
        int result = 0;

        // 1. 가장 높은 기둥의 인덱스 찾기
        int maxIdx = 0;
        for (int i = 0; i < 1001; i++) {
            if (list[maxIdx] < list[i]) {
                maxIdx = i;
            }
        }

        // 좌 → 우: i = 0 ~ maxIdx-1
        // maxIdx 위치까지 영역을 채움 (maxIdx 기둥 자체는 오른쪽에서 처리)
        int maxHeight = 0;
        for (int i = 0; i < maxIdx; i++) {
            maxHeight = Math.max(maxHeight, list[i]);
            result += maxHeight;
        }

        // 우 → 좌: i = 1000 ~ maxIdx (maxIdx 포함)
        // 각 기둥의 오른쪽 끝에서 왼쪽으로 채움
        maxHeight = 0;
        for (int i = 1000; i >= maxIdx; i--) {
            maxHeight = Math.max(maxHeight, list[i]);
            result += maxHeight;
        }

        return result;
    }
}
