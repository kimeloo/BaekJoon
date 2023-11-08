l=open(0).readlines()[1:]
for i in l:
    r,e,c=map(int,i.split())
    if r+c<e:
        print("advertise")
    elif r+c>e:
        print("do not advertise")
    else:
        print("does not matter")