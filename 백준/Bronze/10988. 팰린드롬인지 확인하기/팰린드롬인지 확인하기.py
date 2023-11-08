l=input()
r=1
for i in range(1,len(l)+1):
    if l[i-1]!=l[-i]:
        r=0
print(r)