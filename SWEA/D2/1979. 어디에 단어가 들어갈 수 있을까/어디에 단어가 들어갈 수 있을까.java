import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, K, CNT;
	static int[][] MAP;
	static BufferedReader br;
	static StringTokenizer st;

	static void input() throws IOException {
		int stream;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		MAP = new int[N][N];
		CNT = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stream = 0;
			for (int j = 0; j < N; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				if (MAP[i][j] == 1) {
					stream++;
				} else {
					if (stream == K) {
						CNT++;
					}
					stream = 0;
				}
			}
			if (stream==K) {
				CNT++;
			}
		}
	}

	static void simulate() {
		int stream;
		for (int i = 0; i < N; i++) {
			stream = 0;
			for (int j = 0; j < N; j++) {
				if (MAP[j][i] == 1) {
					stream++;
				} else {
					if (stream == K) {
						CNT++;
					}
					stream = 0;
				}
			}
			if (stream==K) {
				CNT++;
			}
		}
	}

	static void output(int tc) {
		StringBuilder sb = new StringBuilder();
		sb.append("#").append(tc).append(" ").append(CNT).append("\n");
		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			input();
			simulate();
			output(tc);
		}
		br.close();
	}
}