import sys

m1, m2, v1, v2 = 0, 0, 0, 0
d1, d2, m1 = map(int, sys.stdin.readline().split())
d1, d2 = max(d1, d2), min(d1, d2)
m2 = 100 - m1
v1 = m1/d1
v2 = m2/d2
print((m1+m2)/(v1+v2))