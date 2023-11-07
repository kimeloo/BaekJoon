l=list(map(int,open(0).readline().split()))
l.remove(max(l))
print(max(l))