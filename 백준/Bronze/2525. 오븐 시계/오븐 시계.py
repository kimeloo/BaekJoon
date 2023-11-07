h, m = input().split()
e = int(input())
h = int(h)
m = int(m)
if e+m>59:
    h+=(e+m)//60
    m=(e+m)%60
else:
    m+=e
if h>23:
    h=h%24
print(f'{h} {m}')