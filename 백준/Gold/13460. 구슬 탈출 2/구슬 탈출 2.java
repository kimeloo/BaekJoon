import java.io.*;
import java.util.*;

public class Main {

	static class Field {
		private static final char WALL = '#';
		private static final char EMPTY = '.';
		private static final char HOLE = 'O';
		private static final char RED = 'R';
		private static final char BLUE = 'B';

		int depth;
		final int N, M;
		final char[][] field;
		int hash;
		boolean[] result = new boolean[2];

		public Field(int N, int M) {
			this.depth = 0;
			this.N = N;
			this.M = M;
			this.field = new char[N][M]; // {red, blue}
		}

		private Field(Field other) {
			this(other.N, other.M);
			for (int r = 0; r < N; r++) {
				System.arraycopy(other.field[r], 0, this.field[r], 0, M);
			}
			this.depth = other.depth;
		}

		static Field copyOf(Field field) {
			return new Field(field);
		}

		static Field nextDepthOf(Field field) {
			Field next = new Field(field);
			next.depth++;
			return next;
		}

		Field moveLeft() {
			for (int r = 0; r < N; r++) {
				int idx = 0;
				boolean canGoal = false;
				for (int c = 0; c < M; c++) {
					switch (field[r][c]) {
					case WALL:
						idx = c + 1;
						canGoal = false;
						break;
					case HOLE:
						canGoal = true;
						break;
					case RED:
						if (canGoal) {
							result[0] = true;
						}
						field[r][c] = EMPTY;
						field[r][idx++] = RED;
						hash += r * 1000000 + (idx - 1) * 10000;
						break;
					case BLUE:
						if (canGoal) {
							result[1] = true;
						}
						field[r][c] = EMPTY;
						field[r][idx++] = BLUE;
						hash += r * 100 + (idx - 1);
						break;
					case EMPTY:
					default:
					}
				}
			}
			return this;
		}

		Field moveRight() {
			for (int r = 0; r < N; r++) {
				int idx = M - 1;
				boolean canGoal = false;
				for (int c = M - 1; c >= 0; c--) {
					switch (field[r][c]) {
					case WALL:
						idx = c - 1;
						canGoal = false;
						break;
					case HOLE:
						canGoal = true;
						break;
					case RED:
						if (canGoal) {
							result[0] = true;
						}
						field[r][c] = EMPTY;
						field[r][idx--] = RED;
						hash += r * 1000000 + (idx + 1) * 10000;
						break;
					case BLUE:
						if (canGoal) {
							result[1] = true;
						}
						field[r][c] = EMPTY;
						field[r][idx--] = BLUE;
						hash += r * 100 + (idx + 1);
						break;
					case EMPTY:
					default:
					}
				}
			}
			return this;
		}

		Field moveUp() {
			for (int c = 0; c < M; c++) {
				int idx = 0;
				boolean canGoal = false;
				for (int r = 0; r < N; r++) {
					switch (field[r][c]) {
					case WALL:
						idx = r + 1;
						canGoal = false;
						break;
					case HOLE:
						canGoal = true;
						break;
					case RED:
						if (canGoal) {
							result[0] = true;
						}
						field[r][c] = EMPTY;
						field[idx++][c] = RED;
						hash += (idx - 1) * 1000000 + c * 10000;
						break;
					case BLUE:
						if (canGoal) {
							result[1] = true;
						}
						field[r][c] = EMPTY;
						field[idx++][c] = BLUE;
						hash += (idx - 1) * 100 + c;
						break;
					case EMPTY:
					default:
					}
				}
			}
			return this;
		}

		Field moveDown() {
			for (int c = 0; c < M; c++) {
				int idx = N - 1;
				boolean canGoal = false;
				for (int r = N - 1; r >= 0; r--) {
					switch (field[r][c]) {
					case WALL:
						idx = r - 1;
						canGoal = false;
						break;
					case HOLE:
						canGoal = true;
						break;
					case RED:
						if (canGoal) {
							result[0] = true;
						}
						field[r][c] = EMPTY;
						field[idx--][c] = RED;
						hash += (idx + 1) * 1000000 + c * 10000;
						break;
					case BLUE:
						if (canGoal) {
							result[1] = true;
						}
						field[r][c] = EMPTY;
						field[idx--][c] = BLUE;
						hash += (idx + 1) * 100 + c;
						break;
					case EMPTY:
					default:
					}
				}
			}
			return this;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Field initField = new Field(N, M);
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			initField.field[r] = st.nextToken().toCharArray();
		}

		ArrayDeque<Field> queue = new ArrayDeque<>();
		queue.offer(initField);
		while (!queue.isEmpty()) {
			Field field = queue.poll();
			if (field.result[1]) {
				continue;
			}
			if (field.result[0]) {
				System.out.println(field.depth);
				return;
			}
			if (field.depth >= 10) {
				continue;
			}

			HashSet<Integer> visited = new HashSet<>();

			Field[] nextList = new Field[] { Field.nextDepthOf(field).moveLeft(), Field.nextDepthOf(field).moveRight(),
					Field.nextDepthOf(field).moveDown(), Field.nextDepthOf(field).moveUp() };
			for (Field next : nextList) {
				if (!visited.contains(next.hash)) {
					visited.add(next.hash);
					queue.offer(next);
				}
			}
		}

		System.out.println(-1);
	}
}
