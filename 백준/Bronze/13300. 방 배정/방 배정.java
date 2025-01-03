import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// 리스트에 학년,성별 구분하여 인원수 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] list = line.split(" ");
		int n = Integer.parseInt(list[0]);
		int k = Integer.parseInt(list[1]);
		int result = 0;
		int[] students = new int[13];
		for (int i=0; i<n; i++) {
			line = br.readLine();
			list = line.split(" ");
			int gender = Integer.parseInt(list[0]);
			int grade = Integer.parseInt(list[1]);
			students[(gender*6)+grade] += 1;	
		}
		
		for (int stds:students) {
			result += stds/k;
			result += (stds%k==0)?0:1;
		}
		System.out.println(result);
	}

}
