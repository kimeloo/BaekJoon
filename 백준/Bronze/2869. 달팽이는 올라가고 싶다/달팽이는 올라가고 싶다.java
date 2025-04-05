import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        int cnt = 1;
        v -= a;
        cnt += v/(a-b) + (v%(a-b)>0?1:0);
        System.out.println(cnt);
        sc.close();
    }
}
