h,m=map(int,open(0).readline().split())
m+=15
if m>59:
    print(h,m-60)
elif h-1<0:
    print(h+23,m)
else:
    print(h-1,m)