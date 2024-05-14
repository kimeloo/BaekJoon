import sys

n, m = map(int, sys.stdin.readline().split())

name_dict = dict()
by_idx = [""]
for idx in range(n):
    name = sys.stdin.readline().strip()

    name_dict[name] = idx+1
    by_idx.append(name)

for _ in range(m):
    find_value = sys.stdin.readline().strip()
    try:
        find_idx = int(find_value)
        print(by_idx[find_idx])
    except:
        print(name_dict[find_value])