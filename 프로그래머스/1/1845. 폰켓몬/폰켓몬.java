import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        int max = nums.length/2;
        HashSet<Integer> set = new HashSet<>();
        for (int n:nums){
            set.add(n);
        }
        max = Math.min(max, set.size());
        int answer = max;
        return answer;
    }
}