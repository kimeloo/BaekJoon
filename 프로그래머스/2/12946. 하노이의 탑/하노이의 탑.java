import java.util.ArrayList;

class Solution {
    static ArrayList<int[]> ans;
    public void hanoi(int n, int start, int target, int temp){
        if (n==1){
            ans.add(new int[]{ start, target });
        } else {
            hanoi(n-1, start, temp, target);
            ans.add(new int[]{ start, target });
            hanoi(n-1, temp, target, start);
        }
    }
    
    public int[][] solution(int n) {
        int[][] answer;
        ans = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        answer = new int[ans.size()][2];
        for (int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}