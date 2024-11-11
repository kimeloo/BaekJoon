import sys


a, b = map(int, sys.stdin.readline().split())
result = a-b
result = result * (1 if result>=0 else -1)
print(result)