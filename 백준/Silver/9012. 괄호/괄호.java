import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int T, cnt;
		boolean result;
		char[] line;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder out = new StringBuilder();

		T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			cnt = 0;
			line = st.nextToken().toCharArray();
			result = true;
			for (char c : line) {
				if (c == '(') {
					cnt++;
				} else if (cnt > 0) {
					cnt--;
				} else {
					result = false;
					break;
				}
			}
			if (result && cnt == 0) {
				out.append("YES");
			} else {
				out.append("NO");
			}
			out.append("\n");
		}
		System.out.print(out);

		br.close();
	}
}