l=open(0).readlines()[:-1]
for i in l:
    a,b=map(int,i.split())
    if not b%a:
        p="factor"
    elif not a%b:
        p="multiple"
    else:
        p="neither"
    print(p)