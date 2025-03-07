import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader reader;
	static StringTokenizer input;
	static StringBuilder output;

	public static void main(String[] args) throws IOException {
		Field game;
		reader = new BufferedReader(new InputStreamReader(System.in));
		input = new StringTokenizer(reader.readLine());
		output = new StringBuilder();

		int T = Integer.parseInt(input.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			output.append("#").append(tc).append(" ");
			game = init();
			run(game);
			output.append(game.getMap());
		}

		System.out.print(output);
	}

	static Field init() throws IOException {
		int h, w;
		char[] in;
		Field game;
		input = new StringTokenizer(reader.readLine());
		h = Integer.parseInt(input.nextToken());
		w = Integer.parseInt(input.nextToken());
		game = new Field(h, w);
		for (int r = 0; r < h; r++) {
			input = new StringTokenizer(reader.readLine());
			in = input.nextToken().toCharArray();
			for (int c = 0; c < in.length; c++) {
				game.init(r, c, in[c]);
			}
		}
		return game;
	}

	static void run(Field game) throws IOException {
		input = new StringTokenizer(reader.readLine());
		input = new StringTokenizer(reader.readLine());
		char[] cmds = input.nextToken().toCharArray();
		for (char cmd : cmds) {
			game.command(cmd);
		}
	}
}

// 전차 클래스
class Tank {
	private int row, col, dir; // dir : 동,남,서,북 (0,1,2,3)
	private static char[][] mapDir = { { 0, 1, 2, 3 }, { '>', 'v', '<', '^' }, { 'R', 'D', 'L', 'U' } };

	public Tank(int row, int col, char dir) {
		this.row = row;
		this.col = col;
		this.dir = mapDirection(dir);
	}

	public static int mapDirection(char dir) { // 입력으로 주어진 전차 방향을 정수로 변환
		for (int i = 0; i < 4; i++) {
			if (mapDir[1][i] == dir) {
				return mapDir[0][i];
			}
		}
		return -1;
	}

	private char mapDirection(int dir) { // 정수 전차 방향을 입력 형식의 방향으로 변환
		for (int i = 0; i < 4; i++) {
			if (mapDir[0][i] == dir) {
				return mapDir[1][i];
			}
		}
		return '\u0000';
	}

	public int getDirection() { // 정수 전차 방향 반환
		return dir;
	}

	public char getDirectionChar() { // 전차 방향을 입/출력 형식으로 반환
		return mapDirection(this.dir);
	}

	public void setDirection(char dir) { // 명령어 형식의 전차 방향을 정수로 변환
		for (int i = 0; i < 4; i++) {
			if (mapDir[2][i] == dir) {
				this.dir = mapDir[0][i];
				return;
			}
		}
	}

	public int[] getPosition() { // 전차 위치, 방향 반환
		return new int[] { this.row, this.col, this.dir };
	}

	public void setPosition(int r, int c) {
		this.row = r;
		this.col = c;
	}
}

// 맵 클래스
class Field {
	private static int[] dc = { 1, 0, -1, 0 };
	private static int[] dr = { 0, 1, 0, -1 };

	private int[] SIZE;
	private char[][] MAP;
	private Tank TANK;

	public Field(int height, int width) {
		this.SIZE = new int[] { height, width };
		this.MAP = new char[height][width];
	}

	public void init(int row, int col, char value) {
		this.MAP[row][col] = value;
		if (Tank.mapDirection(value) != -1) { // 전차의 방향을 나타내는 값이라면
			TANK = new Tank(row, col, value); // 전차 생성
		}
	}

	public void command(char cmd) {
		if (cmd == 'S') {
			shoot();
		} else {
			TANK.setDirection(cmd);
			move();
		}
	}

	public String getMap() {
		StringBuilder result = new StringBuilder();
		for (int row = 0; row < SIZE[0]; row++) {
			for (int col = 0; col < SIZE[1]; col++) {
				result.append(MAP[row][col]);
			}
			result.append("\n");
		}
		return result.toString();
	}

	private void shoot() {
		// 전차가 바라보는 방향으로 포탄 발사
		// 맵 크기만큼 직진 발사하며 destroy 메서드 실행
		int r, c, dir;
		int[] position = TANK.getPosition();
		r = position[0];
		c = position[1];
		dir = position[2];
		for (int i = 0; i < Math.max(SIZE[0], SIZE[1]); i++) {
			r += dr[dir];
			c += dc[dir];
			if (!destroy(r, c)) {
				break;
			}
		}
	}

	private void move() {
		// 새로운 전차 방향에 맞춰 MAP의 전차 방향 전환
		// 새로운 전차 위치 가능여부 계산
		// 가능하면, 기존 전차 위치는 '.'(평지)로 덮어쓰기
		int r, c, dir;
		char tank;
		int[] position = TANK.getPosition();
		r = position[0];
		c = position[1];
		dir = position[2];
		tank = TANK.getDirectionChar();
		MAP[r][c] = tank;

		if (canMove(r + dr[dir], c + dc[dir])) {
			MAP[r + dr[dir]][c + dc[dir]] = tank;
			TANK.setPosition(r + dr[dir], c + dc[dir]);
			MAP[r][c] = '.';
		}
	}

	private boolean destroy(int row, int col) {
		if (!isValid(row, col)) {
			return false;
		}
		switch (MAP[row][col]) {
		case '*':
			MAP[row][col] = '.';
		case '#':
			return false;
		default:
		}
		return true;
	}

	private boolean canMove(int row, int col) {
		if (!isValid(row, col) || MAP[row][col] != '.') {
			return false;
		}
		return true;
	}

	private boolean isValid(int row, int col) {
		// 유효한 좌표 범위인지 검사
		if (row >= SIZE[0] || col >= SIZE[1] || row < 0 || col < 0) {
			return false;
		}
		return true;
	}
}