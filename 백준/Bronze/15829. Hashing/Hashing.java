import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int l;
		long hash;
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		sc.nextLine();
		char[] str = sc.nextLine().toCharArray();
		sc.close();
		
		hash = 0;
		for (int i=0; i<str.length; i++) {
			hash += (str[i]-'a'+1)*Math.pow(31, i);
		}
		System.out.println(hash%1234567891L);
	}
}
