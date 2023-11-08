l=open(0).readlines()[1:]
q,w,e,r,a=[0]*5
for i in l:
    x,y=map(int,i.split())
    if x*y==0:
        a+=1
    elif x*y>0:
        if x>0:
            q+=1
        else:
            e+=1
    else:
        if x>0:
            r+=1
        else:
            w+=1
print(f'Q1: {q}\nQ2: {w}\nQ3: {e}\nQ4: {r}\nAXIS: {a}')