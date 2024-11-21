import sys

k = int(sys.stdin.readline().strip())
d1, d2 = map(int, sys.stdin.readline().split())

# k^2 = a^2 + b^2
# a = (d1-d2)/2
# b^2 = result

print((k**2)-((d1-d2)/2)**2)