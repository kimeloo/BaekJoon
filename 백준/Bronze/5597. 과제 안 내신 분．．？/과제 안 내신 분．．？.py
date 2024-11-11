import sys

nums = [n for n in range(1,31)]
for _ in range(28):
    nums.remove(int(sys.stdin.readline().strip()))
nums.sort()
print(*nums,sep="\n")