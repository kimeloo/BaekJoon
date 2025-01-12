import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n, m, maxSum, currentSum, large, small;
        boolean nIsSmall;
        for (int tc=1; tc<=t; tc++) {
            System.out.print("#"+tc+" ");
            n = scanner.nextInt();
            m = scanner.nextInt();
            maxSum = 0;
            nIsSmall = false;
            int[] arrayA = new int[n];
            int[] arrayB = new int[m];
            for (int i=0; i<n; i++) {
            	arrayA[i] = scanner.nextInt();
            }
            for (int i=0; i<m; i++) {
            	arrayB[i] = scanner.nextInt();
            }
            large = Math.max(n,m);
            small = Math.min(n,m);
            if (small==n) {
                nIsSmall = true;
            }
            for (int i=0; i<=(large-small); i++) {
                currentSum = 0;
            	for (int j=0; j<small; j++) {
                    if (nIsSmall) { currentSum += arrayA[j] * arrayB[i+j]; }
                	else { currentSum += arrayA[i+j]*arrayB[j]; }
                    // System.out.println("i = "+i+" / j = "+j);
                }
                // System.out.println(currentSum);
                maxSum = Math.max(maxSum, currentSum);
            }
            System.out.println(maxSum);
        }
        scanner.close();
	}
}