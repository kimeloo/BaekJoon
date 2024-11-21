import sys

n = int(sys.stdin.readline().strip())

x, s = map(int, sys.stdin.readline().split())

result = "NO"
for _ in range(n):
    c, p = map(int, sys.stdin.readline().split())
    if (c <= x) and (p > s):
        result = "YES"
print(result)