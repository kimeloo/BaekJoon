import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n, targetLen;
		int[] numPool;
		ArrayList<Integer> temp, temp2;
		StringBuilder sb;
		HashSet<String> result = new HashSet<>();
		ArrayDeque<ArrayList<Integer>> stack = new ArrayDeque<>();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		targetLen = sc.nextInt();
		numPool = new int[n];
		for (int i = 0; i < n; i++) {
			numPool[i] = sc.nextInt();
		}
		Arrays.sort(numPool);
		sc.close();

		for (int i = 0; i < n; i++) {
			temp = new ArrayList<>();
			temp.add(numPool[i]);
			stack.offer(temp);
		}
		while (stack.size() > 0) {
			temp = stack.poll();
			if (temp.size() == targetLen) {
				sb = new StringBuilder();
				for (int k : temp) {
					sb.append(k + " ");
				}
				result.add(sb.toString());
				continue;
			} 
			for (int i=0; i<n; i++) {
				temp2 = new ArrayList<>();
				temp2.addAll(temp);
				if (numPool[i]>=temp2.get(temp2.size()-1)) {
					temp2.add(numPool[i]);
					stack.offer(temp2);
				}
			}
		}
		ArrayList<String> tempResult = new ArrayList<>(result);
		Collections.sort(tempResult, (o1, o2) -> {
			String[] o1temp1 = ((String) o1).split(" "); 
			String[] o2temp1 = ((String) o2).split(" ");
			int[] o1temp2 = new int[o1temp1.length];
			int[] o2temp2 = new int[o2temp1.length];
			for (int i=0; i<o1temp1.length; i++) {
				o1temp2[i] = Integer.parseInt(o1temp1[i]);
				o2temp2[i] = Integer.parseInt(o2temp1[i]);
			}
			return Arrays.compare(o1temp2, o2temp2);
		});
		for (String r : tempResult) {
			System.out.println(r);
		}
	}
}
