import sys

n = int(sys.stdin.readline().strip())
scores = list(map(int, sys.stdin.readline().split()))

m = max(scores)

s = 0
for score in scores:
    s += (score/m)*100
print(s/n)