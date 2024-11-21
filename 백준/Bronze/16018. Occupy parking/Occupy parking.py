import sys

n = int(sys.stdin.readline().strip())
yesterday = list(sys.stdin.readline())
today = list(sys.stdin.readline())

cnt = 0
for i in range(n):
    if (yesterday[i]=="C" and today[i]=="C"):
        cnt += 1

print(cnt)