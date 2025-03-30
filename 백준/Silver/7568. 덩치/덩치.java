import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Person {
	int height, weight;

	public Person(int h, int w) {
		this.height = h;
		this.weight = w;
	}

	boolean smallerThan(Person p) {
		if (p.height > this.height && p.weight > this.weight) {
			return true;
		}
		return false;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Person[] people = new Person[N];
		for (int i = 0; i < N; i++) {
			int h, w;
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			people[i] = new Person(h, w);
		}

		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (people[i].smallerThan(people[j]))
					cnt++;
			}
			System.out.print(cnt + " ");
		}

		br.close();
	}
}