import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String line = st.nextToken();

		int n = 0;
		int idx = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != '*') {
				n += (line.charAt(i) - '0') * (i % 2 == 0 ? 1 : 3);
			} else {
				idx = i;
			}
		}
		n = (10 - (n%10))%10;
		if (idx%2==0) {
			System.out.println(n);
		} else {
			for (int i=0; i<10; i++) {
				if ((i*10+n)%3==0) {
					System.out.println((i*10+n)/3);
					break;
				}
			}
		}
	}
}
