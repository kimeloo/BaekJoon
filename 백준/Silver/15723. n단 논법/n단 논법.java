import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static char[] input(StringTokenizer st) {
        char[] result = new char[2];
        result[0] = st.nextToken().charAt(0);
        st.nextToken();
        result[1] = st.nextToken().charAt(0);
        return result;
    }

    public static void main(String[] args) throws IOException {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] ab = input(st);
            if (!graph.containsKey(ab[0])) {
                graph.put(ab[0], new ArrayList<>());
            }
            graph.get(ab[0]).add(ab[1]);
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            char[] cd = input(st);
            ArrayDeque<Character> queue = new ArrayDeque<>();
            queue.offer(cd[0]);
            char tar = cd[1];
            boolean ans = false;

            boolean[] visited = new boolean[26];
            visited[cd[0] - 'a'] = true;

            while (!queue.isEmpty()) {
                char cur = queue.poll();
                List<Character> nextList = graph.getOrDefault(cur,List.of());
                for (char nxt : nextList) {
                    if (visited[nxt - 'a']) {
                        continue;
                    }
                    visited[nxt - 'a'] = true;
                    queue.offer(nxt);
                    if (tar == nxt) {
                        ans = true;
                        break;
                    }
                }
                if (ans) {
                    break;
                }
            }
            System.out.println(ans ? 'T' : 'F');
        }
    }
}
