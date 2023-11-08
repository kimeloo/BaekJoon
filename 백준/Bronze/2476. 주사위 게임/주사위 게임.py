l=open(0).readlines()[1:]
r=[]
for i in l:
    a,b,c=map(int,i.split())
    if len(set([a,b,c]))==1:
        p=a*1000+10000
    elif len(set([a,b,c]))==2:
        if a==b:
            p=a*100+1000
        else:
            p=c*100+1000
    else:
        p=max([a,b,c])*100
    r.append(p)
print(max(r))