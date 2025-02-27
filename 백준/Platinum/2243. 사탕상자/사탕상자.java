import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 사탕의 맛별 배열 생성 사탕 종류가 1,000,000가지이므로 길이가 1,000,000인 long[] 생성 각 종류의 사탕이 몇개 있는지를
	 * 각 칸에 저장 사탕 배열의 구간합을 구하기 -> 세그먼트 트리 n번째로 맛있는 사탕? -> 1번사탕부터 구간합이 n개 이상(STRICT)인
	 * 사탕 n을 찾기 위해 구간합을 이분탐색
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder result = new StringBuilder();

		int n, m, k, a;
		long b, c;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		SegmentTree tree = new SegmentTree(1000001);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Long.parseLong(st.nextToken());
			if (a == 2) {
				c = Long.parseLong(st.nextToken());
				tree.updated((int) b, c);
			} else {
				c = tree.find(b);
//				System.out.println(c);
				result.append(c).append("\n");
				tree.updated((int) c, -1);
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
		updated(idx, diff);
	}

	public void updated(int idx, long diff) {
		this.original[idx] += diff;
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

	public int find(long rank) {
		return find(1, 0, this.len - 1, rank);
	}

	private int find(int node, int start, int end, long rank) {
		// 리프 노드인 경우, 리프노드가 가진 배열의 idx 반환
		if (start == end) {
			return end;
		}

//		 현재 노드가 가진 부분합이 rank와 같은 경우, 현재 노드의 end가 정답
//		if (tree[node] == rank) {
//			return end;
//		}
		// 현재 노드가 가진 부분합이 rank보다 큰 경우, 처리 필요
		else if (tree[node] >= rank) {
			// 왼쪽 자식의 부분합이 rank보다 크거나 같은 경우 : 왼쪽 자식에서 다시 탐색
			if (tree[node * 2] >= rank) {
				return find(node * 2, start, (start + end) / 2, rank);
			}
			// 그게 아닌 경우, 오른쪽 자식에서 탐색
			// 이 때, rank는 왼쪽 자식만큼 빼주기
			else {
				return find(node * 2 + 1, (start + end) / 2 + 1, end, rank - tree[node * 2]);
			}
		}
		// 현재 노드가 가진 부분합이 rank보다 작은 경우, 저리 불가
		return -1;
	}
}