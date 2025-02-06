import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		int t, n, mid, x, y, size;
		long sum;
		PriorityQueue<Integer> minQ;
		PriorityQueue<Integer> maxQ;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			mid = sc.nextInt();
			minQ = new PriorityQueue<>((o1, o2) -> {
				return o1 - o2;
			});
			maxQ = new PriorityQueue<>((o1, o2) -> {
				return o2 - o1;
			});
			sum = 0;
			for (int i = 0; i < n; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				for (int z:new int[]{x,y}) {
					if (z<mid) {
						maxQ.add(z);
					} else {
						minQ.add(z);
					}
				}
				while (maxQ.size()!=minQ.size()) {
					if (maxQ.size()<minQ.size()) {
						maxQ.add(mid);
						mid = minQ.poll();
					} else {
						minQ.add(mid);
						mid = maxQ.poll();
					}
				}
				sum += mid;
			}
			sum %= 20171109;
			System.out.println("#"+tc+" "+sum);
		}
		sc.close();
	}
}