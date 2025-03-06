import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String[] users;
	static String[] tempArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		users = new String[N];
		tempArr = new String[N];
		for (int i = 0; i < N; i++) {
			users[i] = br.readLine().strip();
		}
		mergeSort(0, N - 1);
		for (String line : users) {
			System.out.println(line);
		}

		br.close();
	}

	static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, mid, end);
		}
	}

	static void merge(int start, int mid, int end) {
		int idx, left, right;
		idx = start;
		left = start;
		right = mid + 1;

		while (left <= mid && right <= end) {
			if (valueOf(users[left]) <= valueOf(users[right])) {
				tempArr[idx++] = users[left++];
			} else {
				tempArr[idx++] = users[right++];
			}
		}

		for (; left <= mid; left++) {
			tempArr[idx++] = users[left];
		}
		for (; right <= end; right++) {
			tempArr[idx++] = users[right];
		}
		for (int i = start; i <= end; i++) {
			users[i] = tempArr[i];
		}
	}

	static int valueOf(String value) {
		return Integer.parseInt(value.split(" ")[0]);
	}
}