import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		long hash, num;
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		char[] str = sc.nextLine().toCharArray();
		sc.close();
		
		hash = 0;
		num = 1;
		for (int i=0; i<str.length; i++) {
			hash += (str[i]-'a'+1)*num;
			num = (num*31)%1234567891L; 
		}
		System.out.println(hash%1234567891L);
	}
}
