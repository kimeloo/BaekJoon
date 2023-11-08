l=open(0).readlines()[1:]
c=1
for i in l:
    if c==1 or c%9==0:
        try:
            y=sum(y)
            k=sum(k)
            print("Yonsei"*(y>k)+"Korea"*(y<k)+"Draw"*(y==k))
        except:
            pass
        y,k=[[],[]]
    a,b=map(int,i.split())
    y.append(a)
    k.append(b)
    c+=1