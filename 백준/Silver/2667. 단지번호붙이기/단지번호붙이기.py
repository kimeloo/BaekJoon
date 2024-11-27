import sys
from collections import deque

def inp():
    n = int(sys.stdin.readline().strip())
    nmap = []
    for _ in range(n):
        nmap.append(list(map(int,list(sys.stdin.readline().strip()))))
    return n, nmap

def get_nbrs(y,x,n):
    # 이웃 아파트의 좌표 목록을 반환
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    nbrs = []
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if (nx<0) or (ny<0) or (nx>=n) or (ny>=n):
            continue
        nbrs.append((ny,nx))
    return nbrs


def bfs(y, x, n, nmap):
    # y열 x행의 아파트부터 bfs로 이웃 아파트 탐색 및 cnt로 개수 카운트
    # visited로 방문한 아파트 저장
    queue = deque()
    queue.append((y,x))
    visited = set()
    cnt = 0
    while queue:
        y, x = queue.popleft()
        if (y,x) in visited:
            continue
        visited.add((y,x))
        if nmap[y][x] == 1:
            cnt += 1
            queue.extend(get_nbrs(y,x,n))
    return cnt, visited

def simulate(n, nmap):
    # 모든 좌표를 차례로 방문하여 아파트 여부 확인
    # 아파트이면, bfs로 단지 탐색
    # visited로 방문한 아파트 저장 및 bfs로 탐색한 아파트 역시 저장
    visited = set()
    cmplx = 0       # 단지 개수
    cmplx_cnt = []  # 단지별 아파트 개수
    for y in range(n):
        for x in range(n):
            if (y,x) in visited:
                continue
            if nmap[y][x] == 1:
                current_cnt, new_visited = bfs(y,x,n,nmap)
                cmplx += 1
                cmplx_cnt.append(current_cnt)
                visited.update(new_visited)
    return cmplx, cmplx_cnt

def main():
    n, nmap = inp()
    cnt, each = simulate(n, nmap)
    each.sort()
    print(cnt)
    print(*each, sep="\n")

if __name__ == '__main__':
    main()