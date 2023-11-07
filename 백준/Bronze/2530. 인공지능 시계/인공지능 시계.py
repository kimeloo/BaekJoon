h, m, s = input().split()
e = int(input())
h = int(h)
m = int(m)
s = int(s)
if e+s>59:
    m+=(e+s)//60
    s=(e+s)%60
else:
    s+=e
if m>59:
    h+=m//60
    m=m%60
if h>23:
    h=h%24
print(f'{h} {m} {s}')