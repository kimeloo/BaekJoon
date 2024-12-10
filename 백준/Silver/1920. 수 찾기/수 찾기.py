import sys

n = int(sys.stdin.readline().strip())
an = set(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline().strip())
bn = list(map(int, sys.stdin.readline().split()))

for num in bn:
    if num in an:
        print(1)
    else:
        print(0)