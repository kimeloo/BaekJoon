import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int rc;

		public Point() {
		}

		public Point(int r, int c) {
			this.rc = r * 10000 + c;
		}

		public int r() {
			return rc / 10000;
		}

		public int c() {
			return rc % 10000;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point && this.hashCode() == ((Point) obj).hashCode())
				return true;
			return false;
		}

		@Override
		public int hashCode() {
			// r<=100, c<=100이므로 여유있게 10000 곱함
			return Integer.hashCode(rc);
		}

		static Point of(int r, int c) {
			return new Point(r, c);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 초기화
		init(br);

		// 뱀의 방향 횟수에 따라 시뮬레이션
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		int time = 0;
		try {
			for (int i = 0; i < L; i++) {
				st = new StringTokenizer(br.readLine());
				int nextTime = Integer.parseInt(st.nextToken());
				char nextDir = st.nextToken().charAt(0);

				// 다음 회전시간 전까지 계속 이동
				while (time < nextTime) {
					time++;
					move();
				}

				// 회전 (L이면 좌회전, 아니면 우회전)
				direction = (direction + (nextDir == 'L' ? 1 : -1) + 4) % 4;
			}
			// 회전을 모두 마친 후에도 계속 이동
			while (true) {
				time++;
				move();
			}
		} catch (RuntimeException e) {
			System.out.println(time);
		}
	}

	static int N, K, L;
	static Set<Point> apples;
	static Set<Point> snakeSet;
	static Deque<Point> snake;
	static int direction;
	static int[] dr = { 0, -1, 0, 1 }; // 동, 북, 서, 남
	static int[] dc = { 1, 0, -1, 0 };

	static void init(BufferedReader br) throws IOException {
		apples = new HashSet<>();
		snakeSet = new HashSet<>();
		snake = new ArrayDeque<>();
		StringTokenizer st;

		// 보드의 크기
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		// 사과 저장
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			apples.add(Point.of(r, c));
		}

		// 뱀 초기화
		Point initialPoint = Point.of(1, 1);
		snake.offerFirst(initialPoint);
		snakeSet.add(initialPoint);
		direction = 0;
	}

	static void move() {
		// 뱀 머리 값 조회
		Point head = snake.peekFirst();

		// 뱀의 몸 길이를 늘림 (dry)
		Point next = Point.of(head.r() + dr[direction], head.c() + dc[direction]);
//		System.out.println(direction + " " + next.r() + " " + next.c());

		// 종료 조건 확인 : 벽과 충돌 여부
		if (next.r() <= 0 || next.r() > N || next.c() <= 0 || next.c() > N) {
			throw new RuntimeException();
		}

		// 종료 조건 확인 : 자기자신의 몸과 충돌 여부
		if (snakeSet.contains(next)) {
			throw new RuntimeException();
		}

		// 이동한 칸의 사과 여부 확인
		if (apples.contains(next)) {
			// 사과가 있다면 사과를 없앰
			apples.remove(next);

			// 꼬리는 움직이지 않음
		} else {
			// 사과가 없다면 꼬리가 위치한 칸을 비워줌
			snakeSet.remove(snake.pollLast());
		}

		// 뱀의 몸 길이를 실제로 늘림
		snake.offerFirst(next);
		snakeSet.add(next);
	}
}
