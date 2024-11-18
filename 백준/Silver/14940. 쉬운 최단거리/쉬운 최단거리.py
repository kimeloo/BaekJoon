import sys
from collections import deque

def inp():
    n, m = map(int, sys.stdin.readline().split())
    nmap = []
    dmap = []
    target_yx = ()
    for y in range(n):
        new_nums = list(map(int, sys.stdin.readline().split()))
        if 2 in new_nums:
            target_yx = (y, new_nums.index(2), 0)
        nmap.append(new_nums)
        dmap.append([-99]*m)
    return nmap, target_yx, n, m, dmap

def simulate(nmap, target_yx, n, m, dmap):
    next_yx = deque()
    next_yx.append(target_yx)
    while next_yx:
        next_y, next_x, cnt = next_yx.popleft()
        if dmap[next_y][next_x] != -99:
            continue
        next_value = nmap[next_y][next_x]
        if next_value == 1:
            dmap[next_y][next_x] = cnt
        else:
            dmap[next_y][next_x] = 0
        if next_value != 0:
            next_yx.extend(get_next(next_y, next_x, n, m, cnt))
        # print(next_yx)
    return dmap

def get_next(y, x, n, m, cnt):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    nyx = []
    for i in range(4):
        new_y = y+dy[i]
        new_x = x+dx[i]
        if is_valid(new_y, new_x, n, m):
            nyx.append((new_y, new_x, cnt+1))
    return nyx
        

def is_valid(y, x, n, m):
    if (y>=n) or (y<0) or (x>=m) or (x<0):
        return False
    return True

def last_check_print(nmap, dmap):
    for y, nums in enumerate(dmap):
        for x, value in enumerate(nums):
            if value == -99:
                dmap[y][x] = -1
            if nmap[y][x] == 0:
                dmap[y][x] = 0
        print(*dmap[y], sep=" ")

def main():
    nmap, target_yx, n, m, dmap = inp()
    dmap = simulate(nmap, target_yx, n, m, dmap)
    last_check_print(nmap, dmap)

if __name__ == '__main__':
    main()