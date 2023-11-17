# 누적시간 = 모두 0인 리스트 생성
# indegree = 진입차수
# 이전 건물이 존재한다면, 진입차수에 +1
# 1. require가 없는 건물부터 시작 = 진입차수가 0
# 1-1. 진입차수가 처음부터 0인 건물은, 누적시간 = 건설시간
# 2. 0인 건물을 현재건물로 pop해오고, 다음건물들 진입차수 -1
# 2-1. for 다음건물 in 다음건물목록: 다음 건물의 누적시간 = max(다음 건물의 누적시간, 현재 건물의 누적시간+다음건물 건설시간)

from collections import deque

if __name__=='__main__':
    inputLines=open(0).readlines()[1:]

    while True:
        if len(inputLines)==0:
            break
        n, k = map(int, inputLines[0].split())
        workingLines=inputLines[1:k+3]
        inputLines=inputLines[k+3:]
        
        # 건물별 소요시간, 필요건물, 진입차수 저장
        nextList=[]
        indegree=[0]*n
        totalTime=[0]*n
        for i in range(n):
            nextList.append([])

        timeList=list(map(int, workingLines[0].split()))
        target=int(workingLines[-1])
        for line in workingLines[1:-1]:
            before, after = map(int, line.split())
            nextList[before-1].append(after)
            indegree[after-1] += 1

        dq = deque()
        for i in range(n):
            if indegree[i]==0:
                totalTime[i]=timeList[i]
                dq.append(i+1)
        
        # 누적시간 구하기
        while True:
            try:
                current = dq.popleft()
            except:
                print(totalTime[target-1])
            if current == target:
                print(totalTime[target-1])
                break
            for next in nextList[current-1]:
                indegree[next-1]-=1
                totalTime[next-1] = max(totalTime[next-1], timeList[next-1]+totalTime[current-1])
                if indegree[next-1]==0:
                    dq.append(next)