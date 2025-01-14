import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		int t, s, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc=1; tc<=t; tc++) {
			System.out.print("#"+tc+" ");
			s = 0;
			for (int i=0; i<10; i++) {
				n = sc.nextInt();
				if (n%2==1) {
					s+=n;
				}
			}
			System.out.println(s);
		}
		sc.close();

	}

}
