import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, maxLen, maxIdx;
	static boolean[] VISITED;
	static ArrayList<int[]>[] TREE;

	// 임의의 한 정점에서부터 가장 먼 정점 구하기
	// 구한 정점에서부터 가장 먼 정점까지의 거리 = 트리의 지름
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner(System.in);
		sc.newLine();
		N = sc.nextInt();
		TREE = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			TREE[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			int parent, child, weight;
			sc.newLine();
			parent = sc.nextInt();
			child = sc.nextInt();
			weight = sc.nextInt();
			TREE[parent].add(new int[] { child, weight });
			TREE[child].add(new int[] { parent, weight });

		}

		maxLen = Integer.MIN_VALUE;
		maxIdx = -1;
		VISITED = new boolean[N + 1];
		VISITED[1] = true;
		dfs(1, 0);
		maxLen = Integer.MIN_VALUE;
		VISITED = new boolean[N+1];
		VISITED[maxIdx] = true;
		dfs(maxIdx, 0);
		System.out.println(maxLen);

		sc.close();
	}

	static void dfs(int idx, int len) {
		boolean hasNext = false;
		for (int[] temp : TREE[idx]) {
			if (VISITED[temp[0]]) {
				continue;
			}
			VISITED[temp[0]] = true;
			hasNext = true;
			dfs(temp[0], len + temp[1]);
			VISITED[temp[0]] = false;
		}
		if (!hasNext) {
			if (len > maxLen) {
				maxLen = len;
				maxIdx = idx;
			}
		}
	}
}

class MyScanner {
	BufferedReader br;
	StringTokenizer st;

	void newLine() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	int nextInt() {
		return Integer.parseInt(st.nextToken());
	}

	public MyScanner(InputStream in) {
		br = new BufferedReader(new InputStreamReader(in));
	}

	void close() throws IOException {
		br.close();
	}
}