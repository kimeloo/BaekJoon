import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean flag;
		int n, m, cnt, y, x, ny, nx, yx;
		int[] dy, dx;
		ArrayDeque<Integer> queueYX = new ArrayDeque<>();
		HashSet<Integer> visited = new HashSet<>();
		char[][] map;
		Scanner sc = new Scanner(System.in);

		flag = false;
		n = sc.nextInt();
		m = sc.nextInt();
		cnt = 0;
		y = 0;
		x = 0;
		ny = 0;
		nx = 0;
		dy = new int[] { 0, 0, 1, -1 };
		dx = new int[] { 1, -1, 0, 0 };
		sc.nextLine();
		map = new char[n][];
		for (int i = 0; i < n; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'I') {
					queueYX.add(i*1000+j);
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		while (queueYX.size() > 0) {
			yx = queueYX.poll();
//			System.out.println(Arrays.toString(yx));
			if (visited.contains(yx)) {
				continue;
			} else {visited.add(yx);}
			y = yx/1000;
			x = yx%1000;
			if (map[y][x]=='P') {cnt++;}
			else if (map[y][x]=='X') {continue;}
			for (int i = 0; i < 4; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
					continue;
				}
				yx = ny*1000+nx;
				if (visited.contains(yx)) {continue;}
				queueYX.offer(yx);
			}
		}
		if (cnt==0) {
			System.out.println("TT");
		} else {System.out.println(cnt);}
		
		sc.close();
	}
}
