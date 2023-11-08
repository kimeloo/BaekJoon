def pos(x):
    if x[0]==x[1]:
        r=x[2]
    elif x[1]==x[2]:
        r=x[0]
    else:
        r=x[1]
    return r
l=open(0).readlines()
x=[]
y=[]
for k in l:
    k=k.split()
    x.append(k[0])
    y.append(k[1])
print(pos(x), pos(y))