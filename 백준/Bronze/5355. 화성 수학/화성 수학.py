l=open(0).readlines()
for n in l[1:]:
    nl=n.split()
    k=float(nl[0])
    for i in nl[1:]:
        if i=='@':
            k*=3
        elif i=='%':
            k+=5
        elif i=='#':
            k-=7
    print('{:.2f}'.format(k))