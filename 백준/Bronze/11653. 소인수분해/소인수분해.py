n=int(open(0).readline())
while True:
    t=0
    if n==0:
        break
    for i in range(2,n+1):
        if n%i==0:
            n=n//i
            t=1
            print(i)
            break
    if t==0:
        break