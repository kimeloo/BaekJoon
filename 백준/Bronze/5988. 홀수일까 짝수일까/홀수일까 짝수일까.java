import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String temp;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			temp = st.nextToken();
			out.append((temp.charAt(temp.length()-1) - '0') % 2 == 0 ? "even" : "odd").append("\n");
		}
		
		System.out.print(out);

		br.close();
	}

}
