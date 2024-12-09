import sys
import heapq

class Heap():
    def __init__(self):
        dummy = 1
        bean = (abs(dummy), dummy)
        self.length = 0
        self.nums = dict()
        self.heap = []
        heapq.heapify(self.heap)
        
    def push(self, n):
        # n_order 뒤 6자리는, 자리수를 나타냄
        # 특히, 첫자리는 부호(양수2, 음수1), 뒤 5자리는 순서를 나타내며, 순서는 self.nums에 저장
        n_abs = abs(n)
        self.nums[n_abs] = 1 + 0 if (n_abs not in self.nums) else self.nums[n_abs]
        sign = 2 if n>0 else 1
        cnt = self.nums[n_abs]
        n_order = n_abs*1000000 + sign*100000 + cnt

        bean = (n_order, n)
        self.length += 1
        heapq.heappush(self.heap, bean)
    
    def pop(self):
        if self.length:
            self.length -= 1
            bean = heapq.heappop(self.heap)
            return bean[1]
        return 0
    
    def exec(self, n):
        if n!=0:
            self.push(n)
        else:
            print(self.pop())
        
def main():
    heap = Heap()
    n = int(sys.stdin.readline().strip())
    for _ in range(n):
        x = int(sys.stdin.readline().strip())
        heap.exec(x)

if __name__== '__main__':
    main()