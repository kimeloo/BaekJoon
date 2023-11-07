l=open(0).readlines()
for i in l[1:]:
    i=i.split()
    p=""
    for w in i[1]:
        p+=int(i[0])*w
    print(p)