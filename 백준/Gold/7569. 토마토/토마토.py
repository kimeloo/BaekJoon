import sys
from collections import deque

def inp():
    m, n, h = map(int, sys.stdin.readline().split())
    tomatoes = []
    for z in range(h):
        tomatoes.append([])
        for y in range(n):
            tomatoes[z].append(list(map(int, sys.stdin.readline().split())))
    return tomatoes, h, n, m

def find_tomato(tomatoes):
    # 모든 토마토가 익어있으면 False return, 하나라도 안 익은 경우는 익은 토마토 좌표 return
    flag = True
    ripen = []
    for z, lines in enumerate(tomatoes):
        for y, line in enumerate(lines):
            for x, tmt in enumerate(line):
                if tmt==1:
                    ripen.append((z,y,x,1))
                if tmt==0:
                    flag = False
    if flag:
        return False
    return ripen

def check(z,y,x,h,n,m,tomatoes):
    if (z>=h) or (y>=n) or (x>=m) or (z<0) or (y<0) or (x<0):
        return False
    if tomatoes[z][y][x]==0:
        return True
    return False

def find_next(z,y,x,h,n,m, count, tomatoes):
    dx = [1,-1,0,0,0,0]     # 동서남북상하
    dy = [0,0,1,-1,0,0]
    dz = [0,0,0,0,1,-1]
    nextzyx = []
    for i in range(6):
        nx, ny, nz = x+dx[i], y+dy[i], z+dz[i]
        if check(nz,ny,nx,h,n,m, tomatoes):
            nextzyx.append((nz,ny,nx,count+1))
    # print('next:',nextzyx)
    return nextzyx

def bfs(ripen, h, n, m, tomatoes):
    queue = deque()
    queue.extend(ripen)
    visited = set()
    while queue:
        z, y, x, count = queue.popleft()
        # print(count, x, y, z)
        if (z,y,x) in visited:
            continue
        visited.add((z,y,x))
        if tomatoes[z][y][x]!=-1:
            tomatoes[z][y][x] = count
            queue.extend(find_next(z,y,x,h,n,m,count,tomatoes))
    return tomatoes

def last_check(tomatoes):
    if find_tomato(tomatoes):
        return -1           # 안익은 토마토가 있음
    max_cnt = 0
    for z in tomatoes:
        for y in z:
            for x in y:
                if max_cnt < x:
                    max_cnt = x
    return max_cnt-1

def simulate(tomatoes, h, n, m):
    ripen = find_tomato(tomatoes)
    # print(f'\n{not ripen}\n')
    if not ripen:           # 안익은 토마토 없음
        if type(ripen)==bool:
            print(0)
        else:
            print(-1)
        exit(0)
    tomatoes = bfs(ripen, h, n, m, tomatoes)
    # print('\n')
    # for lines in tomatoes:
    #     print(*lines,sep="\n")
    # print('\n')
    print(last_check(tomatoes))

def main():
    tomatoes, h, n, m = inp()
    simulate(tomatoes, h, n, m)

if __name__ == '__main__':
    main()