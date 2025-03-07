import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		CountingSort cntsort = new CountingSort(arr);
		cntsort.sort();

		System.out.printf("%d\n%d\n%d\n%d", Math.round(cntsort.getAverage()), cntsort.getMid(), cntsort.getMode(),
				cntsort.getRange());

		br.close();
	}

}

class CountingSort {
	private boolean isSorted;
	private int N, start, end, sum;
	private int[] array, sorted, count, cntSum;

	public CountingSort(int[] array) {
		this.array = array;
		init();
	}

	public void sort() {
		count();
		sortByCount();
		isSorted = true;
	}

	public float getAverage() {
		if (isSorted) {
			return (((float) sum) / ((float) N));
		}
		return 0;
	}

	public int getMid() {
		if (isSorted) {
			return sorted[N / 2];
		}
		return 0;
	}

	public int getMode() {
		boolean update = false;
		int result, value, leastVal;
		result = 0;
		value = Integer.MAX_VALUE;
		leastVal = Integer.MAX_VALUE;
		for (int idx = 0; idx < count.length; idx++) {
			if (count[idx] > result) {
				result = count[idx];
				leastVal = idx + start;
				update = true;
			} else if (count[idx] == result) {
				if (update && idx + start > leastVal) {
					value = idx + start;
					update = false;
				} else if (idx + start > leastVal && idx + start < value) {
					value = idx + start;
				} else if (idx + start < leastVal) {
					value = leastVal;
					leastVal = idx + start;
				}
			}
		}
		return (update ? leastVal : value);
	}

	public int getRange() {
		return end - start;
	}

	private void init() {
		this.N = array.length;
		this.sorted = new int[N];

		start = Integer.MAX_VALUE;
		end = Integer.MIN_VALUE;
		sum = 0;
		for (int n : array) {
			start = Math.min(start, n);
			end = Math.max(end, n);
			sum += n;
		}
		count = new int[end - start + 1];
		cntSum = new int[count.length];
	}

	private void count() {
		for (int n : array) {
			count[n - start]++;
			cntSum[n - start]++;
		}

		for (int i = 1; i < count.length; i++) {
			cntSum[i] += cntSum[i - 1];
		}
	}

	private void sortByCount() {
		for (int i = array.length - 1; i >= 0; i--) {
			sorted[--cntSum[array[i] - start]] = array[i];
		}
	}
}