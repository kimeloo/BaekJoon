import heapq

inputLines = open(0).readlines()
N, M = map(int, inputLines[0].split())

nextProb = [[]for _ in range(N+1)]
inDegree = [0 for _ in range(N+1)]
queue = []

for i in range(M):
    prev, next = map(int, inputLines[i+1].split())
    nextProb[prev].append(next)
    inDegree[next] += 1

for i in range(1, N+1):
    if inDegree[i] == 0:
        heapq.heappush(queue, i)

while queue:
    now = heapq.heappop(queue)
    for next in nextProb[now]:
        inDegree[next] -= 1
        if inDegree[next] == 0:
            heapq.heappush(queue, next)
    print(now, end=" ")
