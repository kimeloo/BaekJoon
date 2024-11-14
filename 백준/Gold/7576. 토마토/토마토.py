import sys
from collections import deque

def inp():
    width, height = map(int, sys.stdin.readline().split())
    tomatoes = []
    for _ in range(height):
        tomatoes.append(list(map(int, sys.stdin.readline().split())))
    return tomatoes, (height, width)

def simulate(tomatoes, max_yx):
    ripe = deque()
    for y in range(max_yx[0]):
        for x in range(max_yx[1]):
            if tomatoes[y][x] == 1:
                ripe.append((y,x))
    while ripe:
        y, x = ripe.popleft()
        dx = [1, -1, 0, 0]      #동서남북
        dy = [0, 0, 1, -1]
        for i in range(4):
            new_x, new_y = x+dx[i], y+dy[i]
            if (new_x < 0) or (new_y < 0) or (new_x >= max_yx[1]) or (new_y >= max_yx[0]):      # 좌표 범위 초과
                continue
            if tomatoes[new_y][new_x] == 0:
                tomatoes[new_y][new_x] = tomatoes[y][x] + 1
                ripe.append((new_y, new_x))
    ans = 0
    for y in range(max_yx[0]):
        for x in range(max_yx[1]):
            if tomatoes[y][x] == 0:
                print(-1)
                exit(0)
        ans = max(ans, max(tomatoes[y]))
    print(ans-1)




def main():
    tomatoes, max_yx = inp()
    simulate(tomatoes, max_yx)

if __name__ == '__main__':
    main()