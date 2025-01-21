import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		int t, maxFreq, maxScore;
		int[] scores;
		Scanner scanner = new Scanner(System.in);
		
		t = scanner.nextInt();
		for (int tc=1; tc<=t; tc++) {
			scores = new int[101];
			maxFreq = 0;
			maxScore = 0;
			scanner.nextInt();
			for (int std=0; std<1000; std++) {
				scores[scanner.nextInt()] += 1;
			}
			
			for (int score=0; score<101; score++) {
				if (scores[score]>maxFreq) {
					maxFreq = scores[score];
					maxScore = score;
				}
				else if (scores[score] == maxFreq){
					if (score > maxScore) {
						maxScore = score;
					}
				}
			}
			
			System.out.println("#"+tc+" "+maxScore);
			
			
		}
		
		
		scanner.close();
	}
}
