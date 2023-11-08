v=open(0).readlines()[1:][0][:-1]
a=len(v)
v=v.replace("A","")
b=len(v)
a-=b
print("A"*(a>b)+"B"*(a<b)+"Tie"*(a==b))