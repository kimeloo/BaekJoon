import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Num {
	int value;
	int cnt;

	public Num(int value, int cnt) {
		this.value = value;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Num [value=" + value + ", cnt=" + cnt + "]";
	}
}

public class Main {
	static int bfs(int start, int target) {
		int over = Integer.MAX_VALUE;
		Num current;
		ArrayDeque<Num> q = new ArrayDeque<>();
		q.offer(new Num(start, 1));
		while (q.size() > 0) {
			current = q.poll();
//			System.out.println(current);
			if (current.value == target) {
				return current.cnt;
			}
			if (current.value > target) {
				if (current.cnt > over) {
					return -1;
				}
				continue;
			} else {
				q.offer(new Num(current.value * 2, current.cnt + 1));
				q.offer(new Num(current.value * 10 + 1, current.cnt + 1));
			}
			over = current.cnt;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		System.out.println(bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		bf.close();
	}
}