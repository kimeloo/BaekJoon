y=list(map(int,open(0).readlines()))
for i in range(len(y)):
    if y[i]<40:
        y[i]=40
print(int(sum(y)/5))