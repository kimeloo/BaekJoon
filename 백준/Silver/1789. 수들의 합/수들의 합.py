s=int(open(0).readline())
for i in range(1,s+1):
    s-=i
    if s<0:
        print(i-1)
        break
    elif s==0:
        print(i)
        break