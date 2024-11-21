import sys

a, b = sys.stdin.readline().split()

s = 0
for aa in a:
    for bb in b:
        s += int(aa)*int(bb)
print(s)