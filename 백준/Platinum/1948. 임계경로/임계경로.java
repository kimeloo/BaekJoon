import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

class Road {
	int start, end, time;

	public Road(int start, int end, int time) {
		this.start = start;
		this.end = end;
		this.time = time;
	}
}

public class Main {
	static int[] indegree; // 도시별 진입차수
	static int[] arrivedT; // 도시별 도착시간
	static boolean[] visited; // 역방향 방문 여부
	static Road tempRoad;
	static HashSet<Road> answer;
	static ArrayList<Road>[] cityStart; // 도시별 도로번호 list
	static ArrayList<Road>[] cityEnd; // 도시별 도로번호 list
	// 도로번호 인코딩 : 도착a 시간b -> aaaaabbbbb

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// 그래프 순차 탐색XX -> OOT
		// 도시별 진입차수 indegree 배열 저장
		// 도로 추가시, 도착도시의 indegree++
		// 도시 도달시, 도착도시의 --indegree==0이면 연산할 q에 추가
		// q.poll -> 도시 방문 처리
		int N, M, start, end, time;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		indegree = new int[N + 1];
		arrivedT = new int[N + 1];
		answer = new HashSet<>();
		cityStart = new ArrayList[N + 1];
		cityEnd = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			indegree[end]++;
			if (cityStart[start] == null) {
				cityStart[start] = new ArrayList<>();
			}
			if (cityEnd[end] == null) {
				cityEnd[end] = new ArrayList<>();
			}
			tempRoad = new Road(start, end, time);
			cityStart[start].add(tempRoad);
			cityEnd[end].add(tempRoad);

		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		br.close();

		find(start, end);
		findRoad(start, end);

		System.out.println(arrivedT[end]);
		System.out.println(answer.size());

	}

	// 정방향 탐색으로, 도시별 최대시간 구하기
	static void find(int start, int end) {
		if (start == end) {
			return;
		}

		for (Road road : cityStart[start]) {
			arrivedT[road.end] = Math.max(arrivedT[road.end], arrivedT[start] + road.time);
			if (--indegree[road.end] == 0) {
				find(road.end, end);
			}
		}
	}

	// 역방향 탐색으로, 최대시간 만족하는 도로 구하기
	static void findRoad(int start, int end) {
		if (start == end) {
			return;
		}

		for (Road road : cityEnd[end]) {
			if (arrivedT[road.start] + road.time == arrivedT[end]) {
//				System.out.println(road.start + " " + road.end);
				answer.add(road);
				if (!visited[road.start]) {
					visited[road.start] = true;
					findRoad(start, road.start);
				}
			}
		}
	}
}