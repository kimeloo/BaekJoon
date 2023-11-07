s=int(open(0).readline())
s=int(s/10)
if s>8:
    r="A"
elif s==8:
    r="B"
elif s==7:
    r="C"
elif s==6:
    r="D"
else:
    r="F"
print(r)