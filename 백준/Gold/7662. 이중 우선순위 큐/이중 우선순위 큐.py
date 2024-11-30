# 숫자를 따로 기록해두고, 제거할 때 있는 수인지 체크하도록 하기
import sys
import heapq

class Heap():
    def __init__(self, debug=False):
        self.debug = False
        self.maxheap = []
        self.minheap = []
        self.nums = dict()
        self.len = 0
        heapq.heapify(self.maxheap)
        heapq.heapify(self.minheap)

        if debug:
            self.debug = True
    
    def consol(self, *args, **kwargs):
        if self.debug:
            print(*args, *list(kwargs.items()), sep=" ")

    
    def exec(self, cmd:str, n:int):
        if cmd=="I":
            self.push(n)
        elif cmd=="D":
            self.pop(n)

    def push(self,n:int):
        self.nums[n] = 1 + (0 if (n not in self.nums) else self.nums[n])
        self.len += 1
        heapq.heappush(self.maxheap, -n)
        heapq.heappush(self.minheap, n)
        
        self.consol(cmd='push', nums=self.nums, length=self.len)

    def pop(self,n:int):
        if self.len<=0:
            return "EMPTY"
        if n==1:        # 최댓값 삭제
            target = self.maxheap
        else:
            target = self.minheap
        while True:
            try:
                num = heapq.heappop(target)*(-n)
            except IndexError:
                return "EMPTY"
            if self.nums[num]:
                self.nums[num] -= 1
                self.len -= 1
                self.consol(cmd='pop', nums=self.nums, length=self.len)
                return num
    
    def result(self):
        max_value = self.pop(1)
        min_value = self.pop(-1)
        if max_value=="EMPTY":
            return "EMPTY"
        elif min_value=="EMPTY":
            return f'{max_value} {max_value}'
        return f'{max_value} {min_value}'

def main():
    t = int(sys.stdin.readline().strip())
    for _ in range(t):
        k = int(sys.stdin.readline().strip())
        heap = Heap(debug=False)
        for _ in range(k):
            cmd, n = sys.stdin.readline().split()
            heap.exec(cmd,int(n))
        print(heap.result())

if __name__ == '__main__':
    main()