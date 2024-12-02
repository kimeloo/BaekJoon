import sys
import heapq

class Heap():
    def __init__(self):
        self.heap=[]
        heapq.heapify(self.heap)
        self.length=0
    
    def push(self, n):
        heapq.heappush(self.heap, n)
        self.length+=1
    
    def pop(self):
        self.length-=1
        return heapq.heappop(self.heap)
        
    
    def exec(self, n):
        if n==0:
            if self.length>0:
                print(-self.pop())
            else:
                print(0)
        else:
            self.push(-n)

def main():
    n = int(sys.stdin.readline().strip())
    heap = Heap()
    for _ in range(n):
        k = int(sys.stdin.readline().strip())
        heap.exec(k)

if __name__ == '__main__':
    main()