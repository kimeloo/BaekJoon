import sys
import heapq

if __name__ == '__main__':
    count = int(sys.stdin.readline().strip())
    heap = []
    for _ in range(count):
        n = int(sys.stdin.readline().strip())
        if n!=0:
            heapq.heappush(heap, n)
        else:
            try:
                print(heapq.heappop(heap))
            except:
                print(0)