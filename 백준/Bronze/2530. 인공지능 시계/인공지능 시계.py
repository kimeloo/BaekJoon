h, m, s = input().split()
e = int(input())
h = int(h)
m = int(m)
s = int(s)
s+=e
if s>59:
    m+=s//60
    s=s%60
if m>59:
    h+=m//60
    m=m%60
if h>23:
    h=h%24
print(f'{h} {m} {s}')