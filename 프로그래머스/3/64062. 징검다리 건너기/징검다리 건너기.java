class Solution {
	public int solution(int[] stones, int k) {
		// stone 원소 값에 집중하여 계산해보기
		int left, mid, right, streamCnt;
		boolean flag;
		left = Integer.MAX_VALUE;
		right = Integer.MIN_VALUE;
		for (int stone:stones) {
			left = Math.min(left, stone);
			right = Math.max(right, stone);
		}		
        mid = (left+right)/2;
        // mid = 0;
		while (left<mid&&mid<right) {
            
			streamCnt = 0;
			flag = true;
			for (int stone:stones) {
                mid = (left+right)/2;
				if (stone<mid) {
					streamCnt++;
				} else {
                    streamCnt = 0;
                }
				if (streamCnt==k) {
					flag = false;
					break;
				}
			}
			if (flag) {
				left = mid;
			} else {
				right = mid;
			}
            mid = (left+right)/2;
		}
		
		int answer = mid;
		return answer;
	}
}