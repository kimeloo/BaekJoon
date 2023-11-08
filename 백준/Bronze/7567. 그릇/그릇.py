s=open(0).readline()[:-1]
p=10
for i in range(1,len(s)):
    p+=5
    if s[i]!=s[i-1]:
        p+=5
print(p)