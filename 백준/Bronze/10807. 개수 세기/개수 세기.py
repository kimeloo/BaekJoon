import sys

sys.stdin.readline().strip()
nums = list(map(int, sys.stdin.readline().split()))
v = int(sys.stdin.readline().strip())
s = 0
for i in nums:
    if i==v:
        s += 1

print(s)