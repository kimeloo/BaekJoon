import java.util.Scanner;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        int t, n, curY, curX, curT, nextY, nextX;
        boolean reachable;
        ArrayList<Integer> tempList = new ArrayList<>();
        int[] startYXt = new int[3];
        int[] targetYX = new int[2];
        int[] currentYXt = new int[3];
        int[] currentYX = new int[2];
        int[] nextYXt = new int[3];
        int[] dy = new int[4];
        int[] dx = new int[4];
        Scanner scanner = new Scanner(System.in);
        Deque<int[]> dq = new ArrayDeque<>();
        HashSet<ArrayList<Integer>> visited = new HashSet<>();
        t = scanner.nextInt();
        dy = new int[]{0, 0, 1, -1};
        dx = new int[]{1, -1, 0, 0};
        for (int tc=1; tc<=t; tc++) {
        	System.out.print("#"+tc+" ");
            // 1. 입력값 할당, 초기화
            dq.clear();
            visited.clear();
            n = scanner.nextInt();
            reachable = false;
            curT = 0;
            int[][] ocean = new int[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                	ocean[i][j] = scanner.nextInt();
                }
            }
            startYXt[0] = scanner.nextInt();
            startYXt[1] = scanner.nextInt();
            startYXt[2] = 0;
            targetYX[0] = scanner.nextInt();
            targetYX[1] = scanner.nextInt();
            dq.offer(startYXt);
            // 2. 로직 (BFS)
            while (!dq.isEmpty()) {
            	// deque : offer(뒤에 추가), poll(앞에서 제거) -> exception 대신 false / null
                currentYXt = dq.poll();
                curY = currentYXt[0];
                curX = currentYXt[1];
                curT = currentYXt[2];
               	currentYX = new int[]{curY, curX};
                //	2.1. 현재 좌표 검사
               	tempList.clear();
               	tempList.add(curY);
               	tempList.add(curX);
                if (visited.contains(tempList)) { continue; }
                if (Arrays.equals(currentYX, targetYX)) {
                	reachable = true;
                	break;
                	}
                if ((ocean[curY][curX] == 2)&&(curT%3!=0)) {
                    nextYXt = new int[]{curY, curX, curT+1};
                    dq.offer(nextYXt);
                    continue;
                }
                visited.add(tempList);
                if (ocean[curY][curX]==1) {
//                	System.out.println("PASS");
                	continue; }

                // 2.2 다음 좌표 탐색
                
                for (int i=0; i<4; i++) {
                    nextY = curY + dy[i];
                    nextX = curX + dx[i];
                    if ((nextY<0)||(nextX<0)||(nextY>=n)||(nextX>=n)) { continue; }
                   	tempList.clear();
                   	tempList.add(nextY);
                   	tempList.add(nextX);
                    if (visited.contains(tempList)) { continue; }
                    nextYXt = new int[]{nextY, nextX, curT+1};
                    dq.offer(nextYXt);
                    
                }
            }
            if (reachable) { System.out.println(curT); }
            else { System.out.println(-1); }
        }
        scanner.close();
    }
}