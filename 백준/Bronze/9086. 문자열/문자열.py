import sys

n = int(sys.stdin.readline().strip())
for _ in range(n):
    string = sys.stdin.readline().strip()
    print(string[0],string[-1],sep="")