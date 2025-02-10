class Solution {
	public int solution(int[] stones, int k) {
		// stone 원소 값에 집중하여 계산해보기
		int sml, mid, big, streamCnt;
		boolean flag;
		sml = Integer.MAX_VALUE;
		big = Integer.MIN_VALUE;
		for (int stone:stones) {
			sml = Math.min(sml, stone);
			big = Math.max(big, stone);
		}
		mid = (sml+big)/2;
		
		while (mid<big&&sml<mid) {
			streamCnt = 0;
			flag = true;
			for (int stone:stones) {
				// 처음부터 쭉 가다가, mid보다 작은 값이 k-1번 연속되면 break (mid 값이 너무 크다는 것임)
				// big = mid로 변경하고, mid 다시 정의
				// 만약 break 안되고 끝나면, sml = mid로 변경하고, mid 다시 정의
				
				// streamCnt : 연속하여 mid보다 작은 값이 나온 횟수
				if (stone>=mid && streamCnt>0) {	
					streamCnt = 0;
				} else if (stone<mid) {
					streamCnt++;
				}
				if (streamCnt==k) {
					flag = false;
					break;
				}
			}
			if (flag) {
				sml = mid;
				mid = (sml+big)/2;
			} else {
				big = mid;
				mid = (sml+big)/2;
			}
//			System.out.println((flag?1:0)+" "+sml+" "+mid+" "+big);
		}
		
		int answer = mid;
		return answer;
	}
}