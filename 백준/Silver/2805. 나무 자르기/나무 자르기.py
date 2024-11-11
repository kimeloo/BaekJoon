import sys

n, target = map(int, sys.stdin.readline().split())

trees = list(map(int, sys.stdin.readline().split()))
trees.sort()

start, end = 0, trees[-1]

while start <= end:
    mid = (start+end)//2
    cut = 0
    for tree in trees:
        if tree > mid:
            cut += tree-mid
    
    if cut >= target:
        start = mid+1
    else:
        end = mid-1
print(end)