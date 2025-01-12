import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int result = 0;
        for (int i=0; i<line.length(); i++) {
        	result += line.charAt(i)-'0';
        }
        System.out.println(result);
        scanner.close();
    }}