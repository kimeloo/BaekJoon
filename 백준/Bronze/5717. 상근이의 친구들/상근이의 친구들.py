l=open(0).readlines()[:-1]
for i in l:
    a,b=map(int,i.split())
    print(a+b)