c=open(0).readline()
s=0.0
if c[0]=="A":
    s+=4
elif c[0]=="B":
    s+=3
elif c[0]=="C":
    s+=2
elif c[0]=="D":
    s+=1
if c[1]=="+":
    s+=0.3
elif c[1]=="-":
    s-=0.3
print(s)