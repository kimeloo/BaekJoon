import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder result = new StringBuilder();

		int n, m, k, a, b;
		long c;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		SegmentTree tree = new SegmentTree(n);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			tree.update(i, Long.parseLong(st.nextToken()));
		}

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if (a == 1) {
				tree.update(--b, c);
			} else {
				result.append(tree.getSum(--b, ((int) c) - 1)).append("\n");
			}
		}

		System.out.print(result);
		br.close();
	}
}

class SegmentTree {
	// https://book.acmicpc.net/ds/segment-tree
	private int len;
	public long[] tree;
	public long[] original;

	public SegmentTree(int len) {
		this.len = len;
		original = new long[len];
		tree = new long[(int) Math.pow(2, Math.ceil(Math.log10(len) / Math.log10(2)) + 1)];
	}

	public SegmentTree(long[] original) {
		this.original = original;
		this.len = original.length;
		tree = new long[(int) Math.pow(2, Math.ceil(Math.log10(len) / Math.log10(2)) + 1)];
		init(1, 0, len - 1);
	}

	private void init(int node, int start, int end) {
		// start==end인 경우, 리프 노드임 -> start에 해당하는 값을 현재 노드에 저장
		if (start == end) {
			tree[node] = original[start];
		}

		// 그게 아닌 경우, 자식 노드가 존재함 -> 자식 노드를 먼저 구해두고, 두 자식을 더해 현재 노드에 값을 넣음
		// 왼쪽 자식은 start~mid, 오른쪽 자식은 mid+1~end의 합이 저장됨
		else {
			init(node * 2, start, (start + end) / 2);
			init(node * 2 + 1, (start + end) / 2 + 1, end);
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
	}

	public long getSum(int left, int right) {
		return getSum(1, 0, this.len - 1, left, right);
	}

	private long getSum(int node, int start, int end, int left, int right) {
		// 구간합을 구하고자 하는 범위 : left~right
		// 현재 노드가 갖고 있는 구간합 범위 : start~end

		// 현재 노드가 갖고 있는 범위와, 구간합을 구하고자 하는 범위가 전혀 겹치지 않는 경우
		if (end < left || right < start) {
			return 0;
		}

		// 현재 노드가 갖고 있는 범위가, 구간합을 구하고자 하는 범위에 포함되는 경우
		if (left <= start && end <= right) {
			return tree[node];
		}

		// 현재 노드가 갖고 있는 범위와, 구간합을 구하고자 하는 범위가 겹치지만 포함 관계는 아닌 경우
		// 겹치는 부분만 더하기 위해, 자식 노드의 범위를 조사
		long sumL = getSum(node * 2, start, (start + end) / 2, left, right);
		long sumR = getSum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
		return sumL + sumR;
	}

	public void update(int idx, long value) {
		long diff = value - this.original[idx];
		this.original[idx] = value;
		update(1, 0, this.len - 1, idx, diff);
	}

	private void update(int node, int start, int end, int idx, long diff) {
		// 현재 노드가 리프 노드인 경우
		if (start == end && start == idx) {
			tree[node] += diff;
		}

		// 현재 노드의 범위가 idx를 포함할 경우, 현재 노드+diff & 자식 노드 탐색
		else if (start <= idx && idx <= end) {
			tree[node] += diff;
			update(node * 2, start, (start + end) / 2, idx, diff);
			update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
		}

		// 현재 노드가 idx를 포함하는 범위가 아닌 경우 처리 X
	}
}