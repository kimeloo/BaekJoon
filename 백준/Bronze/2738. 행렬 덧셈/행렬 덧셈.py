import sys

a, b, result = [], [], []

n, m = map(int, sys.stdin.readline().split())
for _ in range(n):
    a.append(list(map(int,sys.stdin.readline().split())))
    result.append([0 for _ in range(m)])
for _ in range(n):
    b.append(list(map(int,sys.stdin.readline().split())))
for y in range(n):
    for x in range(m):
        result[y][x] = a[y][x]+b[y][x]
    print(*result[y],sep=" ")