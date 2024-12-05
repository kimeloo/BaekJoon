import sys
from collections import deque

def main():
    t = int(sys.stdin.readline().strip())
    for _ in range(t):
        start, target = map(int, sys.stdin.readline().split())
        result = bfs(start, target)
        print(result)

def bfs(start, target):
    visited = [False] * 10000
    queue = deque([(start, "")])
    visited[start] = True

    while queue:
        current, path = queue.popleft()
        
        if current == target:
            return path

        d_num = (current * 2) % 10000
        if not visited[d_num]:
            visited[d_num] = True
            queue.append((d_num, path + "D"))

        s_num = (current - 1 + 10000) % 10000
        if not visited[s_num]:
            visited[s_num] = True
            queue.append((s_num, path + "S"))

        l_num = (current % 1000) * 10 + (current // 1000)
        if not visited[l_num]:
            visited[l_num] = True
            queue.append((l_num, path + "L"))

        r_num = (current % 10) * 1000 + (current // 10)
        if not visited[r_num]:
            visited[r_num] = True
            queue.append((r_num, path + "R"))

    return ""

if __name__ == '__main__':
    main()