import java.io.*;
import java.util.*;

public class Main {
	static class Board {
		int depth;
		int size;
		int[][] board;

		public Board(int depth, int size) {
			this.depth = depth;
			this.size = size;
			this.board = new int[size][size];
		}

		static Board nextDepthOf(Board old) {
			Board newBoard = new Board(old.depth, old.size);
			newBoard.depth++;
			// 배열 복제
			for (int i = 0; i < old.size; i++) {
				System.arraycopy(old.board[i], 0, newBoard.board[i], 0, old.size);
			}
			return newBoard;
		}

		int getMax() {
			int max = 0;
			for (int r = 0; r < this.size; r++) {
				for (int c = 0; c < this.size; c++) {
					max = Math.max(max, this.board[r][c]);
				}
			}
			return max;
		}

		Board moveLeft() {
			for (int row = 0; row < this.size; row++) {
				int colW = 0;
				for (int colR = 0; colR < this.size; colR++) {
					if (this.board[row][colR] != 0 && colR != colW) {
						if (this.board[row][colW] == this.board[row][colR]) {
							// 합치는 것이 가능할 때 합친 후 포인터를 다음 칸으로 이동
							this.board[row][colR] = 0;
							this.board[row][colW++] *= 2;
						} else if (this.board[row][colW] == 0) {
							// 포인터 칸이 비어있다면 바로 이동
							int tmp = this.board[row][colR];
							this.board[row][colR] = 0;
							this.board[row][colW] = tmp;
						} else {
							// 포인터칸이 비어있지 않다면 포인터 이동 후 이동
							int tmp = this.board[row][colR];
							this.board[row][colR] = 0;
							this.board[row][++colW] = tmp;
						}
					}
				}
			}
			return this;
		}

		Board moveRight() {
			for (int row = 0; row < this.size; row++) {
				int colW = this.size - 1;
				for (int colR = this.size - 1; colR >= 0; colR--) {
					if (this.board[row][colR] != 0 && colR != colW) {
						if (this.board[row][colW] == this.board[row][colR]) {
							// 합치는 것이 가능할 때 합친 후 포인터를 다음 칸으로 이동
							this.board[row][colR] = 0;
							this.board[row][colW--] *= 2;
						} else if (this.board[row][colW] == 0) {
							// 포인터 칸이 비어있다면 바로 이동
							int tmp = this.board[row][colR];
							this.board[row][colR] = 0;
							this.board[row][colW] = tmp;
						} else {
							// 포인터칸이 비어있지 않다면 포인터 이동 후 이동
							int tmp = this.board[row][colR];
							this.board[row][colR] = 0;
							this.board[row][--colW] = tmp;
						}
					}
				}
			}
			return this;
		}

		Board moveDown() {
			for (int col = 0; col < this.size; col++) {
				int rowW = 0;
				for (int rowR = 0; rowR < this.size; rowR++) {
					if (this.board[rowR][col] != 0 && rowR != rowW) {
						if (this.board[rowW][col] == this.board[rowR][col]) {
							// 합치는 것이 가능할 때 합친 후 포인터를 다음 칸으로 이동
							this.board[rowR][col] = 0;
							this.board[rowW++][col] *= 2;
						} else if (this.board[rowW][col] == 0) {
							// 포인터 칸이 비어있다면 바로 이동
							int tmp = this.board[rowR][col];
							this.board[rowR][col] = 0;
							this.board[rowW][col] = tmp;
						} else {
							// 포인터칸이 비어있지 않다면 포인터 이동 후 이동
							int tmp = this.board[rowR][col];
							this.board[rowR][col] = 0;
							this.board[++rowW][col] = tmp;
						}
					}
				}
			}
			return this;
		}

		Board moveUp() {
			for (int col = 0; col < this.size; col++) {
				int rowW = this.size - 1;
				for (int rowR = this.size - 1; rowR >= 0; rowR--) {
					if (this.board[rowR][col] != 0 && rowR != rowW) {
						if (this.board[rowW][col] == this.board[rowR][col]) {
							// 합치는 것이 가능할 때 합친 후 포인터를 다음 칸으로 이동
							this.board[rowR][col] = 0;
							this.board[rowW--][col] *= 2;
						} else if (this.board[rowW][col] == 0) {
							// 포인터 칸이 비어있다면 바로 이동
							int tmp = this.board[rowR][col];
							this.board[rowR][col] = 0;
							this.board[rowW][col] = tmp;
						} else {
							// 포인터칸이 비어있지 않다면 포인터 이동 후 이동
							int tmp = this.board[rowR][col];
							this.board[rowR][col] = 0;
							this.board[--rowW][col] = tmp;
						}
					}
				}
			}
			return this;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken());
		Board initBoard = new Board(0, size);

		for (int r = 0; r < size; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < size; c++) {
				initBoard.board[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayDeque<Board> queue = new ArrayDeque<>();
		queue.offer(initBoard);

		int ans = 0;
		while (!queue.isEmpty()) {
			Board board = queue.poll();
			if (board.depth == 5) {
				ans = Math.max(ans, board.getMax());
				continue;
			}

			queue.offer(Board.nextDepthOf(board).moveUp());
			queue.offer(Board.nextDepthOf(board).moveDown());
			queue.offer(Board.nextDepthOf(board).moveLeft());
			queue.offer(Board.nextDepthOf(board).moveRight());
		}

		System.out.println(ans);
	}
}
