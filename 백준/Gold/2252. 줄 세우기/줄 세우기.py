from collections import deque

input_list = open(0).readlines()
n, m = map(int, input_list[0].split())

dq = deque()
st_list = []
for _ in range(n):
    st_list.append([])
indegree = [0]*n

for line in input_list[1:]:
    a, b = map(int, line.split())
    st_list[a-1].append(b)
    indegree[b-1]+=1

for i in range(0, n):
    if indegree[i] == 0:
        dq.append(i)

result = []
while dq:
    current = dq.popleft()
    result.append(current+1)
    for next in st_list[current]:
        indegree[next-1]-=1
        if indegree[next-1]==0:
            dq.append(next-1)
for i in result:
    print(i, end=" ")