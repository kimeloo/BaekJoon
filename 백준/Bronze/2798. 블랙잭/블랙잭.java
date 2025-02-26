import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> nums = new ArrayList<Integer>();

		st = new StringTokenizer(br.readLine());
		int num;
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(st.nextToken());
			if (num < m) {
				nums.add(num);
			}
		}

		int result = Integer.MIN_VALUE;
		int temp;
		for (int i=0; i<n-2; i++) {
			for (int j=i+1; j<n-1; j++) {
				for (int k=j+1; k<n; k++) {
					temp = nums.get(i)+nums.get(j)+nums.get(k);
					if (temp<=m) {
						result = Math.max(result, temp);
					}
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}
}