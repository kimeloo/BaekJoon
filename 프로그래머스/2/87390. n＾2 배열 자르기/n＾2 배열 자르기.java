class Solution {
    public int[] solution(int n, long left, long right) {
        int current, startX, startY, endX, endY;         // endXY는 포함x (X<endX , Y<endY)
        int[] answer = new int[(int) (right-left)+1];
        
        startX = (int) left/n;
        startY = (int) left%n;
        endX = (int) right/n;
        endY = (int) right%n;
        
        for (int i=0; i<=((int) (right-left)); i++){
            answer[i] = (int) Math.max((left+i)/n,(left+i)%n)+1;
        }
        
        
        return answer;
    }
}