from collections import deque

orderQueue = deque()
inputList = open(0).readlines()

myNext = []
myWeight = []
N, M = map(int,inputList[0].split())
for i in range(N+1):
    myNext.append([])
    myWeight.append(0)

for inputLine in inputList[1:]:
    orderList = list(map(int, inputLine.split()))[1:]
    index = 0
    while index<len(orderList):
        now = orderList[index]
        try:
            next = orderList[index+1]
        except:
            index += 1
            continue
        myNext[now].append(next)
        myWeight[next] += 1
        index += 1

for singer in range(1,N+1):
    if myWeight[singer] == 0:
        orderQueue.append(singer)

printList = []
while orderQueue:
    now = orderQueue.popleft()
    for next in myNext[now]:
        myWeight[next] -= 1
        if myWeight[next] == 0:
            orderQueue.append(next)
    printList.append(now)
if len(printList) == N:
    for singer in printList:
        print(singer)
else:
    print(0)