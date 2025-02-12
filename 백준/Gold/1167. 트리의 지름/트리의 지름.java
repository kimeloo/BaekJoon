import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Point {
	int idx;
	int weight;

	public Point(int idx, int weight) {
		this.idx = idx;
		this.weight = weight;
	}
}

public class Main {
	static int V;
	static int[] visited;
	static HashMap<Integer, List<Point>> graph = new HashMap<>();

	static int[] searchFar(int start) {
		int max = 0;
		visited = new int[V + 1];
		find(start, -1);
		for (int i = 1; i < V + 1; i++) {
			if (visited[max] < visited[i]) {
				max = i;
			}
		}
		return new int[] {max, visited[max]+1};
	}

	static void find(int start, int weight) {
		visited[start] = weight;
		List<Point> next = graph.get(start);
		for (Point p : next) {
			if (visited[p.idx] == 0) {
				find(p.idx, weight + p.weight);
			}
		}
	}

	public static void main(String[] args) {
		int current, next, weight;
		List<Point> curList;
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		for (int i = 0; i < V; i++) {
			current = sc.nextInt();
			curList = new ArrayList<>();
			next = sc.nextInt();
			while (next != -1) {
				weight = sc.nextInt();
				curList.add(new Point(next, weight));
				next = sc.nextInt();
			}
			graph.put(current, curList);
		}
		
		System.out.println(searchFar(searchFar(1)[0])[1]);

		sc.close();
	}
}
