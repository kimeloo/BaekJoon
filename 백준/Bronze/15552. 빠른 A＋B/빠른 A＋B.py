import sys

n = int(sys.stdin.readline().strip())
for _ in range(n):
    a,b = map(int, sys.stdin.readline().split())
    sys.stdout.write(f'{a+b}\n')