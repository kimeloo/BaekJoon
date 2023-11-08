l=open(0).readlines()[:-1]
for i in range(len(l)):
    a,b=map(int,l[i].split())
    if a>b:
        print("Yes")
    else:
        print("No")