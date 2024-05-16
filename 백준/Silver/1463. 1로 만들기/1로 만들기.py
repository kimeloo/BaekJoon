'''
target * 2만큼의 1차원 map 생성
각 칸에 몇번째 방문하는지 채우기
도달한 칸을 queue에 넣기
queue에서 하나씩 빼가며 다음 칸 넣기
다음 칸에 이미 도달한 적 있으면 pass

결국 target 도달하면 몇번째 방문인지 체크

'''

import sys
from collections import deque

if __name__ == '__main__':
    sys.setrecursionlimit(1000000)
    n = int(sys.stdin.readline().strip())
    find_map = [False for _ in range(n+1)]

    find_queue = deque()
    find_queue.append((n, 0))
    while find_queue:
        current, dep = find_queue.popleft()
        if current == 1:
            print(dep)
            break
        if find_map[current]:
            continue
        
        find_map[current] = True
        # print('test', current, dep)
        if current%2 == 0:
            find_queue.append((current//2, dep+1))
        if current%3 == 0:
            find_queue.append((current//3, dep+1))
        if current-1 >= 1:
            find_queue.append((current-1, dep+1))
