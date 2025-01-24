import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n, t, p, tCnt;
		int[] size = new int[6];
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < 6; i++) {
			size[i] = sc.nextInt();
		}
		t = sc.nextInt();
		p = sc.nextInt();

		tCnt = 0;
		for (int i = 0; i < 6; i++) {
			tCnt += size[i] / t;
			if (size[i] % t != 0) {
				tCnt++;
			}
		}

		System.out.println(tCnt);
		System.out.println(n/p+" "+n%p);

		sc.close();
	}

}