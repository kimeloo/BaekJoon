import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		for (int i = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()); i >0; i--) {
			System.out.println(i);
		}
	}
}