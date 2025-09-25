import java.io.*;
import java.util.*;

public class Main {
	static class Field {
		char[][] field;
		private boolean[][] visited;
		private HashMap<Integer, ArrayList<int[]>> blow;
		static final Field instance = new Field();

		private final int[] dr = new int[] { 0, 0, 1, -1 }; // 동서남북
		private final int[] dc = new int[] { 1, -1, 0, 0 };

		private Field() {
			this.field = new char[12][6];
			this.visited = new boolean[12][6];
			this.blow = new HashMap<>();
		}

		/**
		 * 4개 이상 연결된 것이 없다면 false
		 * 
		 * @return 4개 이상 연결 유무
		 */
		boolean seek() {
			int key = 0;
			// 전체 칸에 대해 4개 이상 연결되었는지 탐색
			for (int r = 0; r < 12; r++) {
				for (int c = 0; c < 6; c++) {
					// 이미 방문한 경우
					if (this.visited[r][c]) {
						continue;
					}

					// 현재 칸이 빈칸이 아닌 경우
					if (this.field[r][c] != '.') {
						ArrayList<int[]> currentBlow = new ArrayList<>();
						blow.put(key++, currentBlow);
						bfs(r, c, this.field[r][c], currentBlow);
					}
				}
			}

			for (int k = 0; k < key; k++) {
				if (blow.get(k).size() < 4) {
					// 4개 미만의 리스트라면 제거
					blow.remove(k);
				}
			}
			return !blow.isEmpty();
		}

		private void bfs(int r, int c, char ch, ArrayList<int[]> currentBlow) {
			// 올바르지 않은 좌표라면 중단
			if (!this.isValid(r, c)) {
				return;
			}

			// 이미 방문한 경우 중단
			if (this.visited[r][c]) {
				return;
			}

			// 현위치가 ch와 같으면
			if (this.field[r][c] == ch) {
				// 같이 터지는 목록에 추가
				currentBlow.add(new int[] { r, c });

				// 방문처리
				this.visited[r][c] = true;

				// 다음 찾기
				for (int d = 0; d < 4; d++) {
					bfs(r + dr[d], c + dc[d], ch, currentBlow);
				}
			}
		}

		void blow() {
			for (int key : blow.keySet()) {
				for (int[] pos : blow.get(key)) {
					this.field[pos[0]][pos[1]] = '.';
				}
			}
			cleanup();
		}

		private void cleanup() {
			// 아래에서 위로 훑으며 정리
			for (int c = 0; c < 6; c++) {
				int idx = 11;
				char[] newLine = new char[] { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' };
				for (int r = 11; r >= 0; r--) {
					if (this.field[r][c] != '.') {
						newLine[idx--] = this.field[r][c];
					}
				}
				for (int r = 0; r < 12; r++) {
					this.field[r][c] = newLine[r];
				}
			}
			// 초기화
			this.visited = new boolean[12][6];
			this.blow.clear();
		}

		private boolean isValid(int r, int c) {
			if (r >= 12 || c >= 6 || r < 0 || c < 0) {
				return false;
			}
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Field field = Field.instance;
		for (int r = 0; r < 12; r++) {
			char[] line = br.readLine().trim().toCharArray();
			for (int c = 0; c < 6; c++) {
				field.field[r][c] = line[c];
			}
		}

		int ans = 0;
		while (field.seek()) {
			field.blow();
			ans++;
		}

		System.out.println(ans);
	}
}
