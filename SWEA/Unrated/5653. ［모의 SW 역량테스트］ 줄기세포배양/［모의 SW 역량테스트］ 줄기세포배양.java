import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// int[] { life, end, rc } 
public class Solution {
	static int N, M, K;
	static int[] dR = new int[] { 0, 0, 1, -1 };
	static int[] dC = new int[] { 1, -1, 0, 0 };
	// 비활성화
	static PriorityQueue<int[]> inactive;
	// 활성화
	static PriorityQueue<int[]> active;
	// 번식
	static PriorityQueue<int[]> spread;
	// 세포 존재 여부(좌표 조회)
	static HashSet<Integer> isin;

	static BufferedReader br;
	static StringTokenizer st;

	static int conv(int r, int c) {
		return (r + 500) * 10000 + c + 500;
	}

	static int[] conv(int rc) {
		return new int[] { (rc / 10000) - 500, (rc % 10000) - 500 };
	}

	static void init() {
		inactive = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		active = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		spread = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
		isin = new HashSet<>();
	}

	static void input() throws IOException {
		int life, rc;
		init();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				life = Integer.parseInt(st.nextToken());
				if (life > 0) {
					rc = conv(i, j);
					inactive.offer(new int[] { life, life, rc });
					isin.add(rc);
				}
			}
		}
	}

	static int simulate() {
		int[] cell, ncell, rc;
		for (int time = 1; time <= K; time++) {
			while (!active.isEmpty() && active.peek()[1] <= time) { // 생존시간 지난 세포 제거
				active.poll();
			}
			while (!spread.isEmpty()) {
				cell = spread.poll();
				for (int d = 0; d < 4; d++) {
					rc = conv(cell[2]);
					ncell = new int[] { cell[0], time + cell[0], conv(rc[0] + dR[d], rc[1] + dC[d]) };
					if (!isin.contains(ncell[2])) {
						isin.add(ncell[2]);
						inactive.offer(ncell);
					}
				}
				if (cell[0] > 1) {
					cell[1] = time + cell[0] - 1;
					active.offer(cell);
				}
			}
			while (!inactive.isEmpty() && inactive.peek()[1] <= time) { // 비활성 시간 지난 세포 처리
				spread.offer(inactive.poll());
			}
		}
		return active.size() + inactive.size() + spread.size();
	}

	static void output(int tc, int result) {
		StringBuilder sb = new StringBuilder();
		sb.append("#").append(tc).append(" ").append(result).append("\n");
		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		int t, result;
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			input();
			result = simulate();
			output(tc, result);
		}
		br.close();
	}
}